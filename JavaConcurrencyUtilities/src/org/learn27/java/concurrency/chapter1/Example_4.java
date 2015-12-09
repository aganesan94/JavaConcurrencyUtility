package org.learn27.java.concurrency.chapter1;

public class Example_4 {

	public static void main(String args[]) {
		Thread myThread = new ThreadProperties();
		myThread.setName("Thread - 1");
		printProperties(myThread);
		myThread.start();
		printProperties(myThread);
		try {
			myThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printProperties(myThread);
	}

	public static void printProperties(Thread myThread) {
		System.out.println(myThread.getName() + " :: " + myThread.getPriority() + "::" + myThread.getState());
	}

}

class ThreadProperties extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(
					"Currently executing the following thread : " + i + ":" + Thread.currentThread().getName());
		}
	}

}
