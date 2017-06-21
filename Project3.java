/**
 *
 * @author Kyle Foley
 */
import java.util.Scanner;

public class Project3 {

	//Prints name:
	public static void printName() {
		System.out.println("Kyle Foley");
	}

	//Creates the game board:
	public static String[][] createGameBoard() {
		String[][] gameBoard = new String[7][15];
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (j % 2 == 0) {
					gameBoard[i][j] = "|";
				} else {
					gameBoard[i][j] = " ";
				}
				if (i == 6) {
					gameBoard[i][j] = "-";
				}
			}

		}
		return gameBoard;
	}

	//Prints gameBoard:
	public static void printGameBoard(String[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(gameBoard[i][j]);
			}
			System.out.println();
		}
	}

	//Fill spot for red player's turn:
	public static void dropRed(String[][] gameBoard) {

		System.out.println("Drop a red disk at column (0-6): ");
		Scanner scan = new Scanner(System.in);
		int c = 2 * scan.nextInt() + 1;

		for (int i = 5; i >= 0; i--) {
			if (gameBoard[i][c] == " ") {
				gameBoard[i][c] = "R";
				break;
			}

		}
	}

	//Fill spot for yellow player's turn:
	public static void dropYellow(String[][] gameBoard) {
		System.out.println("Drop a yellow disk at column (0-6): ");
		Scanner scan = new Scanner(System.in);
		int c = 2 * scan.nextInt() + 1;
		for (int i = 5; i >= 0; i--) {
			if (gameBoard[i][c] == " ") {
				gameBoard[i][c] = "Y";
				break;
			}

		}
	}

	//Checks if any player has won:
	public static String checkWinner(String[][] gameBoard) {

		//Horizontal line:
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j += 2) {
				if ((gameBoard[i][j + 1] != " ")
						&& (gameBoard[i][j + 3] != " ")
						&& (gameBoard[i][j + 5] != " ")
						&& (gameBoard[i][j + 7] != " ")
						&& ((gameBoard[i][j + 1] == gameBoard[i][j + 3])
								&& (gameBoard[i][j + 3] == gameBoard[i][j + 5])
								&& (gameBoard[i][j + 5] == gameBoard[i][j + 7])))
				{
					return gameBoard[i][j + 1];
				}
			}
		}

		//Vertical Line:
		for (int i = 1; i < 15; i += 2) {
			for (int j = 0; j < 3; j++) {
				if ((gameBoard[j][i] != " ")
						&& (gameBoard[j + 1][i] != " ")
						&& (gameBoard[j + 2][i] != " ")
						&& (gameBoard[j + 3][i] != " ")
						&& ((gameBoard[j][i] == gameBoard[j + 1][i])
								&& (gameBoard[j + 1][i] == gameBoard[j + 2][i])
								&& (gameBoard[j + 2][i] == gameBoard[j + 3][i]))) 
				{
					return gameBoard[j][i];
				}
			}
		}


		//Left to right down diagonal line:
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j < 9; j += 2) {
				if ((gameBoard[i][j] != " ")
						&& (gameBoard[i + 1][j + 2] != " ")
						&& (gameBoard[i + 2][j + 4] != " ")
						&& (gameBoard[i + 3][j + 6] != " ")
						&& ((gameBoard[i][j] == gameBoard[i + 1][j + 2])
								&& (gameBoard[i + 1][j + 2] == gameBoard[i + 2][j + 4])
								&& (gameBoard[i + 2][j + 4] == gameBoard[i + 3][j + 6]))) {
					return gameBoard[i][j];
				}
			}
		}


		//Right to left down diagonal line:
		for (int i = 0; i < 3; i++) {
			for (int j = 7; j < 15; j += 2) {
				if ((gameBoard[i][j] != " ")
						&& (gameBoard[i + 1][j - 2] != " ")
						&& (gameBoard[i + 2][j - 4] != " ")
						&& (gameBoard[i + 3][j - 6] != " ")
						&& ((gameBoard[i][j] == gameBoard[i + 1][j - 2])
								&& (gameBoard[i + 1][j - 2] == gameBoard[i + 2][j - 4])
								&& (gameBoard[i + 2][j - 4] == gameBoard[i + 3][j - 6]))) {
					return gameBoard[i][j];
				}
			}
		}
		//Return null if no winner yet:
		return null;
	}

	public static void main(String[] args) {

		//Print name:
		printName();

		//Create gameBoard:
		String[][] f = createGameBoard();

		//condition to keep game running:
		boolean notWin = true;

		//keeps track of turns:
		int count = 0;
		printGameBoard(f);
		while (notWin) {
			if (count % 2 == 0) {
				dropRed(f);
			} else {
				dropYellow(f);
			}
			count++;
			printGameBoard(f);

			//Check if there is a winner and change condition to end game if there is one:
				if (checkWinner(f) != null) {
					if (checkWinner(f) == "R") {
						System.out.println("Red player wins!");
					} else if (checkWinner(f) == "Y") {
						System.out.println("Yellow player wins!");
					}
					notWin = false;
				}
		}
	}

}
