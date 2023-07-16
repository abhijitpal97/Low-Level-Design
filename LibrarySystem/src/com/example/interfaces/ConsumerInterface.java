package com.example.interfaces;

import java.util.List;

import com.example.model.Book;

public interface ConsumerInterface {
	
	List<Book> fetchBookInformationByAuthor(String bookName);
	List<Book> fetchBookInformationByGenere(String bookName);
	String issueBook(String bookName , int userId);

}
