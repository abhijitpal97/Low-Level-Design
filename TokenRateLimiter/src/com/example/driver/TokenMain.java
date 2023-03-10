package com.example.driver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.pojo.TokenBucket;

public class TokenMain {

	public static void main(String[] args) {
		TokenBucket bucket1 = new TokenBucket(1, 10, 1);
		bucket1.hasAccessValidation(1);
		TokenBucket bucket2 = new TokenBucket(2, 10, 1);
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
