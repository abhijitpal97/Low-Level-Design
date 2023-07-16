package com.example.services;

import com.example.commons.GenericBuilder;
import com.example.constants.AdminConstants;
import com.example.model.Book;

public class AdminServices {

	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		if(AdminConstants.bookMap.containsKey(book.getBookName())) return GenericBuilder.emptyBookSet();

		AdminConstants.bookMap.put(book.getBookName() , book);
		AdminConstants.availableBookCounts.put(book.getBookName(), new int[] {0,0});
		return AdminConstants.bookMap.get(book.getBookName());
	}

	public String removeBook(String bookName) {
		// TODO Auto-generated method stub
		if(! AdminConstants.bookMap.containsKey(bookName)) return GenericBuilder.emptyNoBookSet(bookName);

		AdminConstants.bookMap.remove(bookName);
		AdminConstants.availableBookCounts.remove(bookName);

		return AdminConstants.bookMap.containsKey(bookName) ? 
				String.format("Error while deleting the book %s",bookName) : 
					String.format("Book %s deleted successfully.", bookName);
	}

	public Book modifyBookCount(String bookName, int count, String action) {
		// TODO Auto-generated method stub
		if(! AdminConstants.bookMap.containsKey(bookName)) return GenericBuilder.emptyBookSet();
		
		if(action.equals("remove") && AdminConstants.availableBookCounts.get(bookName)[1]>0)
			return GenericBuilder.bookIssuedCantRemovedError();		
		else if(action.equals("remove") && AdminConstants.availableBookCounts.get(bookName)[0]<=count)
		{
			AdminConstants.bookMap.remove(bookName);
			AdminConstants.availableBookCounts.remove(bookName);
		}
		else if(action.equals("remove") && AdminConstants.availableBookCounts.get(bookName)[0]>count)
		{
			AdminConstants.availableBookCounts.get(bookName)[0] =
					AdminConstants.availableBookCounts.get(bookName)[0] - count;
		}
		else if(action.equals("add"))
		{
			AdminConstants.availableBookCounts.get(bookName)[0] =
					AdminConstants.availableBookCounts.get(bookName)[0] + count;
		}
		return AdminConstants.bookMap.containsKey(bookName) ? AdminConstants.bookMap.get(bookName) 
				: GenericBuilder.emptyBookSet();
	}

}
