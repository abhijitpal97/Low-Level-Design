package com.example.utility;

import java.util.Map;

import com.example.bean.LFUNode;

public class LFUUtility {

	public int getLFUId(Map<Integer, Integer> frequency) {
		// TODO Auto-generated method stub
		int id = 0;
		int count = Integer.MAX_VALUE;
		for(Map.Entry<Integer, Integer> m1 : frequency.entrySet())
		{
			if(m1.getValue()<count) 
				{
				id = m1.getKey();
				count = m1.getValue();
				}
		}
		return id;
	}

	public LFUNode findNode(int lfuRemoved, LFUNode head) {
		// TODO Auto-generated method stub
		LFUNode node = head;
		while(node != null)
		{
			if(node.message.getId() == lfuRemoved) return node;
			
			node = node.next;
		}
		return null;
	}

}
