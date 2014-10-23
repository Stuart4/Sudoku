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
  Sudoku game = new Sudoku();
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



  return candidates;
 }

 private int[] getColumn(int columnIndex) {
  int[] column = new int[this.columns];
  for (int i = 0; i < column.length; i++) {
   column[i] = board[i][columnIndex];
  }

  return column;
 }

 private int[] getHouse(int row, int column) {
  row = row / 3 * 3;
  column = column / 3 * 3;
  int[] house = new int[9];
  for (int i = 0; i < 3; i++) {
   for (int k = 0; k < 3; k++) {
    house[i + k] = board[i][k];
   }
  }
 }

 public boolean isSolved() {
  return isSolved;
 }

 public void solve() {

  isSolved = true;
 }
}
