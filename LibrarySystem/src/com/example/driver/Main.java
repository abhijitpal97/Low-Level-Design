package com.example.driver;

import java.util.List;

import com.example.commons.ScheduledJob;
import com.example.constants.AdminConstants;
import com.example.controller.AdminController;
import com.example.controller.ConsumerController;
import com.example.model.Book;

public class Main {

	static AdminController adminController = new AdminController();
	static ConsumerController consumerController = new ConsumerController();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("************ Start Add *************");
		addBooks();
		System.out.println(AdminConstants.bookMap);
		System.out.println(AdminConstants.availableBookCounts);
		System.out.println("************ End Add And Start Remove*************");
		removeBooks();
		System.out.println(AdminConstants.bookMap);
		System.out.println(AdminConstants.availableBookCounts);
		System.out.println("************ After Remove Scheduled Job Run*************");
		
		
		// This Job Can be scheduled as a cron job to update cache or the map in Java. 
		//For Now I have implement it as a Sequential Job.
		ScheduledJob scheduled = new ScheduledJob();
		scheduled.updateBookDetails();
		System.out.println("************ Book By Author *************");
		System.out.println(AdminConstants.bookByAuthor);
		System.out.println("************ Book By Genere *************");
		System.out.println(AdminConstants.bookByGenere);
		System.out.println("************ End Book Category Update  *************");
		
		adminController.modifyBookCount("A1", 1, "remove");
		adminController.modifyBookCount("Removal1", 2, "remove");
		scheduled = new ScheduledJob();
		scheduled.updateBookDetails();
		System.out.println(AdminConstants.bookMap);
		System.out.println(AdminConstants.availableBookCounts);
		System.out.println("************ After Update Book Counts *************");
		
		System.out.println("************ Consumer Process Starts *************");
		
		List<Book> result =  consumerController.fetchBookInformationByAuthor("BBB1");
		System.out.println(result);
		
		List<Book> result1 =  consumerController.fetchBookInformationByGenere("Mystery");
		System.out.println(result1);
		
		System.out.println("************ Consumer Process Book Issue Start *************");
		consumerController.issueBook("AA1", 1);
		consumerController.issueBook("AA1", 1);
		
		consumerController.issueBook("AA2", 1);
		consumerController.issueBook("AAA1", 1);
		consumerController.issueBook("AAA1", 2);
		
		System.out.println(AdminConstants.studentBookIssue);
		System.out.println("************ Consumer Process Book Issue End *************");
	}

	private static void removeBooks() {
		// TODO Auto-generated method stub
		
		adminController.removeBook("Removal");
		
	}

	private static void addBooks() {
		Book book = new Book();
		book.setId(1);
		book.setBookName("A1");
		book.setAuthor("B1");
		book.setGenere("Sci-Fi");
		adminController.addBook(book);
		adminController.modifyBookCount("A1", 5, "add");

		Book book1 = new Book();
		book1.setId(2);
		book1.setBookName("AA1");
		book1.setAuthor("BB1");
		book1.setGenere("Mystery");
		adminController.addBook(book1);
		adminController.modifyBookCount("AA1", 8, "add");
		
		Book book2 = new Book();
		book2.setId(3);
		book2.setBookName("AAA1");
		book2.setAuthor("BBB1");
		book2.setGenere("Romance");
		adminController.addBook(book2);
		adminController.modifyBookCount("AAA1", 10, "add");
		
		Book book3 = new Book();
		book3.setId(4);
		book3.setBookName("Removal");
		book3.setAuthor("XXX");
		book3.setGenere("Not Required");
		adminController.addBook(book3);
		adminController.modifyBookCount("Removal", 1, "add");
		
		Book book4 = new Book();
		book4.setId(4);
		book4.setBookName("Removal1");
		book4.setAuthor("YYY");
		book4.setGenere("Not Required");
		adminController.addBook(book4);
		adminController.modifyBookCount("Removal1", 1, "add");
	}

	
	
}
