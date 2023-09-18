package com.example.tictactoe;

public class Player {
	private String name;
	private PlayerPiece piece;

	public Player(String name , PlayerPiece piece) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.piece = piece;
	}

	public String getName()
	{
		return name;
	}

	public PlayerPiece getPlayingPiece()
	{
		return piece;
	}

}
