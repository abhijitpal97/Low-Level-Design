package com.example.tictactoe;

public enum ActionType {

	X("x"),
	O("o");

	private String value;

	private ActionType(String value)
	{
		this.value=value;
	}

	public String getValue()
	{
		return value;
	}

}
