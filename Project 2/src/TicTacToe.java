import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

import javax.sound.midi.SysexMessage;

// Documentation https://en.wikipedia.org/wiki/Tic-tac-toe

public class TicTacToe {
	static Scanner in;
	static Random rand = new Random();
	static String[][] board;
	static String currentChar;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		board = new String[3][3];
		boolean winner = false;
		int letterSwitch = 2;
		currentChar = String.valueOf('x');
		int xVal;
		int yVal;

		System.out.println("Welcome to Tic Tac Toe!");
		System.out.println("-----------------------");
		System.out.println();
		initializer();
		printBoard();
		System.out.println();
		System.out.println("X's will go first.");

		while (!winner) {
			
			if ((letterSwitch % 2) == 0) {
				currentChar = String.valueOf('x');
			} else {
				currentChar = String.valueOf('o');
			}
			System.out.printf("%s team please select your slot.\n", currentChar);
			//Get slot location here
			if(currentChar.equals(String.valueOf('o'))) {
				xVal = rand.nextInt(3);
				yVal = rand.nextInt(3);
				System.out.print("The computer has chosen " + xVal + "," + yVal + ". ");
			} else {
				System.out.print("X Value: ");
				xVal = in.nextInt();
				System.out.print("Y Value: ");
				yVal = in.nextInt();
			}
			
			
			
			// Check to make sure numInput is in slot range.
			if (!(xVal >= 0 && xVal <= 2) && !(yVal >= 0 && yVal <= 2)) {
				System.out.println("Invalid input; re-enter slot number:");
				// If numInput is in range and isnt taken, set that slot to the character
			} else if ((xVal >= 0 && xVal <= 2) && (yVal >= 0 && yVal <= 2)) {
				if (!(board[xVal][yVal].equals(String.valueOf('o'))
						|| board[xVal][yVal].equals(String.valueOf('x')))) {

					if ((letterSwitch % 2) == 0) {
						currentChar = String.valueOf('x');
					} else {
						currentChar = String.valueOf('o');
					}

					board[xVal][yVal] = currentChar;
					letterSwitch++;
				} else {
					System.out.println("Slot already taken. Please choose another.");
				}
			}

			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			printBoard();
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();

			winner = checkWin();

		}
		System.out.println("Winner!!!!!!!!!!!!!!!");
		System.out.printf("Congradulations to the %s's team!", currentChar);
	}

	static boolean checkWin() {
		if ((board[0][0].equals(String.valueOf('x'))) && (board[1][0].equals(String.valueOf('x')))
				&& (board[2][0].equals(String.valueOf('x')))) {
			return true;
		} else if ((board[0][1].equals(String.valueOf('x'))) && (board[1][1].equals(String.valueOf('x')))
				&& (board[2][1].equals(String.valueOf('x')))) {
			return true;
		} else if ((board[0][2].equals(String.valueOf('x'))) && (board[1][2].equals(String.valueOf('x')))
				&& (board[2][2].equals(String.valueOf('x')))) {
			return true;
		} else if ((board[0][0].equals(String.valueOf('x'))) && (board[0][1].equals(String.valueOf('x')))
				&& (board[0][2].equals(String.valueOf('x')))) {
			return true;
		} else if ((board[1][0].equals(String.valueOf('x'))) && (board[1][1].equals(String.valueOf('x')))
				&& (board[1][2].equals(String.valueOf('x')))) {
			return true;
		} else if ((board[2][0].equals(String.valueOf('x'))) && (board[2][1].equals(String.valueOf('x')))
				&& (board[2][2].equals(String.valueOf('x')))) {
			return true;
		} else if ((board[0][0].equals(String.valueOf('x'))) && (board[1][1].equals(String.valueOf('x')))
				&& (board[2][2].equals(String.valueOf('x')))) {
			return true;
		} else if ((board[2][0].equals(String.valueOf('x'))) && (board[1][1].equals(String.valueOf('x')))
				&& (board[0][2].equals(String.valueOf('x')))) {
			return true;
			// O's
		} else if ((board[0][0].equals(String.valueOf('o'))) && (board[1][0].equals(String.valueOf('o')))
				&& (board[2][0].equals(String.valueOf('o')))) {
			return true;
		} else if ((board[0][1].equals(String.valueOf('o'))) && (board[1][1].equals(String.valueOf('o')))
				&& (board[2][1].equals(String.valueOf('o')))) {
			return true;
		} else if ((board[0][2].equals(String.valueOf('o'))) && (board[1][2].equals(String.valueOf('o')))
				&& (board[2][2].equals(String.valueOf('o')))) {
			return true;
		} else if ((board[0][0].equals(String.valueOf('o'))) && (board[0][1].equals(String.valueOf('o')))
				&& (board[0][2].equals(String.valueOf('o')))) {
			return true;
		} else if ((board[1][0].equals(String.valueOf('o'))) && (board[1][1].equals(String.valueOf('o')))
				&& (board[1][2].equals(String.valueOf('o')))) {
			return true;
		} else if ((board[2][0].equals(String.valueOf('o'))) && (board[2][1].equals(String.valueOf('o')))
				&& (board[2][2].equals(String.valueOf('o')))) {
			return true;
		} else if ((board[0][0].equals(String.valueOf('o'))) && (board[1][1].equals(String.valueOf('o')))
				&& (board[2][2].equals(String.valueOf('o')))) {
			return true;
		} else if ((board[2][2].equals(String.valueOf('o'))) && (board[1][1].equals(String.valueOf('o')))
				&& (board[0][2].equals(String.valueOf('o')))) {
			return true;
		}

		return false;
	}

	static void printBoard() {
		System.out.println("    0   1   2");
		System.out.println();
		System.out.println(" 0  " + board[0][0] + " | " + board[1][0] + " | " + board[2][0]);
		System.out.println("   -----------");
		System.out.println(" 1  " + board[0][1] + " | " + board[1][1] + " | " + board[2][1]);
		System.out.println("   -----------");
		System.out.println(" 2  " + board[0][2] + " | " + board[1][2] + " | " + board[2][2]);
	}

	static void initializer() {
		
		for(int i = 0; i <= 2; i++){
	        for(int j = 0; j <= 2; j++){
	        	board[i][j] = "-";
	        }
	    }
		
	}
}