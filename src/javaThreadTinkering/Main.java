package javaThreadTinkering;

//public class Main implements Runnable {
//public class Main extends Thread {
public class Main{
//	public void run() {
//		System.out.println("This is printed from a thread");
//	}
	public static void main(String args[]) {
		//(new Thread(new Main())).start();
		//(new Main()).start();
		
		String infoArray[] = {
				"one",
				"two",
				"three",
				"four"
		};
		for(int i=0;i<infoArray.length;i++) {
			try {
				Thread.sleep(1000);
				System.out.println(infoArray[i]);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}
}
