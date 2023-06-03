package com.example.driver;

import com.example.bean.MessageBean;
import com.example.impl.LFUCacheImplementation;

public class Main {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		LFUCacheImplementation impl = new LFUCacheImplementation(3);
		
		impl.setCache(new MessageBean(1, "Abhijit"));
		impl.setCache(new MessageBean(2, "Keshav"));
		impl.setCache(new MessageBean(3, "Shikha"));
		impl.setCache(new MessageBean(1, "Puja"));
		impl.setCache(new MessageBean(4, "Abhinav"));
		System.out.println("Caches" + impl.getAllCaches());
		
		MessageBean bean = impl.getCache(2);
		System.out.println(bean.getMessage());
		
		bean = impl.getCache(3);
		System.out.println(bean.getMessage());
		
		
		System.out.println("Caches" + impl.getAllCaches());
	
	}

}
