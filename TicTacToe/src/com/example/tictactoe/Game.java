package com.example.tictactoe;

import java.util.List;
import java.util.Queue;

public class Game {
	Board board;
	Queue<Player> players;

	public Game() {
		// TODO Auto-generated constructor stub
		initializeBoard();
	}

	private void initializeBoard() {
		Player xPlayer = new Player("Abhijit", new CrossPlayer());
		Player oPlayer = new Player("Abhijit", new CirclePlayer());

		players.add(xPlayer);
		players.add(oPlayer);

		board = new Board(3);
	}

	public String move(int row , int col)
	{
		boolean noWinner = true;
		while(noWinner)
		{
			Player turn = players.peek();
			List<List<Integer>> freePositions = board.getFreePositions();
			if(freePositions.isEmpty()) 
			{
				noWinner = false;
				continue;
			}

			boolean pieceAdded = board.addSign(row, col, turn.getPlayingPiece());

			if(!pieceAdded) return "Wrong Position";
			else
			{
				players.poll();
				if(gameCompleted(row , col , turn.getPlayingPiece().type)) return turn.getName();
				players.offer(turn);
			}

		}

		return "Tie";
	}

	private boolean gameCompleted(int row, int column, ActionType playingPiece) {


		boolean rowMatch = true;
		boolean columnMatch = true;
		boolean diagonalMatch = true;
		boolean antiDiagonalMatch = true;

		//need to check in row
		for(int i=0;i<board.size;i++) {

			if(board.board[row][i] == null || board.board[row][i].type != playingPiece) {
				rowMatch = false;
			}
		}

		//need to check in column
		for(int i=0;i<board.size;i++) {

			if(board.board[i][column] == null || board.board[i][column].type != playingPiece) {
				columnMatch = false;
			}
		}

		//need to check diagonals
		for(int i=0, j=0; i<board.size;i++,j++) {
			if (board.board[i][j] == null || board.board[i][j].type != playingPiece) {
				diagonalMatch = false;
			}
		}

		//need to check anti-diagonals
		for(int i=0, j=board.size-1; i<board.size;i++,j--) {
			if (board.board[i][j] == null || board.board[i][j].type != playingPiece) {
				antiDiagonalMatch = false;
			}
		}

		return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;


	}


}