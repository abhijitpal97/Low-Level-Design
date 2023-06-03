package com.example.interfaces;

import java.util.List;

import com.example.bean.MessageBean;

public interface LFUCacheInterface {
	
	public MessageBean getCache(int id);
	public void setCache(MessageBean message);
	public List<MessageBean> getAllCaches();

}
