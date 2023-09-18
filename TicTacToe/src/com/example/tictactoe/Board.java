package com.example.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
	public int size;
	public PlayerPiece[][] board;

	public Board(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		board = new PlayerPiece[size][size];
	}

	public boolean addSign(int row , int col , PlayerPiece	playerPiece)
	{
		if(board[row][col] != null) return false;
		board[row][col] = playerPiece;
		return true;
	}

	public List<List<Integer>> getFreePositions()
	{
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(board[i][j] != null) result.add(new ArrayList<>(Arrays.asList(i , j)));
			}
		}
		return result;
	}
}

