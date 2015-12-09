package org.learn27.java.concurrency.chapter1;

public class Example_7 {

	public static void main(String args[]) throws InterruptedException {
		Thread myThread = new ThreadJoin();
		myThread.start();
		myThread.join();
		System.out.println("First Thread Finished");
		Thread myThread1 = new ThreadJoin();
		myThread1.start();
	}

}

class ThreadJoin extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(
					"Currently executing the following thread : " + i + ":" + Thread.currentThread().getName());
		}
	}

}
