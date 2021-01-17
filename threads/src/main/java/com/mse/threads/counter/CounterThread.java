package com.mse.threads.counter;

public class CounterThread implements Runnable {

	private Counter counter;
	private int maxCount;

	private boolean isRunning;

	public CounterThread(Counter counter, int maxCount) {
		this.counter = counter;
		this.maxCount = maxCount;
		isRunning = true;
	}

	@Override
	public void run() {
		isRunning = true;
		for (int i = 0; i < maxCount; i++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// System.out.println(Thread.currentThread().getName());
			counter.increment();
		}
		isRunning = false;
	}

	public synchronized boolean isRunning() {
		return isRunning;
	}

}
