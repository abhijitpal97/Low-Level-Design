package com.example.constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.Book;

public class AdminConstants {

	public static  Map<String,Book> bookMap = new HashMap<>();
	public static Map<String , List<Book>> bookByAuthor = new HashMap<>();
	public static Map<String , List<Book>> bookByGenere = new HashMap<>();
	public static Map<Integer , List<String>> studentBookIssue = new HashMap<>();
	public static Map<String , int[]> availableBookCounts = new HashMap<>();

}
