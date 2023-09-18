package com.example.implementors;

import java.util.Set;

import com.example.interfaces.FilterInterface;

public class DuplicativeFilterImplementation implements FilterInterface{

	@Override
	public boolean filter(String str) {
		SingleTonClass instance = new SingleTonClass().getInstance();
		Set<String> set = instance.getDuplicativeFilterContent();
		if(set.contains(str)) return true;
		set.add(str);
		return false;

	}

}
