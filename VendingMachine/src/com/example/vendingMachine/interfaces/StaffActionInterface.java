package com.example.vendingMachine.interfaces;

import com.example.vendingMachine.pojo.Item;

public interface StaffActionInterface {
	
	public Item addItem(int itemCode , Item items);
	public String removeItem(int itemCode , int quantity);
	public boolean updateItemPrice(int itemCode , int price);

}
