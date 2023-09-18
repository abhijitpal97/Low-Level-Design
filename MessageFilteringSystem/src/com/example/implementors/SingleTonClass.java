package com.example.implementors;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.interfaces.FilterContent;

public class SingleTonClass implements FilterContent{
	private Set<String> abusive;
	private Set<String> personal;
	private Set<String> duplicative;

	private static SingleTonClass instance;

	public SingleTonClass() {
		// TODO Auto-generated constructor stub
		abusive = new HashSet<>();
		personal = new HashSet<>();
		duplicative = new HashSet<>();
	}

	public SingleTonClass getInstance(){
		if(instance == null) instance = new SingleTonClass();
		return instance;
	}

	@Override
	public void setFilterContent(List<String> strs, String filterType) throws Exception{
		if(filterType.equals(FilterType.ABUSIVE.getValue()))
		{
			abusive.addAll(strs);		
		}
		else if(filterType.equals(FilterType.PERSONAL.getValue()))
		{
			personal.addAll(strs);
		}
		else
			throw new Exception("Not a valid FilterType to implement");
	}

	@Override
	public Set<String> getAbusiveFilterContent() {
		// TODO Auto-generated method stub
		return abusive;
	}

	@Override
	public Set<String> getPersonalFilterContent() {
		// TODO Auto-generated method stub
		return personal;
	}

	@Override
	public Set<String> getDuplicativeFilterContent() {
		// TODO Auto-generated method stub
		return duplicative;
	}


}
