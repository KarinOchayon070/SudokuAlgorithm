package com.hit.algorithm;

public interface IBacktrackingAlg {
	
	public void print();
	
	public boolean checkBoard();
			
	public String difficulty();
	
	public boolean SolveSudoku(int i, int j);
	
	public boolean isSafe(int value, int rowIndex, int columIndex);
	
	public boolean solve();

}
