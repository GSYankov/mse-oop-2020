package com.edu.threads;

public class CounterThread implements Runnable {

	private int counter = 0;

	@Override
	public void run() {
		while (counter < 100) {
			counter++;
		}
		System.out.println("Done: " + counter);
	}

}
