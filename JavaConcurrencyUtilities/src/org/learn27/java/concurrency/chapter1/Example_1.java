package org.learn27.java.concurrency.chapter1;

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
