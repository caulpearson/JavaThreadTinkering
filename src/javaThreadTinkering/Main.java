package javaThreadTinkering;

import ProducerConsumer.Consumer;
import ProducerConsumer.Drop;
import ProducerConsumer.Producer;
import javaThreadTinkering.Deadlock.Friend;

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
	public static void SimpleThread() {
		long patience = 1000*60*60;
		
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
	
	public static void TestDeadlock() {
		final Friend friend1 = new Friend("name1");
		final Friend friend2 = new Friend("name2");
		new Thread(new Runnable() {
			public void run() {
				friend1.bow(friend2);
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				friend2.bow(friend1);
			}
		}).start();
	}
	
	public static void main(String args[]) {
		//SimpleThread();
		//TestDeadlock();
		Drop drop = new Drop();
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
	}
}
