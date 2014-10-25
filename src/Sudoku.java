/**
 * Sudoku
 *
 * @author Jacob Stuart
 * @lab 806
 * @date October 21, 2014
 */
import java.util.Arrays;
public class Sudoku {
	//todo private
	public int[][] board;
	private int rows, columns;

	public static void main(String[] args) {
//	 int[][] sudoku = new int[9][9];
//	 sudoku[0] = new int[]{2,4,5,      8,7,1,      3,9,6};
//	 sudoku[1] = new int[]{1,8,7,      6,3,9,      2,5,4};
//	 sudoku[2] = new int[]{9,6,3,      2,4,5,      7,8,1};
//
//	 sudoku[3] = new int[]{3,2,4,      9,6,7,      5,1,8};
//	 sudoku[4] = new int[]{5,9,8,      1,2,3,      6,4,7};
//	 sudoku[5] = new int[]{7,1,6,      5,8,4,      9,2,3};
//
//	 sudoku[6] = new int[]{6,7,9,      4,5,8,      1,3,2};
//	 sudoku[7] = new int[]{4,5,2,      3,1,6,      8,7,9};
//	 sudoku[8] = new int[]{8,3,1,      7,9,2,      4,6,5};
		int[][] sudoku = new int[9][9];
		sudoku[0] = new int[]{2, 4, 5, 8, 7, 1, 3, 9, 6};
		sudoku[1] = new int[]{1, 0, 7, 6, 3, 9, 2, 5, 4};
		sudoku[2] = new int[]{9, 6, 3, 2, 4, 5, 7, 8, 1};

		sudoku[3] = new int[]{3, 2, 4, 9, 6, 7, 5, 1, 8};
		sudoku[4] = new int[]{5, 9, 8, 1, 0, 3, 6, 4, 7};
		sudoku[5] = new int[]{7, 1, 6, 5, 8, 4, 9, 2, 3};

		sudoku[6] = new int[]{6, 7, 9, 4, 5, 8, 1, 3, 2};
		sudoku[7] = new int[]{4, 5, 2, 3, 1, 6, 0, 7, 9};
		sudoku[8] = new int[]{8, 3, 1, 7, 9, 2, 4, 6, 5};
		Sudoku game = new Sudoku(sudoku);
		game.solve();
		System.out.println(game.isSolved());
	}

	public Sudoku() {
		this(new int[9][9]);
	}

	public Sudoku(int[][] board) {
		this.board = board;
		this.rows = board.length;
		this.columns = board[0].length;
	}

	public int[][] board() {
		return board;
	}

	public boolean[] candidates(int row, int column) {
		boolean[] candidates = new boolean[10];
		for (int i = 1; i < candidates.length; i++) {
			candidates[i] = true;
		}

		int[] house = getHouse(row, column);
		int[] rowArray = getRow(row);
		int[] columnArray = getColumn(column);

		for (int i = 0; i < house.length; i++) {
			if (house[i] != 0) {
				candidates[house[i]] = false;
			}
		}

		for (int i = 0; i < rowArray.length; i++) {
			if (rowArray[i] != 0) {
				candidates[rowArray[i]] = false;
			}
		}

		for (int i = 0; i < columnArray.length; i++) {
			if (columnArray[i] != 0) {
				candidates[columnArray[i]] = false;
			}
		}

		return candidates;
	}

	private int[] getRow(int rowIndex) {
		return board[rowIndex];
	}

	private int[] getColumn(int columnIndex) {
		int[] column = new int[this.columns];
		for (int i = 0; i < column.length; i++) {
			column[i] = board[i][columnIndex];
		}

		return column;
	}

	int[] getHouse(int row, int column) {
		row = row / 3 * 3;
		column = column / 3 * 3;
		int[] house = new int[10];
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				house[i + k * 3] = board[i + row][k + column];
			}
		}
		return house;
	}

	//TODO private
	//TODO find extreme naked singles in which a row in a house is invalidated for a number becuase the same row of
	// another house requires the number to be placed in it.
	public boolean hiddenSingles() {
		boolean changesMade = false;
		for (int startRow = 0; startRow < 9; startRow += 3) {
			for (int startColumn = 0; startColumn < 9; startColumn += 3) {
				for (int i = 1; i <= 9; i++) {
					int timesFound = 0;
					int lastRow = -1, lastColumn = -1;
					for (int row = 0; row < 3; row++) {
						for (int column = 0; column < 3; column++) {
							if (candidates(startRow + row, startColumn + column)[i]) {
								timesFound++;
								System.out.println(i);
								lastRow = row;
								lastColumn = column;
							}
						}
					}
					if (timesFound == 1) {
						board[startRow + lastRow][startColumn + lastColumn] = i;
						changesMade = true;
					}
				}
			}
		}
		return changesMade;
	}

	public int[] numbersNotAllowedInRowOrColumn(int row, int column) {
		for (int walkRowOfHouses = row / 3 * 3, int column = column * 3 /3; walkRowOfHouses < 3 + row / 3 * 3; walkRowOfHouses++) {
			for (int rowInHouse = 0; rowInHouse < 3; rowInHouse++) {
				for (int columnInHouse = 0; columnInHouse < 3; columnInHouse++) {
					if (board[walkRowOfHouses + rowInHouse][] != 0)
				}
			}
		}
		for (int walkColumnOfHouses = 0; walkColumnOfHouses < 3; walkColumnOfHouses++) {

		}
	}

	public boolean nakedSingles() {
		boolean changesMade = false;
		for (int row = 0; row < this.rows; row++) {
			for (int column = 0; column < this.columns; column++) {
				int numbersFound = 0;
				for (boolean numPresent : candidates(row, column)) {
					if (numPresent)
						numbersFound++;
				}
				if (numbersFound == 1) {
					for (int i = 1; i <= 9; i++) {
						if (candidates(row, column)[i]) {
							board[row][column] = i;
							changesMade = true;
							break;
						}
					}
				}
			}
		}
		return changesMade;
	}
	public boolean isSolved() {
		for (int row = 0; row < 9; row++) {
			for (int column = 0; column < 9; column++) {
				if (board[row][column] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public void solve() {
		while (!isSolved() && (nakedSingles() || hiddenSingles()));
	}
}
