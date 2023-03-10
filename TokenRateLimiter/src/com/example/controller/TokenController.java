package com.example.controller;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.example.interfaces.RateLimiterInterface;

public class TokenController implements RateLimiterInterface{

	private int bucketCapacity;
	private int refreshRate;
	AtomicInteger currentCapacity;
	AtomicLong currentTime;

	public TokenController(int bucketCapacity, int refreshRate) {
		super();
		this.bucketCapacity = bucketCapacity;
		this.refreshRate = refreshRate;
		currentCapacity=new AtomicInteger(bucketCapacity);
		currentTime = new AtomicLong(System.currentTimeMillis());
	}


	@Override
	public boolean hasAccess() {
		refreshBucket();
		if(currentCapacity.get() > 0)
		{
			currentCapacity.decrementAndGet();
			return true;
		}
		return false;

	}


	private void refreshBucket() {
		long curr = System.currentTimeMillis();
		int additionalToken = ((int)(curr-currentTime.get())/1000) * refreshRate;
		currentCapacity.getAndSet(Math.min(bucketCapacity, additionalToken+currentCapacity.get()));
		currentTime.getAndSet(curr);
	}




}
