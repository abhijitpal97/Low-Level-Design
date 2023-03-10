package com.example.controller;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

import com.example.interfaces.RateLimiterInterface;

public class SlidingController implements RateLimiterInterface{

	private int bucketCapacity;
	Queue<Long> queue;
	int timeWindowFrame;

	public SlidingController(int bucketCapacity, int timeWindowFrame) {
		super();
		this.bucketCapacity = bucketCapacity;
		this.timeWindowFrame = timeWindowFrame;
		queue = new ConcurrentLinkedQueue<>();
	}


	@Override
	public boolean hasAccess() {
		long currentTime = System.currentTimeMillis();
		refreshBucket(currentTime);
		if(queue.size()<bucketCapacity)
		{
			queue.offer(currentTime);
			return true;
		}
		return false;

	}


	private void refreshBucket(long currentTime) {
		if(queue.isEmpty()) return;
		long tillCheck = (currentTime - queue.peek()) /1000;
		
		while(tillCheck > timeWindowFrame)
		{
			queue.poll();
			
			if(queue.isEmpty()) break;
			tillCheck = (currentTime - queue.peek()) /1000;
		}
	}




}
