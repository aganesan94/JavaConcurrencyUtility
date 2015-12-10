package org.learn27.java.concurrency.chapter1;

/**
 * The following class shows how the threads can be created with an anonymous
 * inner class implementing the Runnable interface.
 * 
 * @author AGanesan
 *
 */
public class Example_1 {

	public static void main(String args[]) {

		// Anonymous Inner class
		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("I am going to keep running until i finish");
				}
			}

		});

		myThread.start();

	}

}
