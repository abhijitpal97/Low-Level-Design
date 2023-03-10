package com.example.impl.driver;

import com.example.impl.LRUCacheImplementation;
import com.example.pojo.Message;

public class LRUCacheMain {

	public static void main(String[] args)
	{
		LRUCacheImplementation lru = new LRUCacheImplementation(3);
		
		lru.set(new Message(1, "Abhijit Pal"));
		lru.set(new Message(2, "This is a dummy cache"));
		lru.set(new Message(3, "Cache testing in progress"));
		lru.set(new Message(2, "Dummy Cache Updated"));
		
		String msg1 = lru.get(1);
		String msg2 = lru.get(2);
		String msg3 = lru.get(3);
		
		System.out.println(msg1);
		System.out.println(msg2);
		System.out.println(msg3);
	}


}
