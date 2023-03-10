package com.example.pojo;

import java.util.HashMap;
import java.util.Map;

import com.example.controller.SlidingController;

public class SlidingBucket {

	Map<Integer, SlidingController> map = new HashMap<>();


	public SlidingBucket(int id , int capacity , int timeWindowFrame) {
		map.put(id, new SlidingController(capacity, timeWindowFrame));
	}


	public void hasAccessValidation(int id)
	{
		if(map.get(id).hasAccess())
			System.out.println("Bucket has size and User - "+id+" is able to access the system. Acccessed System - "+Thread.currentThread().getName());
		else
			System.out.println("Too man requests to process for User - "+id+". Please try after sometime.");

	}



}
