import java.util.Arrays;
public class Sudoku {

	int[][] board;

	public Sudoku() {
		board = new int[9][9];

	}

	//creates a Sudoku with an initial board
	public Sudoku(int[][] board) {
		this.board = Arrays.copyOf(board, board.length);
	}

	//returns a copy of the current state of the board
	public int[][] board() {
		return Arrays.copyOf(board, board.length);
	}

	//returns list of candidates for a specific cell. Array contains
	//true at index i if i is a candidate for the cell at row and column,
	//so long as cell is not already set, in which case there are none
	public boolean[] candidates(int row, int column) {
		boolean[] candidates = new boolean[10];
		for (int i = 1; i < candidates.length; i++) {
			candidates[i] = true;
		}

		int houseRow = row / 3 * 3;
		int houseColumn = column / 3 * 3;

		for (int i = houseRow; i < 3 + houseRow; i++) {
			for (int j = houseColumn; j < 3 + houseColumn; j++) {
				if (board[i][j] != 0) {
					candidates[board[i][j]] = false;
				}
			}
		}

		for (int i = 0; i < board[row].length; i++) {
			if (board[row][i] != 0) {
				candidates[board[row][i]] = false;
			}
		}

		for (int i = 0; i < board.length; i++) {
			if (board[i][column] != 0) {
				candidates[board[i][column]] = false;
			}
		}
		return candidates;
	}

	//returns true if board is solved
	public boolean isSolved() {
		boolean isSolved = true;
		for (int row = 0; row < 9; row++) {
			boolean[] nums = new boolean[10];
			for (int col = 0; col < 9; col++) {
				nums[board[row][col]] = true;
			}
			for (int i = 1; i < nums.length; i++) {
				if (!nums[i]) {
					isSolved = false;
				}
			}
		}
		for (int row = 0; row < 9; row++) {
			boolean[] nums = new boolean[10];
			for (int col = 0; col < 9; col++) {
				nums[board[col][row]] = true;
			}
			for (int i = 1; i < nums.length; i++) {
				if (!nums[i]) {
					isSolved = false;
				}
			}
		}


		for (int houseRow = 0; houseRow < 9; houseRow += 3) {
			for (int houseCol = 0; houseCol < 9; houseCol += 3) {
				boolean[] nums = new boolean[10];
				for (int row = 0; row < 3; row++) {
					for (int col = 0; col < 3; col++) {
						nums[board[row + houseRow][col + houseCol]] = true;
					}
				}
				for (int i = 1; i < nums.length; i++) {
					if (!nums[i]) {
						isSolved = false;
					}
				}
			}
		}


		return isSolved;
	}

	public boolean nakedSingles() {

		boolean changesMade = false;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				boolean[] result = candidates(i, j);
				int possibleCandidates = 0;
				for (int k = 1; k < result.length; k++) {
					if (result[k]) {
						possibleCandidates++;
					}
				}
				if (possibleCandidates == 1 && board[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						if (result[k]) {
							board[i][j] = k;
							changesMade = true;
						}
					}
				}
			}
		}
		return changesMade;
	}

	public boolean hiddenSingles() {

		boolean changesMade = false;

		for (int number = 0; number <= 9; number++) {
			for (int row = 0; row < 9; row++) {
				int timesFound = 0;
				int lastRow = -1;
				int lastColumn = -1;
				for (int column = 0; column < 9; column++) {
					if (board[row][column] == number || (board[row][column] == 0 && candidates(row, column)[number])) {
						timesFound++;
						lastRow = row;
						lastColumn = column;
					}
				}

				if (timesFound == 1 && board[lastRow][lastColumn] == 0) {
					changesMade = true;
					board[lastRow][lastColumn] = number;
				}
			}

			for (int col = 0; col < 9; col++) {
				int timesFound = 0;
				int lastRow = -1;
				int lastColumn = -1;
				for (int row = 0; row < 9; row++) {
					if (board[row][col] == number || (board[row][col] == 0 && candidates(row, col)[number])) {
						timesFound++;
						lastRow = row;
						lastColumn = col;
					}
				}

				if (timesFound == 1 && board[lastRow][lastColumn] == 0) {
					changesMade = true;
					board[lastRow][lastColumn] = number;
				}
			}
			for (int houseRow = 0; houseRow < 9; houseRow += 9) {
				for (int houseCol = 0; houseCol < 9; houseCol += 9) {
					int timesFound = 0;
					int lastRow = -1;
					int lastColumn = -1;
					for (int row = 0; row < 3; row++) {
						for (int col = 0; col < 3; col++) {
							if (board[row + houseRow][col + houseCol] == number
								|| (board[row + houseRow][col + houseCol] == 0 &&
								candidates(row + houseRow, col + houseCol)[number])) {
								timesFound++;
								lastRow = row + houseRow;
								lastColumn = col + houseCol;
							}
						}
					}
					if (timesFound == 1 && board[lastRow][lastColumn] == 0) {
						changesMade = true;
						board[lastRow][lastColumn] = number;
					}
				}
			}
		}
		return changesMade;
	}

	//attempts to solve board. exits when solved or no updates made
	public void solve() {
		while (!isSolved() && (nakedSingles() || hiddenSingles())) ;
	}

	public static void main(String[] args) {
		int[][] sudoku = new int[9][9];
		sudoku[0] = new int[]{2, 4, 5, 0, 7, 0, 3, 9, 6};
		sudoku[1] = new int[]{1, 0, 7, 6, 3, 9, 2, 5, 4};
		sudoku[2] = new int[]{9, 6, 3, 2, 4, 5, 7, 8, 1};
		sudoku[3] = new int[]{3, 2, 0, 9, 6, 0, 5, 1, 0};
		sudoku[4] = new int[]{5, 9, 0, 1, 0, 3, 6, 4, 7};
		sudoku[5] = new int[]{7, 0, 6, 5, 8, 4, 9, 2, 3};
		sudoku[6] = new int[]{6, 7, 9, 4, 0, 8, 1, 0, 0};
		sudoku[7] = new int[]{4, 0, 2, 0, 1, 0, 0, 7, 9};
		sudoku[8] = new int[]{8, 3, 0, 0, 0, 2, 4, 6, 5};
		Sudoku game = new Sudoku(sudoku);
		game.solve();
	}

}