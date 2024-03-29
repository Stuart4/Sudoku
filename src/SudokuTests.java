import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class SudokuTests extends TestCase {

 /**
  * A test method.
  * (Replace "X" with a name describing the test.  You may write as
  * many "testSomething" methods in this class as you wish, and each
  * one will be called when running JUnit over this class.)
  */
 public void testNakedSinglesRow() {
  int[][] board = new int[9][9];
  board[0] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[1] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[2] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[3] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[4] = new int[]{1, 2, 3, 0, 5, 4, 7, 8, 9};
  board[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[8] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  Sudoku game = new Sudoku(board);
  assertTrue(game.nakedSingles());
 }

 public void testNakedSinglesColumn() {
  int[][] board = new int[9][9];
  board[0] = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0};
  board[1] = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0};
  board[2] = new int[]{3, 0, 0, 0, 0, 0, 0, 0, 0};
  board[3] = new int[]{4, 0, 0, 0, 0, 0, 0, 0, 0};
  board[4] = new int[]{5, 0, 0, 0, 0, 0, 0, 0, 0};
  board[5] = new int[]{6, 0, 0, 0, 0, 0, 0, 0, 0};
  board[6] = new int[]{7, 0, 0, 0, 0, 0, 0, 0, 0};
  board[7] = new int[]{8, 0, 0, 0, 0, 0, 0, 0, 0};
  board[8] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  Sudoku game = new Sudoku(board);
  assertTrue(game.nakedSingles());
 }

 public void testNakedSinglesHouse() {
  int[][] board = new int[9][9];
  board[0] = new int[]{1, 2, 3, 0, 0, 0, 0, 0, 0};
  board[1] = new int[]{6, 0, 4, 0, 0, 0, 0, 0, 0};
  board[2] = new int[]{7, 8, 5, 0, 0, 0, 0, 0, 0};
  board[3] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[8] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  Sudoku game = new Sudoku(board);
  assertTrue(game.nakedSingles());
 }

 public void testHiddenSinglesRow() {
  int[][] board = new int[9][9];
  board[0] = new int[]{6, 0, 0, 0, 0, 0, 0, 0, 0};
  board[1] = new int[]{6, 0, 0, 0, 0, 0, 0, 0, 0};
  board[2] = new int[]{6, 0, 0, 0, 0, 0, 0, 0, 0};
  board[3] = new int[]{6, 0, 0, 0, 0, 0, 0, 0, 0};
  board[4] = new int[]{1, 2, 3, 0, 0, 4, 7, 8, 9};
  board[5] = new int[]{6, 0, 0, 0, 0, 0, 0, 0, 0};
  board[6] = new int[]{6, 0, 0, 0, 0, 0, 0, 0, 0};
  board[7] = new int[]{0, 0, 0, 0, 6, 0, 0, 0, 0};
  board[8] = new int[]{6, 0, 0, 0, 0, 0, 0, 0, 0};
  Sudoku game = new Sudoku(board);
  assertTrue(game.hiddenSingles());
 }

 public void testHiddenSinglesColumn() {
  int[][] board = new int[9][9];
  board[0] = new int[]{0, 6, 6, 6, 6, 6, 6, 1, 6};
  board[1] = new int[]{0, 0, 0, 0, 0, 0, 0, 2, 0};
  board[2] = new int[]{0, 0, 0, 0, 0, 0, 0, 3, 0};
  board[3] = new int[]{0, 0, 0, 0, 0, 0, 0, 4, 0};
  board[4] = new int[]{6, 0, 0, 0, 0, 0, 0, 0, 0};
  board[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 7, 0};
  board[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};
  board[8] = new int[]{0, 0, 0, 0, 0, 0, 0, 9, 0};
  Sudoku game = new Sudoku(board);
  assertTrue(game.hiddenSingles());
 }

 public void testHiddenSinglesHouse() {
  int[][] board = new int[9][9];
  board[0] = new int[]{0, 0, 0, 0, 6, 0, 0, 0, 0};
  board[1] = new int[]{1, 0, 5, 0, 0, 0, 0, 0, 0};
  board[2] = new int[]{0, 0, 0, 0, 6, 0, 0, 0, 0};
  board[3] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  board[8] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
  Sudoku game = new Sudoku(board);
  assertTrue(game.hiddenSingles());
 }

 public void testConstructors() {
  Sudoku s1 = new Sudoku();
  Sudoku s2 = new Sudoku(new int[9][9]);
  s1.board();
  assertFalse(s1 == s2);
 }

 public void testSolve() {
  int[][] board = new int[9][9];
  board[0] = new int[]{2, 6, 3, 4, 1, 0, 5, 9, 0};
  board[1] = new int[]{0, 8, 0, 6, 0, 3, 0, 0, 4};
  board[2] = new int[]{7, 0, 1, 0, 0, 8, 3, 6, 0};
  board[3] = new int[]{0, 7, 2, 0, 0, 4, 0, 5, 0};//when third number is not 2 - loop
  board[4] = new int[]{0, 3, 0, 0, 0, 6, 9, 0, 0};
  board[5] = new int[]{0, 0, 0, 3, 0, 1, 8, 0, 6};
  board[6] = new int[]{0, 2, 7, 1, 3, 9, 0, 8, 0};
  board[7] = new int[]{0, 0, 0, 7, 4, 5, 2, 0, 1};
  board[8] = new int[]{3, 1, 0, 8, 0, 2, 0, 0, 0};

  Sudoku s = new Sudoku(board);
  s.solve();
  assertTrue(s.isSolved());

  int[][] sudoku = new int[9][9];
  sudoku[0] = new int[]{2, 4, 5, 8, 0, 1, 3, 9, 6};
  sudoku[1] = new int[]{1, 0, 7, 6, 3, 9, 0, 5, 0};
  sudoku[2] = new int[]{0, 6, 0, 2, 4, 5, 7, 0, 1};
  sudoku[3] = new int[]{3, 0, 4, 9, 6, 7, 5, 1, 8};
  sudoku[4] = new int[]{5, 9, 8, 1, 0, 3, 6, 4, 7};
  sudoku[5] = new int[]{7, 1, 6, 5, 8, 4, 0, 2, 3};
  sudoku[6] = new int[]{6, 7, 0, 4, 5, 8, 1, 3, 2};
  sudoku[7] = new int[]{4, 5, 2, 3, 0, 6, 0, 7, 9};
  sudoku[8] = new int[]{8, 0, 1, 7, 9, 2, 4, 6, 5};
  Sudoku game = new Sudoku(sudoku);
  game.solve();

  s = new Sudoku(board);
  assertTrue(!s.isSolved());
 }
}
