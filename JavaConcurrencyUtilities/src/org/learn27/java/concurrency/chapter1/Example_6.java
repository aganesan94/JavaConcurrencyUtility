package org.learn27.java.concurrency.chapter1;

/**
 * The following class shows how a thread is interrupted using the interrupt
 * method.
 * 
 * @author AGanesan
 *
 */
public class Example_6 {

	public static void main(String args[]) throws InterruptedException {
		Thread myThread = new ThreadSleep();
		myThread.start();

		Thread.sleep(10000);
		myThread.interrupt();
	}

}

class ThreadInterrupt extends Thread {

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
