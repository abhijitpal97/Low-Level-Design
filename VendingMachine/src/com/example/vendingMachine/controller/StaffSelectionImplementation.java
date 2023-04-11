package com.example.vendingMachine.controller;

import java.util.Map;
import com.example.vendingMachine.interfaces.StaffActionInterface;
import com.example.vendingMachine.pojo.Item;
import com.example.vendingMachine.utility.Utility;

public class StaffSelectionImplementation  implements StaffActionInterface{

	@Override
	public Item addItem(int itemCode, Item items) {
		if(Utility.map.containsKey(itemCode))
		{
			Item item = Utility.map.get(itemCode);
			item.setQuantity(item.getQuantity()+items.getQuantity());
			item.setPrice(items.getPrice());
			Utility.map.put(itemCode, item);
		}
		else Utility.map.put(itemCode, items);
		return Utility.map.get(itemCode);

	}

	@Override
	public String removeItem(int itemCode, int quantity) {
		if(Utility.map.containsKey(itemCode))
		{
			Item item = Utility.map.get(itemCode);
			if(item.getQuantity()>quantity)
			{
				item.setQuantity(item.getQuantity() - quantity);
				Utility.map.put(itemCode, item);
				return "Item available post remove - "+Utility.map.get(itemCode);
			}
			else
			{
				return "Requested Quantity Not Available";
			}
		}
		else
		{
			return "Item Not Available";
		}
	}

	@Override
	public boolean updateItemPrice(int itemCode, int price) {
		if(Utility.map.containsKey(itemCode))
		{
			Item item = Utility.map.get(itemCode);
			item.setPrice(price);
			Utility.map.put(itemCode, item);
			return true;
		}
		else return false;
	}

}
