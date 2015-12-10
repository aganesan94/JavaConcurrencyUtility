package org.learn27.java.concurrency.chapter2;

public class Example_3 {
	private int counter = 0;

	public static void main(String args[]) {
		Example_3 example3 = new Example_3();
		example3.demoInterleaving();
	}

	private void demoInterleaving() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					counter++;
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					counter++;
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
