package org.learn27.java.concurrency.chapter2;

/**
 * The following class shows how thread interleaving can take place and explains
 * the concept of a monitor lock or intrinsic loc applied on the instance
 * variables of the class.
 * 
 * @author AGanesan
 *
 */
public class Example_1 {

	private static int counter = 0;
	private static int MAX_COUNTER = 10;

	public static void main(String args[]) {
		Thread t1 = new IncrementListener();
		Thread t2 = new IncrementThread();
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	static class IncrementListener extends Thread {

		@Override
		public void run() {
			int local_counter = counter;
			while (local_counter < MAX_COUNTER) {
				if (local_counter != counter) {
					System.out.println("Value of counter has changed: " + counter);
					local_counter = counter;
				}
			}
		}

	}

	static class IncrementThread extends Thread {

		@Override
		public void run() {
			while (counter < MAX_COUNTER) {
				counter++;
				System.out.println("Increment counter to " + counter);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}