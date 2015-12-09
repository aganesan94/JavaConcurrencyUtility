package org.learn27.java.concurrency.chapter1;

public class Example_2 {

	public static void main(String args[]) {

		Thread myThread = new Thread(new MyRunnable());
		myThread.start();

	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println(" I am running the counter " + i);
		}

	}

}
