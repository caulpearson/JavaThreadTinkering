package javaThreadTinkering;
//class demonstrating a thread deadlock, as 
//in a situation where threads get forever
//locked
public class Deadlock {
	static class Friend {
		private final String name;
		public Friend(String name) {
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
		//if multiple threads call bow at once
		//it is likely that they will block when
		//calling bowBack
		public synchronized void bow(Friend bower) {
			System.out.format("%s: %s" + " "
					+ "has bowed to me!%n",
					this.name,bower.getName());
			bower.bowBack(this);
		}
		public synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s"
					+ " has bowed back to me!%n",
					this.name, bower.getName());
		}
		
	}
}
