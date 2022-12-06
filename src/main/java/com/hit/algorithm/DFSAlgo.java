package com.hit.algorithm;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

public class DFSAlgo implements IBacktrackingAlg {
	
		
	// Utility function to print the solved grid
	     public void print(int grid[][])
	    {
	        for (int i = 0; i < grid.length; i++) {
	            for (int j = 0; j < grid[0].length; j++) {
	                System.out.printf("%d ", grid[i][j]);
	            }
	            System.out.println();
	        }
	    }
	    
	    public boolean checkBoard(char[][] board){
	        HashSet<String>seen = new HashSet<>();
	         for(int i=0; i<9; i++){
	             for(int j=0; j<9; j++){
	                 char current_val = board[i][j];
	                 if(current_val != '.'){
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

	    

	    public boolean isSafe(int[][] matrix, int value, int rowIndex, int columIndex){

	        //Check Row
	        for(int j=0; j<9; j++){
	            if(matrix[rowIndex][j] == value){
	                return false;
	            }
	        }

	        //Check Coulmn
	        for(int i=0; i<9; i++){
	            if(matrix[i][columIndex] == value){
	                return false;
	            }
	        }

	        //Check Submatrix
	        int baseRowIndex = rowIndex - (rowIndex % 3);
	        int baseColumnIndex = columIndex - (columIndex % 3);
	        for(int i = baseRowIndex; i< baseRowIndex+3; i++){
	            for(int j = baseColumnIndex; j<baseColumnIndex+3; j++){
	                if(matrix[i][j]== value){
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    
	    public boolean SolveSudoku(int[][] matrix, int n, int x){
	        int rowIndex = -1;
	        int columnIndex = -1;
	        int i = 0;
	        int j =0;

	        for(i=0; i<n; i++){
	            for(j=0; j<n; j++){
	                if(matrix[i][j]==0){
	                    rowIndex = i;
	                    columnIndex = j;
	                    break;
	                }
	            }
	            if(rowIndex != -1){
	                break;
	            }
	        }
	        if(i==n && j==n){
	            return true;
	        }
	        else{
	            for(int value=1; value<10; value++){
	                if(isSafe(matrix, value, rowIndex, columnIndex)){
	                    matrix[rowIndex][columnIndex] = value;
	                    if(!SolveSudoku(matrix,n, 0)){
	                        matrix[rowIndex][columnIndex] = 0;
	                    }
	                    else{
	                        return true;
	                    }
	                }
	            }
	            return false;
	        }
	    }
	    
	    // Driver code
	    public void main()
	    {
	        // 0 means unassigned cells
	        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
	                         { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
	                         { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
	                         { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
	                         { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
	                         { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
	                         { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
	                         { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
	                         { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
	 
	        if (SolveSudoku(grid, 9, 0))
	            print(grid);
	        else
	            System.out.println("No solution exists");
	    }
	    
	    
	    
	}


