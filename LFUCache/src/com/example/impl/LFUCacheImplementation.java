package com.example.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.bean.LFUNode;
import com.example.bean.MessageBean;
import com.example.interfaces.LFUCacheInterface;
import com.example.interfaces.LFUNodeInterface;
import com.example.utility.LFUUtility;


public class LFUCacheImplementation  implements LFUCacheInterface , LFUNodeInterface{
	Map<Integer, LFUNode> map ;
	Map<Integer, Integer> frequency ;
	LFUNode head = new LFUNode();
	LFUNode tail = new LFUNode();
	int capacity;
	LFUUtility utility = new LFUUtility();
	public LFUCacheImplementation(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
		head.next=tail;
		tail.prev=head;
		map = new HashMap<>(capacity);
		frequency = new LinkedHashMap<>();		
	}

	@Override
	public MessageBean getCache(int id) {
		// TODO Auto-generated method stub
		if(map.containsKey(id))
		{
			LFUNode node = map.get(id);
			int count = frequency.get(id);
			removeNode(node);
			addNode(node);
			frequency.remove(id);
			frequency.put(id, count+1);
			return node.message;
		}
		return new MessageBean(-1, "The Id is not Cached.");

	}

	@Override
	public void setCache(MessageBean message) {
		// TODO Auto-generated method stub
		if(map.containsKey(message.getId()))
		{
			LFUNode node = map.get(message.getId());
			int count = frequency.get(message.getId());
			removeNode(node);
			node.message=message;
			addNode(node);
			frequency.remove(message.getId());
			frequency.put(message.getId(), count+1);
		}
		else
		{
			if(map.size() == capacity)
			{
				int lfuRemoved = utility.getLFUId(frequency);
				map.remove(lfuRemoved);
				LFUNode node = utility.findNode(lfuRemoved ,  head.next);
				frequency.remove(lfuRemoved);
				removeNode(node);

			}
			LFUNode node = new LFUNode();
			node.message = message;
			addNode(node);
			map.put(message.getId(), node);
			frequency.put(message.getId(), 1);
		}
	}

	@Override
	public List<MessageBean> getAllCaches() {
		// TODO Auto-generated method stub
		List<MessageBean> list = new ArrayList<>();
		LFUNode node = head.next;
		while(node.next != null)
		{
			list.add(node.message);
			node = node.next;
		}
			

		return list;
	}


	@Override
	public void addNode(LFUNode node) {
		// TODO Auto-generated method stub
		LFUNode curr = head.next;
		head.next = node;
		node.next = curr;
		curr.prev = node;
		node.prev = head;

	}

	@Override
	public void removeNode(LFUNode node) {
		// TODO Auto-generated method stub
		LFUNode currNext = node.next;
		LFUNode currPrev = node.prev;
		currPrev.next = currNext;
		currNext.prev = currPrev;

	}
}
