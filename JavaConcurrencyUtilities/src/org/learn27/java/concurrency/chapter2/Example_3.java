package org.learn27.java.concurrency.chapter2;

/**
 * The following methods demonstrates thread interleaving. If you run this
 * program the counter which is supposed to return 20000 will never return 20000
 * because of interleaving issues.
 * 
 * @author AGanesan
 *
 */
public class Example_3 {
	private int counter = 0;

	public static void main(String args[]) {
		Example_3 example3 = new Example_3();
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
