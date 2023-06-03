package com.example.interfaces;

import java.util.HashMap;
import java.util.List;

import com.example.pojo.MessageBean;

public interface LRUCacheInterface {
	
	public void setCache(MessageBean message);
	public MessageBean getCache(int id);
	public List<MessageBean> getAllCache();

}
