package com.example.implementors;

import java.util.Set;

import com.example.interfaces.FilterInterface;

public class AbusiveFilterImplementation implements FilterInterface{

	@Override
	public boolean filter(String str) {
		SingleTonClass instance = new SingleTonClass().getInstance();
		Set<String> set = instance.getAbusiveFilterContent();
		String[] splitted = str.split("\\s");
		for(String stri : splitted) 
		{
			if(set.contains(stri)) return true;
		}
		return false;
	}

}
