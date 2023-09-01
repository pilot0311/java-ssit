package days12;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Test2 {

	public static void main(String[] args) {
		 int [] m = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12  };
		 dispM(m);
		 int [][] n = new int[6][2];  
		 swap(m,n);
		 dispM(n);
		 
		 
	} // main

	private static void swap(int[] m, int[][] n) {
		for (int i = 0; i < m.length; i++) {
			n[i/2][i%2]=m[i];
		} // for
		
	}

	private static void dispM(int[][] n) {
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i].length; j++) {
				System.out.printf("m[%d][%d]=%d ",i,j,n[i][j]);
			} // for
			System.out.println();
		} // for
		
	}

	private static void dispM(int[] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.printf("m[%d]=%d\n",i,m[i]);
		} // for
		
	}

	


	
}
