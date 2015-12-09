package org.learn27.java.concurrency.chapter1;

public class Example_3 {

	public static void main(String args[]) {
		Thread myThread = new MyThread();
		myThread.start();
	}
}

class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("I am in the counter " + i);
		}
	}

}