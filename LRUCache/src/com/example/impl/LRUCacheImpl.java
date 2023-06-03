package com.example.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.interfaces.LRUCacheInterface;
import com.example.interfaces.LRUNodeInteface;
import com.example.pojo.LRUNode;
import com.example.pojo.MessageBean;

public class LRUCacheImpl implements LRUCacheInterface,LRUNodeInteface{

	LRUNode head = new LRUNode();
	LRUNode tail = new LRUNode();
	int capacity;
	Map<Integer, LRUNode> map;

	public LRUCacheImpl(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
		map = new HashMap<>(capacity);
		head.next = tail;
		tail.prev = head; 
	}

	@Override
	public void setCache(MessageBean message) {
		if(map.containsKey(message.getId()))
		{
			LRUNode node = map.get(message.getId());
			removeNode(node);
			node.message=message;
			addNode(node);			
		}
		else
		{
			if(map.size() ==  capacity)
			{
				map.remove(tail.prev.message.getId());
				removeNode(tail.prev);
			}

			LRUNode node = new LRUNode();
			node.message = message;

			map.put(message.getId(), node);
			addNode(node);
		}

	}

	@Override
	public MessageBean getCache(int id) {
		if(map.containsKey(id))
		{
			LRUNode node = map.get(id);
			removeNode(node);
			addNode(node);	

			return node.message;
		}

		return new MessageBean(-1, "The requested Cache is not present in the Cache");
	}


	@Override
	public List<MessageBean> getAllCache() {
		// TODO Auto-generated method stub
		List<MessageBean> list = new ArrayList<>();
		for(Map.Entry<Integer, LRUNode> m1 : map.entrySet()) list.add(m1.getValue().message);

		return list;
	}

	@Override
	public void addNode(LRUNode node) {
		// TODO Auto-generated method stub
		LRUNode headNext = head.next;
		head.next = node;
		node.next = headNext;
		headNext.prev = node;
		node.prev = head;		
	}

	@Override
	public void removeNode(LRUNode node) {
		// TODO Auto-generated method stub
		LRUNode curr = node.next;
		LRUNode prev = node.prev;
		prev.next = curr;
		curr.prev = prev;

	}



}
