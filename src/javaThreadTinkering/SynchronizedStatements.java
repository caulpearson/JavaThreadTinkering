package javaThreadTinkering;

public class SynchronizedStatements {
	private boolean joy = false;
	private long c1 = 0;
	private long c2 = 0;
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	public void inc1() {
		synchronized(lock1){
			c1++;
		}
	}
	
	public void inc2() {
		synchronized(lock2) {
			c2++;
		}
	}
	
	public synchronized void setJoy() {
		try {
			Thread.sleep(3000);
		}catch(InterruptedException ex) {
			System.out.println(ex);
		}
		joy = !joy;
	}
	
	public synchronized void guardedJoy() {
		while(!joy) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		System.out.println("Joy acheived");
	}
}
