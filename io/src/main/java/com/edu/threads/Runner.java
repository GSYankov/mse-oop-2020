package com.edu.threads;

public class Runner {

	public static void main(String[] args) {
		Runnable counterLambda = () -> {
			int i = 0;
			for (i = 0; i < 100; i++) {
			}
			System.out.println("Done " + i);
		};

		// CounterThread runnable = new CounterThread();
		Thread thread = new Thread(counterLambda);

		thread.start();
		System.out.println("End");
	}

}
