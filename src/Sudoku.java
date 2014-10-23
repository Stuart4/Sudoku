/**
 * Sudoku
 *
 * @author Jacob Stuart
 * @lab 806
 * @date October 21, 2014
 */
public class Sudoku {
 private int[][] board;
 private boolean isSolved;
 private int rows, columns;

 public static void main(String[] args) {
  int[][] sudoku = new int[9][9];
  sudoku[0] = new int[]{2,4,5,      8,7,1,      3,9,6};
  sudoku[1] = new int[]{1,8,7,      6,3,9,      2,5,4};
  sudoku[2] = new int[]{9,6,3,      2,4,5,      7,8,1};

  sudoku[3] = new int[]{3,2,4,      9,6,7,      5,1,8};
  sudoku[4] = new int[]{5,9,8,      1,2,3,      6,4,7};
  sudoku[5] = new int[]{7,1,6,      5,8,4,      9,2,3};

  sudoku[6] = new int[]{6,7,9,      4,5,8,      1,3,2};
  sudoku[7] = new int[]{4,5,2,      3,1,6,      8,7,9};
  sudoku[8] = new int[]{8,3,1,      7,9,2,      4,6,5};
  Sudoku game = new Sudoku(sudoku);
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
  boolean[] candidates = new boolean[9];
  for (int i = 0; i < candidates.length; i++) {
   candidates[i] = true;
  }

  int[] house = getHouse(row, column);
  int[] rowArray = getRow(row);
  int[] columnArray = getColumn(column);

  for (int i = 0; i < house.length; i++) {
   if (house[i] != 0) {
    candidates[house[i] - 1] = false;
   }
  }

  for (int i = 0; i < rowArray.length; i++) {
   if (rowArray[i] != 0) {
    candidates[rowArray[i] - 1] = false;
   }
  }

  for (int i = 0; i < columnArray.length; i++) {
   if (columnArray[i] != 0) {
    candidates[columnArray[i] - 1] = false;
   }
  }

  return candidates;
 }

 //TODO private
 public int[] getRow(int rowIndex) {
  return board[rowIndex];
 }

//TODO private
 public int[] getColumn(int columnIndex) {
  int[] column = new int[this.columns];
  for (int i = 0; i < column.length; i++) {
   column[i] = board[i][columnIndex];
  }

  return column;
 }
//TODO private
 public int[] getHouse(int row, int column) {
  row = row / 3 * 3;
  column = column / 3 * 3;
  int[] house = new int[9];
  for (int i = 0; i < 3; i++) {
   for (int k = 0; k < 3; k++) {
    house[i + k * 3] = board[i + row][k + column];
   }
  }
  return house;
 }

 public boolean isSolved() {
  return isSolved;
 }

 public void solve() {

  isSolved = true;
 }
}
