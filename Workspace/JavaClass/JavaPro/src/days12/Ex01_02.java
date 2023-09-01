package days12;

public class Ex01_02 {
public static void main(String[] args) {
	int [][] m = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
	};
	disp(m);
	int[]n=new int[m.length*m[0].length];
	//2차원-> 1차원
			for (int i = 0; i < m.length; i++) {
				
				for (int j = 0; j < m[i].length; j++) {
					n[m[0].length*i+j]=m[i][j];
				} // for
				
			} // for																			// 00 01 02 03  10 11 12 13
																								//0	1	2	3		4	5	6	7
	disp(n);
} // main

private static void disp(int[] n) {
	for (int i = 0; i < n.length; i++) {
		System.out.printf("[%d]",n[i]);
	} // for
	
}

private static void disp(int[][] m) {
	for (int i = 0; i < m.length; i++) {
		for (int j = 0; j < m[i].length; j++) {
			System.out.printf("[%02d] ",m[i][j]);
		} // for
		System.out.println();
	} // for
	
}
}
