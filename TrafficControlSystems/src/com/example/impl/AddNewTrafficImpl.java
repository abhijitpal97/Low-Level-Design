package com.example.impl;

import com.example.common.CommonUtility;
import com.example.interfaces.AddNewTraffic;
import com.example.pojo.TrafficLinkedList;

public class AddNewTrafficImpl implements AddNewTraffic{

	@Override
	public TrafficLinkedList addTraffic(TrafficLinkedList light, int newLightPos) {
		if(light == null) return new TrafficLinkedList(0);

		TrafficLinkedList temp = light;
		int len = CommonUtility.getLength(temp);
		if(len<newLightPos) newLightPos=len+1;
		temp = light;
		while(temp.next!=null && newLightPos >0)
		{
			temp=temp.next;
			newLightPos--;
		}
		TrafficLinkedList hold = temp.next;
		temp.next = new TrafficLinkedList(temp.val+1);
		temp=temp.next;
		if(hold !=null) temp.next = hold;

		return light;
	}

}
