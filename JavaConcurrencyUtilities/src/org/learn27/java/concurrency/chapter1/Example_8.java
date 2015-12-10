package org.learn27.java.concurrency.chapter1;

/**
 * The following example shows to check to see if a thread is alive.
 * 
 * @author AGanesan
 *
 */
public class Example_8 {

	public static void main(String args[]) throws InterruptedException {
		Thread myThread = new ThreadIsAlive();
		myThread.start();
		while (myThread.isAlive()) {
			Thread.sleep(2000);
			System.out.println("Thread is alive " + Thread.currentThread().getName());
		}
		System.out.println("Thread has been TERMINATED");
	}

}

class ThreadIsAlive extends Thread {

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
