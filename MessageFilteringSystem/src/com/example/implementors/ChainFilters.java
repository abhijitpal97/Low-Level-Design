package com.example.implementors;

public class ChainFilters {

	public boolean isValid(String[] filters , String sentence)
	{
		boolean isValid = false;
		for(String str : filters)
		{			
			if(str.equals(FilterType.ABUSIVE.getValue()))
			{
				AbusiveFilterImplementation impl = new AbusiveFilterImplementation();
				isValid  = impl.filter(sentence);
				if(isValid) return true;
			}
			else if(str.equals(FilterType.PERSONAL.getValue()))
			{
				PersonalFilterImplementation impl = new PersonalFilterImplementation();
				isValid  = impl.filter(sentence);
				if(isValid) return true;
			}
			else if(str.equals(FilterType.DUPLICATIVE.getValue()))
			{
				DuplicativeFilterImplementation impl = new DuplicativeFilterImplementation();
				isValid  = impl.filter(sentence);
				if(isValid) return true;
			}
		}
		return isValid;
	}

}
