package javaThreadTinkering;

//public class Main implements Runnable {
public class Main extends Thread {
	public void run() {
		System.out.println("This is printed from a thread");
	}
	public static void main(String args[]) {
		//(new Thread(new Main())).start();
		(new Main()).start();
	}
}
