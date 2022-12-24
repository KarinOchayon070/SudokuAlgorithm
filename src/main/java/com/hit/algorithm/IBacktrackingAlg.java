package com.hit.algorithm;

public interface IBacktrackingAlg {
	
	public void print();
	
	public boolean isValidGrid();
			
	public int[][] getGrid();
	
	public void setGrid(int[][] grid);
	
	public String getId();
	
	public String getDifficulty();
	
	public boolean SolveSudoku(int i, int j);
	
	public boolean isSafe(int value, int rowIndex, int columIndex);
	
	public boolean solve();

}
