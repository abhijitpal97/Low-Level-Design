package com.example.driver;

import com.example.impl.BookingTicketImpl;

public class Main {

	public static void main(String[] args) {
		BookingTicketImpl btImpl = new BookingTicketImpl();
		Thread t1 = new Thread(
				() -> btImpl.bookTicket(1, 2)
				);
		Thread t2 = new Thread(
				() -> btImpl.bookTicket(2, 2)
				);
		Thread t3 = new Thread(
				() -> btImpl.bookTicket(3, 1)
				);
		Thread t4 = new Thread(
				() -> btImpl.bookTicket(4, 3)
				);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
