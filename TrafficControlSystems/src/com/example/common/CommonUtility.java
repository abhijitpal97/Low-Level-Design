package com.example.common;

import com.example.pojo.TrafficLinkedList;

public class CommonUtility {

	public static int getLength(TrafficLinkedList temp) {
		int count=0;
		while(temp !=null)
		{
			temp=temp.next;
			count++;
		}

		return count;
	}


}
