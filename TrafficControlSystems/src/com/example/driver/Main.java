package com.example.driver;

import com.example.impl.AddNewTrafficImpl;
import com.example.impl.RemoveOldTrafficImpl;
import com.example.impl.TrafficImpl;
import com.example.pojo.TrafficLinkedList;

public class Main {
	
	public static void main(String[] args)
	{
		TrafficLinkedList traffic = new TrafficLinkedList(0);
		AddNewTrafficImpl addTraffic = new AddNewTrafficImpl();
		RemoveOldTrafficImpl removeTraffic = new RemoveOldTrafficImpl();
		
		
		addTraffic.addTraffic(traffic, 1);
		addTraffic.addTraffic(traffic, 2);
		addTraffic.addTraffic(traffic, 3);
		addTraffic.addTraffic(traffic, 4);
		addTraffic.addTraffic(traffic, 5);
		addTraffic.addTraffic(traffic, 2);
		
		
		removeTraffic.removeTraffic(traffic, 4);
		
		// Made the traffic circular to continue in loop
		TrafficLinkedList temp = traffic;
		while(temp.next !=null) temp =temp.next;
		temp.next = traffic;
		
		
		TrafficImpl impl = new TrafficImpl();
		impl.changeStatus(traffic);
	}
}
