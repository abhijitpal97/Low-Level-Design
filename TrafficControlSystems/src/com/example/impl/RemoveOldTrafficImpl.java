package com.example.impl;

import com.example.common.CommonUtility;
import com.example.interfaces.RemoveOldTraffic;
import com.example.pojo.TrafficLinkedList;

public class RemoveOldTrafficImpl implements RemoveOldTraffic{

	@Override
	public TrafficLinkedList removeTraffic(TrafficLinkedList light, int oldLightPos) {
		if(light == null) return null;

		TrafficLinkedList temp = light;
		int len = CommonUtility.getLength(temp);
		if(len<oldLightPos) oldLightPos=len;
		temp = light;
		
		while(temp.next!=null && oldLightPos >0)
		{
			temp=temp.next;
			oldLightPos--;
		}
		temp.next = temp.next.next;
		
		return light;
	}

}
