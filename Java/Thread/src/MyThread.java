public class MyThread extends Thread {	
	 
		public void run() {
			// TODO Auto-generated method stub
			while(true) System.out.println(this.toString() + " is running");
		}
}
