package com.example.vendingMachine.pojo;

public class Item {
	private int itemCode;
	private int quantity;
	private int price;
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Item(int itemCode, int quantity, int price) {
		super();
		this.itemCode = itemCode;
		this.quantity = quantity;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
