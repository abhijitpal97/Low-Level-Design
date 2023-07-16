package com.example.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import com.example.constants.AdminConstants;
import com.example.model.Book;

public class ScheduledJob{

	public void updateBookDetails() {
		// TODO Auto-generated method stub
		for(Map.Entry<String, Book> map : AdminConstants.bookMap.entrySet())
		{
			Book book = map.getValue();

			if(AdminConstants.bookByAuthor.containsKey(book.getAuthor())
					&& ! AdminConstants.bookByAuthor.get(book.getAuthor()).contains(book))
				AdminConstants.bookByAuthor.get(book.getAuthor()).add(book);
			else
				AdminConstants.bookByAuthor.put(book.getAuthor(), new ArrayList<>(Arrays.asList(book)));

			if(AdminConstants.bookByGenere.containsKey(book.getGenere())
					&& ! AdminConstants.bookByGenere.get(book.getGenere()).contains(book))
				AdminConstants.bookByGenere.get(book.getGenere()).add(book);
			else
				AdminConstants.bookByGenere.put(book.getGenere(), new ArrayList<>(Arrays.asList(book)));						
		}

	}



}
