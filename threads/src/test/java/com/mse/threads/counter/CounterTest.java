package com.mse.threads.counter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CounterTest {

	@Test
	void test_countOneThread() {
		Counter counter = new Counter();
		CounterThread worker = new CounterThread(counter, 10);
		Thread thread = new Thread(worker);
		thread.start();
		while (worker.isRunning()) {
			// do nothing
		}
		assertEquals(10, counter.getCount());
	}

	@Test
	void test_countTwoThreads() {
		Counter counter = new Counter();
		CounterThread worker1 = new CounterThread(counter, 100);
		CounterThread worker2 = new CounterThread(counter, 100);
		Thread thread1 = new Thread(worker1);
		Thread thread2 = new Thread(worker2);
		thread1.start();
		thread2.start();
		while (worker1.isRunning() || worker2.isRunning()) {
			// do nothing
		}
		assertEquals(200, counter.getCount());
	}

}
