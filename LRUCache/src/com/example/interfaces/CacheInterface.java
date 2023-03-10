package com.example.interfaces;

import com.example.pojo.Message;

public interface CacheInterface {

	String get(int sender);
	void set(Message msg);

}
