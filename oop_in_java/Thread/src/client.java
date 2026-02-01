
public class client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyThread myThread1 = new MyThread();
        myThread1.start();
        MyThread myThread2 = new MyThread();
        myThread2.start();
        
        Thread thread =  new Thread(new MyRunnable());
        thread.start();
	}

}
