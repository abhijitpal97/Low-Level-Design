package com.example.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.interfaces.CacheGenericInterface;
import com.example.interfaces.CacheInterface;
import com.example.pojo.LRUNode;
import com.example.pojo.Message;

public class LRUCacheImplementation implements CacheInterface , CacheGenericInterface{

	LRUNode head = new LRUNode();
	LRUNode tail = new LRUNode();
	int capacity;
	Map<Integer , LRUNode> map;

	public LRUCacheImplementation(int capacity) {
		this.capacity = capacity; 
		map  = new HashMap<>(capacity);
		head.next = tail;
		tail.prev = head;

	}

	@Override
	public String get(int sender) {
		String result = "";

		LRUNode node = map.get(sender);
		if(node != null)
		{
			result = node.msg.getMsg();
			remove(node);
			add(node);

		}

		return result;
	}

	@Override
	public void set(Message msg) {
		LRUNode node = map.get(msg.getSender());
		if(node != null)
		{
			remove(node);
			node.msg = msg;
			add(node);

		}
		else
		{
			if(map.size() == capacity)
			{
				map.remove(tail.prev.msg.getSender());
				remove(tail.prev);
			}
			else
			{
				LRUNode newNode = new LRUNode();
				newNode.msg = msg;
				map.put(msg.getSender(), newNode);
				add(newNode);
			}
		}

	}

	@Override
	public void add(LRUNode node) {
		LRUNode headLruNode = head.next;
		head.next = node;
		node.next = headLruNode;
		node.prev = head;
		headLruNode.prev= node;
	}

	@Override
	public void remove(LRUNode node) {
		LRUNode curr = node.next;
		LRUNode currPrev = node.prev;
		currPrev.next = curr;
		curr.prev = currPrev;
	}

}
