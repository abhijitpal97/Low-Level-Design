package com.example.driver;

import java.util.List;

import com.example.impl.LRUCacheImpl;
import com.example.pojo.MessageBean;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCacheImpl impl = new LRUCacheImpl(5);
		
		impl.setCache(new MessageBean(1, "Abhijit"));
		impl.setCache(new MessageBean(2, "Keshav"));
		impl.setCache(new MessageBean(3, "Shikha"));
		impl.setCache(new MessageBean(4, "Puja"));
		impl.setCache(new MessageBean(5, "Abhinav"));
		System.out.println("Cache for Id - 3"+impl.getCache(3));
		impl.setCache(new MessageBean(6, "Manas"));
		impl.setCache(new MessageBean(7, "Aman"));
		impl.setCache(new MessageBean(8, "Neha"));
		System.out.println("Cache for Id - 3"+impl.getCache(3));
		
		System.out.println("Cache for Id - 7"+impl.getCache(7));
		impl.setCache(new MessageBean(7, "Nida"));
		System.out.println("Cache for Id - 7"+impl.getCache(7));
		
		List<MessageBean> caches = impl.getAllCache();
		
		System.out.println("Caches" + caches);
	}

}
