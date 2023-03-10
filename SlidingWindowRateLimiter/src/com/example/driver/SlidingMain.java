package com.example.driver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.pojo.SlidingBucket;

public class SlidingMain {

	public static void main(String[] args) {
		SlidingBucket bucket1 = new SlidingBucket(1, 10, 1);
		bucket1.hasAccessValidation(1);
		SlidingBucket bucket2 = new SlidingBucket(2, 10, 1);
		ExecutorService exec = Executors.newFixedThreadPool(5);

		for(int i=0; i<15;i++)
		{
			exec.execute(
					() -> bucket2.hasAccessValidation(2)
					);
		}

		exec.shutdown();
	}

}
