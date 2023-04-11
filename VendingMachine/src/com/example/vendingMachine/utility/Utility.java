package com.example.vendingMachine.utility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.vendingMachine.pojo.Item;

public class Utility {

	public static Map<Integer, Item> map = new HashMap<>();
	public static int availableAmount;
	public static List<Integer> coins = Arrays.asList(5,10,20,50);
	
	
}
