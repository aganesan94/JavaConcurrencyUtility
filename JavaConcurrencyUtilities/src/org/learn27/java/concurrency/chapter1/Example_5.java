package org.learn27.java.concurrency.chapter1;

public class Example_5 {

	public static void main(String args[]) {
		Thread myThread = new ThreadSleep();
		myThread.start();
	}

}

class ThreadSleep extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(
					"Currently executing the following thread : " + i + ":" + Thread.currentThread().getName());
		}
	}

}
