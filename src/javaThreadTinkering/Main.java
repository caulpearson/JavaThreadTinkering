package javaThreadTinkering;

public class Main implements Runnable {
	public void run() {
		System.out.println("This is printed from a thread");
	}
	public static void main(String args[]) {
		(new Thread(new Main())).start();
	}
}
