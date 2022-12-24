package com.hit.algorithm;

import java.util.HashSet;
 
public class BitMaskAlgo implements IBacktrackingAlg {
	
    private int N = 9;
    private int numberOfSteps = 0;
    
    private int[][] grid; //The board
    private int row[] = new int[N], col[] = new int[N], box[] = new int[N]; //Row, col and submatrix
        
	public void setGrid(int[][] grid) {
		this.grid = grid;
		this.setInitialValues();
		this.numberOfSteps = 0;
	}
    
    
	public int[][] getGrid() {
		return grid;
	}
	
	public String getDifficulty() {
		if(numberOfSteps <= 900) {
			return "Easy";
		}
		else if(numberOfSteps > 900 && numberOfSteps<7000) {
			return "Meduim";
		}
		return "Hard";
	}
	
	
	//The id of each sudoku template will be the board itself (purpose - creating unique id)
    public String getId() {
    	String id = "";
    	for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                id+=this.grid[i][j];
            }
        }
    	return id;
    }
    
 
    // Utility function to find the box index
    // of an element at position [i][j] in the grid
    public int getBox(int i, int j){
        return i / 3 * 3 + j / 3;
    }
    
    public boolean isValidGrid(){
        HashSet<String>seen = new HashSet<>();
         for(int i=0; i<9; i++){
             for(int j=0; j<9; j++){
                 int current_val = this.grid[i][j];
                 if(current_val != 0){
                     if(!seen.add(current_val + "found in row " + i) ||
                             !seen.add(current_val + "found in column " + j) ||
                             !seen.add(current_val + "found in submatrix " + i/3 + j/3)){

                         return false;
                     }
                 }
             }
         }
        return true;
    }
 
    // Utility function to check if a number
    // is present in the corresponding row/column/box
    public boolean isSafe(int number, int i, int j){
        return ((row[i] >> number) & 1) == 0
            && ((col[j] >> number) & 1) == 0
            && ((box[getBox(i, j)] >> number) & 1) == 0;
    }
 
    // Utility function to set the initial values of a
    // Sudoku board (map the values in the bitmasks)
    public void setInitialValues(){
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid.length; j++) {
                row[i] |= 1 << this.grid[i][j];
                col[j] |= 1 << this.grid[i][j];
                box[getBox(i, j)] |= 1 << this.grid[i][j];
            }
        }
    }
 
    /* Takes a partially filled-in grid and attempts
      to assign values to all unassigned locations in
      such a way to meet the requirements for
      Sudoku solution (non-duplication across rows,
      columns, and boxes) */
    public boolean SolveSudoku(int i, int j){ 
    	numberOfSteps+=1;
        if (i == N - 1 && j == N)
            return true;
        if (j == N) {
            j = 0;
            i++;
        }
 
        if (this.grid[i][j] > 0) {
            return SolveSudoku(i, j + 1);
        }
 
        for (int nr = 1; nr <= N; nr++) {
            if (isSafe(nr, i, j)) {
                /* Assign nr in the
                            current (i, j)
                            position and
                            add nr to each bitmask
                        */
                grid[i][j] = nr;
                row[i] |= 1 << nr;
                col[j] |= 1 << nr;
                box[getBox(i, j)] |= 1 << nr;
 
                if (SolveSudoku(i, j + 1))
                    return true;
 
                // Remove nr from each bitmask
                // and search for another possibility
                row[i] &= ~(1 << nr);
                col[j] &= ~(1 << nr);
                box[getBox(i, j)] &= ~(1 << nr);
            }
 
            this.grid[i][j] = 0;
        }
 
        return false;
    }
 
    // Utility function to print the solved grid
    public void print(){
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                System.out.printf("%d ", this.grid[i][j]);
            }
            System.out.println();
        }
    }
 

    public boolean solve(){
        return SolveSudoku(0, 0);   
    }
}
 