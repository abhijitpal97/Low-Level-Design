package com.example.vendingMachine.controller;

import com.example.vendingMachine.interfaces.CoinSelectionInterface;
import com.example.vendingMachine.utility.Utility;

public class CoinSelectionImplementation implements CoinSelectionInterface{

	@Override
	public void addCoin(int coin) {
		if(Utility.coins.contains(coin))
		{
			Utility.availableAmount +=coin;
		}
		else
		{
			System.out.println("This Denomination is not allowed.Only allowed denominations are - "+Utility.coins);
		}
	}

}
