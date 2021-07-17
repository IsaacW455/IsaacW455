import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
	
	public static void main(String[] args) {
		int row = 0;
		int column = 0;
		String name1;
		String name2;
		//initialize board
		char[] [] board = new char [3] [3];
		//instantaite the blank spaces in the board
		
		for(int x=0; x<3; x++) {
			for(int y=0; y<3; y++) {
				board[x][y] = '-';
			}
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Player 1 name ?: ");
		name1 = scan.nextLine();
		System.out.println("Player 2 name ?: ");
		name2 = scan.nextLine();
		
		draw(board);
		
		
		//System.out.println("User has placed marker at " + position);
		
		//int variable position corresponds to case #
		
		//Placing(board,position, name1, name2);
		boolean Finished = false;
		boolean player = true;
		
		while(!Finished) {
			
			if(player) {
				System.out.println(name1 + "'s Turn" );
			}else {
				System.out.println(name2 + "'s Turn");
			}
		char shape = '-';
			
		if(player) {
				shape = 'X';
			}else {
				shape = 'O';
			}
		while(true) {
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Enter which Row");
			row = scan.nextInt();
			System.out.println("Enter which Column");
			column = scan.nextInt();
			if(row<0 || column<0 || row>2 || column >2) {
				System.out.println("Out of bounds please re-enter");
		
			}else {
				break;
			}
			}
		board[row][column] = shape;
		
		if(GameWon(board) == 'X') {
			System.out.println(name1 + " has won!");
			Finished = true;
		}
		else if(GameWon(board) == 'O') {
			System.out.println(name2 + " has won!");
			Finished = true;
		}
		else if(boardIsFull(board)) {
			System.out.println( "Game is a tie! ");
			Finished = true;
		}
		else {
			player = !player;
		}
		
		draw(board);
		}
		
		}
	
	//Method to print the board
	public static void draw(char[][] board) {
		System.out.println("This is the Board");
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(board[i][j]); 
			}
			System.out.println("");
		}
	}
	
	//Method checks if board is full. if [i][j] = '-' then it is still empty
	public static boolean boardIsFull(char[][]board) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}
	//Method checks row, column, and diagonal to see which player won
	public static char GameWon(char[][]board) {
		
		//Checks each column
		for(int i=0; i<3; i++) {
			if(board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return board[i][0];
			}
		}
		//Checks each row
		for(int i=0; i<3; i++) {
			if(board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return board[0][i];
			}
		}
		//Checks first diagonal
		if(board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return board[0][0];
		}
		//Checks second diagonal
		if(board[2][0] != '-' && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
			return board[2][0];
		}
		
		return ' ';
	}
}