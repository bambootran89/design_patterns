import java.io.IOException;
import java.nio.ByteBuffer;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;




public class Handler implements Runnable {
    
	private static final int MAXIN = 1024;

	private static final int MAXOUT = 1024;

	final SocketChannel socket;
	
	final SelectionKey sk;
	
	ByteBuffer input =  ByteBuffer.allocate(MAXIN);
	ByteBuffer output = ByteBuffer.allocate(MAXOUT);
	
	int count;
	int byteRead;
	
	private final static ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	
	static final int READING =0, SENDING =1, PROCESSING = 2;
	
	int state; 
	public Handler(Selector sel, SocketChannel c) throws IOException {
		// TODO Auto-generated constructor stub		
		socket = c;
		c.configureBlocking(false);
		sk = socket.register(sel, 0 /* SelectionKey.OP_READ */);
		sk.attach(this);
		sk.interestOps(SelectionKey.OP_READ );  // initial state is reader 
		state = READING;
		sel.wakeup();
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// initial state is reader 
		// READING -> PROCESSING --> SENDING ---> READING 
		try {			
			if(state == SENDING)
			      send(); 
			else if(state==READING) {
			      read();
			}	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	   
	}

	class Sender implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				send();				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void send()  throws IOException{
		// TODO Auto-generated method stub
	     socket.write(output);
	     if(outputIsComplete()) 
	    	 sk.cancel(); // close
	}
	private synchronized void read() throws IOException{
		// TODO Auto-generated method stub
		input.clear();
		
		count = 1;
		byteRead = 0;
		while(count > 0) {
			count  = socket.read(input);
	        if (count > -1) 
	        	byteRead = +count;
	        else 
	        	byteRead = count;		
		
		}
		
		
		if(inputIsComplete()) {
			state = PROCESSING;
			
            pool.execute(new Processer());			
		}
	}
	boolean inputIsComplete() { 
	
		return true;
	}
	boolean outputIsComplete() {
		
		return true;
	}
	void process() {/*   */}
	
	private void handleOfServerToClient() {
		state = SENDING;
		sk.attach(new Sender());
		sk.interestOps(SelectionKey.OP_WRITE);
        sk.selector().wakeup();
		
	}
	
	synchronized void processAndHandoff() {
		process();
		handleOfServerToClient();
		
	}
	class Processer implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			processAndHandoff();
		}
		
		
	}
	
	
}
