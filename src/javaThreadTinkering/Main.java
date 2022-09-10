package javaThreadTinkering;

//public class Main implements Runnable {
//public class Main extends Thread {
public class Main{
//	public void run() {
//		System.out.println("This is printed from a thread");
//	}
	static void threadMessage(String message) {
		String threadName = Thread
				.currentThread()
				.getName();
		System.out.format("%s: %s%n",threadName, message);
	}
	public static class MessageLoop implements Runnable {
		public void run() {
			String numArray[] = {
				"one",
				"two",
				"three",
				"four"
			};
			try {
				for(int i=0;i<numArray.length;i++) {
					Thread.sleep(1000);
					threadMessage(numArray[i]);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				threadMessage("Interrupted Exception");
			}
		}
	}
	
	public static void main(String args[]) {
		
		long patience = 1000*60*60;
		if(args.length > 0) {
			try {
				patience = Long.parseLong(args[0]) * 1000;
			} catch (NumberFormatException e) {
				System.err.println("Argument must be integer");
				System.exit(1);
			}
		}
		
		threadMessage("Starting message loop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();
		threadMessage("MessageLoop now started");
		while(t.isAlive()) {
			threadMessage("Waiting");
			try {
				t.join(1000);
				if(((System.currentTimeMillis()-startTime)>patience)
						&& t.isAlive()) {
					threadMessage("Have grown tired of waiting");
					t.interrupt();
					t.join();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		threadMessage("Finally Complete");
	}
}
