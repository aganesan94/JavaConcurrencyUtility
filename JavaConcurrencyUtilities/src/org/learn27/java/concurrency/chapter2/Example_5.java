package org.learn27.java.concurrency.chapter2;

public class Example_5 {

	// adding volatile does not fix the issue.
	private volatile int counter = 0;

	public static void main(String args[]) {
		Example_5 example3 = new Example_5();
		example3.demoInterleaving();
	}

	public void increment() {
		counter++;
	}

	private void demoInterleaving() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
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
		System.out.println(counter);
	}
}
