package com.example.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.commons.GenericBuilder;
import com.example.constants.AdminConstants;
import com.example.model.Book;

public class ConsumerServices {

	public List<Book> fetchInformationByAuthor(String bookName) {
		// TODO Auto-generated method stub
		return AdminConstants.bookByAuthor.get(bookName);
	}

	public List<Book> fetchInformationByGenere(String bookName) {
		// TODO Auto-generated method stub
		return AdminConstants.bookByGenere.get(bookName);
	}

	public String issueBook(String bookName, int userId) {
		// TODO Auto-generated method stub
		
			if(! AdminConstants.bookMap.containsKey(bookName))
				return GenericBuilder.noBookAvailableError(bookName);
			if(AdminConstants.availableBookCounts.get(bookName)[0] <= 0)
				return GenericBuilder.noBookAvailableError(bookName);
			
			else if(AdminConstants.studentBookIssue.containsKey(userId)
				 && AdminConstants.studentBookIssue.get(userId).contains(bookName))
			return GenericBuilder.assignedBookError(bookName , userId);
			
		else if(AdminConstants.studentBookIssue.containsKey(userId)
				 && ! AdminConstants.studentBookIssue.get(userId).contains(bookName)
				 && AdminConstants.availableBookCounts.get(bookName)[0] > 0)
		{
			AdminConstants.studentBookIssue.get(userId).add(bookName);
			AdminConstants.availableBookCounts.get(bookName)[0]--;
			AdminConstants.availableBookCounts.get(bookName)[1]++;
			return GenericBuilder.successOnBookIssue(bookName , userId);
		}
		
		AdminConstants.studentBookIssue.put(userId, new ArrayList<>(Arrays.asList(bookName)));
		AdminConstants.availableBookCounts.get(bookName)[0]--;
		AdminConstants.availableBookCounts.get(bookName)[1]++;
		return GenericBuilder.successOnBookIssue(bookName , userId);
	}

}
