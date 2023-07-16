package com.example.controller;

import com.example.interfaces.AdminInterface;
import com.example.model.Book;
import com.example.services.AdminServices;

public class AdminController implements AdminInterface{

	AdminServices services = new AdminServices();
	
	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return services.addBook(book);
	}

	@Override
	public String removeBook(String bookName) {
		// TODO Auto-generated method stub
		return services.removeBook(bookName);
	}

	@Override
	public Book modifyBookCount(String bookName, int count, String action) {
		// TODO Auto-generated method stub
		return services.modifyBookCount(bookName , count , action);
	}

}
