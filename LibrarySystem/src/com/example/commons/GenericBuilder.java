package com.example.commons;

import com.example.model.Book;

public class GenericBuilder {

	public static Book emptyBookSet() {
		// TODO Auto-generated method stub
		Book emptyBook = new Book();
		emptyBook.setId(-1);
		emptyBook.setBookName("Error Occured");
		return emptyBook;
	}

	public static String emptyNoBookSet(String bookName) {
		// TODO Auto-generated method stub
		return String.format("No Book with Name %s is there in teh database." , bookName);
	}

	public static String assignedBookError(String bookName, int userId) {
		// TODO Auto-generated method stub
		return String.format("Book %s is already assigned to user %s", bookName , userId);
	}

	public static String successOnBookIssue(String bookName, int userId) {
		// TODO Auto-generated method stub
		return String.format("Book %s successfully  assigned to user %s", bookName , userId);
	}

	public static String noBookAvailableError(String bookName) {
		// TODO Auto-generated method stub
		return String.format("Book %s not available to issue", bookName);
	}

	public static Book bookIssuedCantRemovedError() {
		// TODO Auto-generated method stub
		Book emptyBook = new Book();
		emptyBook.setId(-2);
		emptyBook.setBookName("Can't Removed as Book Assigned to Users.");
		return emptyBook;
	}

}
