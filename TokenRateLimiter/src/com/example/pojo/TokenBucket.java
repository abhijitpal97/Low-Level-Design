package com.example.pojo;

import java.util.HashMap;
import java.util.Map;

import com.example.controller.TokenController;

public class TokenBucket {

	Map<Integer, TokenController> map = new HashMap<>();


	public TokenBucket(int id , int capacity , int refreshRate) {
		map.put(id, new TokenController(capacity, refreshRate));
	}


	public void hasAccessValidation(int id)
	{
		if(map.get(id).hasAccess())
			System.out.println("Bucket has size and User - "+id+" is able to access the system. Acccessed System - "+Thread.currentThread().getName());
		else
			System.out.println("Too man requests to process for User - "+id+". Please try after sometime.");

	}



}
