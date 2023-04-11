package com.example.vendingMachine.main;

import com.example.vendingMachine.controller.CoinSelectionImplementation;
import com.example.vendingMachine.controller.ConsumerSelectionImplementation;
import com.example.vendingMachine.controller.StaffSelectionImplementation;
import com.example.vendingMachine.pojo.Item;
import com.example.vendingMachine.utility.Utility;

public class MainClass {
	static StaffSelectionImplementation staff = new StaffSelectionImplementation();
	static CoinSelectionImplementation coinImpl = new CoinSelectionImplementation();
	static ConsumerSelectionImplementation consumer = new ConsumerSelectionImplementation();

	public static void main(String[] args) {
		addNewItem();
		addExistingItem();
		removeNewItem();
		removeExistingItem();
		removeExtraItem();
		updateItemPrice();
		updateUnavailableItemPrice();
		addCoins();
		System.out.println(Utility.availableAmount);
		purchaseItem();		
	}

	public static void addNewItem() {
		Item item = new Item(1, 10, 15);
		Item item1 = new Item(2, 12, 25);
		Item item2 = new Item(3, 15, 35);

		Item addItem1 = staff.addItem(1, item);
		System.out.println(addItem1);
		Item addItem2 = staff.addItem(2, item1);
		System.out.println(addItem2);
		Item addItem3 = staff.addItem(3, item2);
		System.out.println(addItem3);
	}

	public static void addExistingItem() {
		Item item1 = new Item(2, 30, 15);

		Item addItem2 = staff.addItem(2, item1);
		System.out.println(addItem2);
	}

	public static void removeNewItem() {
		String result = staff.removeItem(5, 2);
		System.out.println(result);

	}

	public static void removeExistingItem() {
		String result = staff.removeItem(1, 2);
		System.out.println(result);

	}

	public static void removeExtraItem() {
		String result = staff.removeItem(2, 200);
		System.out.println(result);

	}

	public static void updateItemPrice() {
		boolean result = staff.updateItemPrice(3, 40);
		System.out.println(result);

	}

	public static void updateUnavailableItemPrice() {
		boolean result = staff.updateItemPrice(30, 40);		
		System.out.println(result);
	}
	
	public static void addCoins() {
		coinImpl.addCoin(5);
		coinImpl.addCoin(10);
		coinImpl.addCoin(40);
		coinImpl.addCoin(20);
		coinImpl.addCoin(20);

	}
	
	public static void purchaseItem()
	{
		System.out.println(consumer.purchaseItem(3, 1));
		System.out.println(consumer.purchaseItem(2, 100));
		System.out.println(consumer.purchaseItem(1, 2));
	}
	
	
	

}
