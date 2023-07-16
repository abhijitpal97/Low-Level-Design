package com.example.controller;

import java.util.List;

import com.example.interfaces.ConsumerInterface;
import com.example.model.Book;
import com.example.services.ConsumerServices;

public class ConsumerController implements ConsumerInterface{
	ConsumerServices consumerServices = new ConsumerServices();
	
	@Override
	public List<Book> fetchBookInformationByAuthor(String bookName) {
		// TODO Auto-generated method stub
		return consumerServices.fetchInformationByAuthor(bookName);
	}

	@Override
	public List<Book> fetchBookInformationByGenere(String bookName) {
		// TODO Auto-generated method stub
		return consumerServices.fetchInformationByGenere(bookName);
	}

	@Override
	public String issueBook(String bookName, int userId) {
		// TODO Auto-generated method stub
		return consumerServices.issueBook(bookName , userId);
	}

}
