package com.hit.algorithm;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

public class DFSAlgo implements IBacktrackingAlg {
	
	private int[][] grid;


	DFSAlgo(int grid[][]){
		this.grid = grid;
	}
	
	public int[][] getGrid() {
		return grid;
	}
	
		
	// Utility function to print the solved grid
	     public void print()
	    {
	        for (int i = 0; i < this.grid.length; i++) {
	            for (int j = 0; j < this.grid[0].length; j++) {
	                System.out.printf("%d ", this.grid[i][j]);
	            }
	            System.out.println();
	        }
	    }
	    
//	    public boolean checkBoard(char[][] board){
//	        HashSet<String>seen = new HashSet<>();
//	         for(int i=0; i<9; i++){
//	             for(int j=0; j<9; j++){
//	                 char current_val = board[i][j];
//	                 if(current_val != '.'){
//	                     if(!seen.add(current_val + "found in row " + i) ||
//	                             !seen.add(current_val + "found in column " + j) ||
//	                             !seen.add(current_val + "found in submatrix " + i/3 + j/3)){
//
//	                         return false;
//	                     }
//	                 }
//	             }
//	         }
//	        return true;
//	    }

	    

	    public boolean isSafe(int value, int rowIndex, int columIndex){

	        //Check Row
	        for(int j=0; j<9; j++){
	            if(this.grid[rowIndex][j] == value){
	                return false;
	            }
	        }

	        //Check Coulmn
	        for(int i=0; i<9; i++){
	            if(this.grid[i][columIndex] == value){
	                return false;
	            }
	        }

	        //Check Submatrix
	        int baseRowIndex = rowIndex - (rowIndex % 3);
	        int baseColumnIndex = columIndex - (columIndex % 3);
	        for(int i = baseRowIndex; i< baseRowIndex+3; i++){
	            for(int j = baseColumnIndex; j<baseColumnIndex+3; j++){
	                if(this.grid[i][j]== value){
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    
	    public boolean SolveSudoku(int n, int x){
	        int rowIndex = -1;
	        int columnIndex = -1;
	        int i = 0;
	        int j =0;

	        for(i=0; i<n; i++){
	            for(j=0; j<n; j++){
	                if(this.grid[i][j]==0){
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
	                if(isSafe(value, rowIndex, columnIndex)){
	                    this.grid[rowIndex][columnIndex] = value;
	                    if(!SolveSudoku(n, 0)){
	                    	this.grid[rowIndex][columnIndex] = 0;
	                    }
	                    else{
	                        return true;
	                    }
	                }
	            }
	            return false;
	        }
	    }
	    
	    
	    public boolean solve()
	    {
	        return SolveSudoku(9, 0);        
	    }
	    
	    
	    
	}


