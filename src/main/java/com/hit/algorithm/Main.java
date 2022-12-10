package com.hit.algorithm;

public class Main {

	public static void main(String[] args) {		
		int grid1[][] = { { 0, 0, 1, 0, 0, 0, 9, 7, 0 },
                { 0, 0, 0, 4, 9, 0, 0, 1, 3 },
                { 0, 6, 9, 0, 3, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 8 },
                { 5, 8, 0, 0, 0, 0, 0, 0, 7 },
                { 0, 0, 0, 5, 8, 7, 3, 6, 1 },
                { 0, 0, 8, 0, 4, 0, 0, 0, 0 },
                { 0, 7, 0, 6, 1, 0, 0, 8, 0 },
                { 0, 0, 5, 8, 0, 2, 1, 0, 9 } };
		
		
		System.out.println("bitMaskAlgo solution\n");
		BitMaskAlgo bitMaskAlgo = new BitMaskAlgo(grid1);
		bitMaskAlgo.solve();
		
		
		
		int grid2[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },
				{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		
		
		System.out.println("\ndfsAlgo solution\n");
		DFSAlgo dfsAlgo = new DFSAlgo(grid2);
		dfsAlgo.solve();

	}

}
