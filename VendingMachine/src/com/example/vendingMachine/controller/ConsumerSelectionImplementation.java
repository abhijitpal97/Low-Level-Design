package com.example.vendingMachine.controller;

import com.example.vendingMachine.interfaces.ConsumerSelectionInterface;
import com.example.vendingMachine.pojo.Item;
import com.example.vendingMachine.utility.Utility;

public class ConsumerSelectionImplementation implements ConsumerSelectionInterface{

	@Override
	public int purchaseItem(int itemCode, int quantity) {
		if(Utility.map.containsKey(itemCode))
		{
			Item item = Utility.map.get(itemCode);
			if(item.getQuantity()>=quantity && Utility.availableAmount>=(item.getPrice() * quantity))
			{
				item.setQuantity(item.getQuantity() - quantity);
				Utility.availableAmount -= item.getPrice() * quantity;
				Utility.map.put(itemCode, item);

			}
			else
			{
				System.out.println("Not Enough Amount or Quantity");
			}
		}
		else
		{
			System.out.println("Item is not avaliable.");
		}

		return Utility.availableAmount;
	}

}
