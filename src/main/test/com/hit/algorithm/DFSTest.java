package com.hit.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class DFSTest {
	
	@Test
	public void valid_grid_solution() {
		
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
		boolean isSameResult = TestUtils.isGridValid(dfsAlgo.getGrid(), solvedGrid);
		Assert.assertTrue(isSameResult);

	}
	
	@Test
	public void not_valid_grid() {
		
		int grid[][] = { { 3, 0, 6, 5, 3, 8, 4, 0, 0 },
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },
				{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		
		
		
		DFSAlgo dfsAlgo = new DFSAlgo(grid);
		Assert.assertFalse(dfsAlgo.solve());		
	}
	
	
	
	@Test
	public void is_number_safe() {
		
		int grid[][] = { { 3, 0, 6, 5, 3, 8, 4, 0, 0 },
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },
				{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
				
		
		DFSAlgo dfsAlgo = new DFSAlgo(grid);
		Assert.assertFalse(dfsAlgo.isSafe(3, 0, 1));
	}
	

}
