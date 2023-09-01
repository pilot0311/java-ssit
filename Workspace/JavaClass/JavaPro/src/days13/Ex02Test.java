package days13;

public class Ex02Test {

	public static void main(String[] args) {
		int[][] m = new int[5][5];
		fillM(m);
		dispM(m);
	} // main

	private static void fillM(int[][] m) {
		
		for (int i = 0,n=1; i < m.length-1; i++) {
			
			for (int j = 0; j < m[i].length-1; j++) {
				m[i][j]=n++;
				m[i][4] += m[i][j];
				m[4][j] += m[i][j];
				m[4][4] += m[i][j];
			
				}	// for	
			} // for
		
		} 
		

	private static void dispM(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("[%02d]", m[i][j]);
			} // for
			System.out.println();
		} // for

	}
}
