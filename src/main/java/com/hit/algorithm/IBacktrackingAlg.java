package com.hit.algorithm;

public interface IBacktrackingAlg {
	
	public void print(int grid[][]);
	
	public boolean checkBoard(char[][] board);
	
	public boolean SolveSudoku(int[][] matrix, int i, int j);
	
	public boolean isSafe(int[][] matrix, int value, int rowIndex, int columIndex);

}
