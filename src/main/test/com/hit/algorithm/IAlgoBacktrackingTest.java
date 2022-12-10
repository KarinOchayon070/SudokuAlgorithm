package com.hit.algorithm;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class IAlgoBacktrackingTest {
	
	
	public boolean isGridValid(int solvedByAlg[][], int solvedGrid[][]) {
		
		for (int i = 0; i < solvedByAlg.length; i++) {
			for (int j = 0; j < solvedByAlg[i].length; j++) {
				
			int solvedByAlgGridItem = solvedByAlg[i][j];
			int solvedGridItem = solvedGrid[i][j];
			
				if(solvedByAlgGridItem != solvedGridItem) {
					return false;
				}		
			}
		}
		return true;
	}
	
	
	
	@Test
	public void DFSTest() {	
		int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
		                 { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
		                 { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
		                 { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
		                 { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
		                 { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
		                 { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
		                 { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
		                 { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		
		int solvedGrid[][] = { {3, 1, 6, 5, 7, 8, 4, 9, 2 }, 
				   			 {5, 2, 9, 1, 3, 4, 7, 6, 8 }, 
				   			 {4, 8, 7, 6, 2, 9, 5, 3, 1 }, 
				   			 {2, 6, 3, 4, 1, 5, 9, 8, 7 }, 
				   			 {9, 7, 4, 8, 6, 3, 1, 2, 5 }, 
				   			 {8, 5, 1, 7, 9, 2, 6, 4, 3 }, 
				   			 {1, 3, 8, 9, 4, 7, 2, 5, 6 }, 
				   			 {6, 9, 2, 3, 5, 1, 8, 7, 4 }, 
				   			 {7, 4, 5, 2, 8, 6, 3, 1, 9 }  };
		 
		DFSAlgo dfsAlgo = new DFSAlgo(grid);
		dfsAlgo.solve();
		boolean isSameResult = this.isGridValid(dfsAlgo.getGrid(), solvedGrid);
		
		Assert.assertTrue(isSameResult);
	}
	
	@Test
	public void bitMaskTest() {
		int grid[][] = { { 0, 0, 1, 0, 0, 0, 9, 7, 0 },
		                 { 0, 0, 0, 4, 9, 0, 0, 1, 3 },
		                 { 0, 6, 9, 0, 3, 1, 0, 0, 0 },
		                 { 0, 0, 0, 0, 0, 0, 0, 0, 8 },
		                 { 5, 8, 0, 0, 0, 0, 0, 0, 7 },
		                 { 0, 0, 0, 5, 8, 7, 3, 6, 1 },
		                 { 0, 0, 8, 0, 4, 0, 0, 0, 0 },
		                 { 0, 7, 0, 6, 1, 0, 0, 8, 0 },
		                 { 0, 0, 5, 8, 0, 2, 1, 0, 9 } };

		int solvedGrid[][] = { {8, 3, 1, 2, 5, 6, 9, 7, 4 },
							   {2, 5, 7, 4, 9, 8, 6, 1, 3 },
							   {4, 6, 9, 7, 3, 1, 8, 5, 2 },
							   {7, 1, 6, 9, 2, 3, 5, 4, 8 },
							   {5, 8, 3, 1, 6, 4, 2, 9, 7 },
							   {9, 2, 4, 5, 8, 7, 3, 6, 1 },
							   {1, 9, 8, 3, 4, 5, 7, 2, 6 },
							   {3, 7, 2, 6, 1, 9, 4, 8, 5 },
							   {6, 4, 5, 8, 7, 2, 1, 3, 9 } };
	
		BitMaskAlgo bitMaskAlgo = new BitMaskAlgo(grid);
		bitMaskAlgo.solve();
		boolean isSameResult = this.isGridValid(bitMaskAlgo.getGrid(), solvedGrid);
			
		Assert.assertTrue(isSameResult);
	
	}
}
