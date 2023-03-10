package com.example.interfaces;

import com.example.pojo.LRUNode;

public interface CacheGenericInterface {
	
	void add(LRUNode node);
	void remove(LRUNode node);

}
