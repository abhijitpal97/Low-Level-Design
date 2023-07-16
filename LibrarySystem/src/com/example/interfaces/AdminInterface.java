package com.example.interfaces;

import com.example.model.Book;

public interface AdminInterface {
	
	Book addBook(Book book);
	String removeBook(String bookName);
	Book modifyBookCount(String bookName , int count , String action);

}
