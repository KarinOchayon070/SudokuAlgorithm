package com.hit.algorithm;

public class TestUtils {

	public static boolean isGridValid(int solvedByAlg[][], int solvedGrid[][]) {
		
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

}
