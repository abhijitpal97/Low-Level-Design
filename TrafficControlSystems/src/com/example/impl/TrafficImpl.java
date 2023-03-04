package com.example.impl;

import com.example.interfaces.TrafficControllerInterface;
import com.example.pojo.Colors;
import com.example.pojo.TrafficLinkedList;

public class TrafficImpl implements TrafficControllerInterface{

	@Override
	public void changeStatus(TrafficLinkedList traffic) {

		while(traffic !=null)
		{

			try {
				changeTraffic(traffic.val);
				traffic=traffic.next;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private void changeTraffic(int dir) throws InterruptedException {
		for(int i = 0 ; i<=2 ; i++)
		{
			Colors curr = getColor(i) ;
			System.out.println("Current Color - "+curr+" for dir "+dir);
			Thread.sleep(1000);
		}		
	}

	Colors getColor(int val)
	{
		if(val ==0) return Colors.GREEN;
		if(val ==1) return Colors.ORANGE;
		if(val ==2) return Colors.RED;
		return null;
	}

}
