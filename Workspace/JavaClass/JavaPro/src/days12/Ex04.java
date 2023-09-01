package days12;

import java.util.Iterator;

public class Ex04 {

	public static void main(String[] args) {
		int[][] m = new int[5][5];
		// fill(m);
		 //fill02(m);
		//fill03(m);
		 //fill04(m);
		 //fill05(m);
		 //fill05_2(m);
		magicSquare(m);// 마방진
		dispM(m);
	} // main

	private static void fill05(int[][] m) {
		int n = m.length;

		for (int count = 0; count < n * 2 - 1; count++) {
			for (int i = 0; i <= count; i++) {
				int j = count - i;
				if (i < n && j < n) {
					m[i][j] = 5 * i + j + 1;
				}
			}
		}
	}
	private static void fill05_2(int[][] m) {
	      int count =0;
	      int number = 1;
	      do {
	      for (int i = 0; i < m.length; i++) {   
	         for (int j = 0; j < m[i].length; j++) {   
	            if(i+j==count) {
	             m[i][j]=number++;      
	            }
	         } // for         
	      } // for
	      count++;

	      }while(count<24);
	      
	   }
	private static void magicSquare(int[][] m) {
		// 1) 첫번째 행의 가운데 열 = 1
		// 2-1) 출력값이 5의 배수라면 행만 증가
		// 2-2) 5의 배수 아니면 행 감소, 열 증가 반복
		// 3) 행이 -1 이된다면 가장큰 행값 처리
		// 4) 행열이 크기를 벗어 난다면 가장 작은 열값 처리
		int n = 1;
		int row = 0;
		int col = 2;
		while (n <= 25) {
			m[row][col] = n;
			dispM(m);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (n % 5 == 0) {
				row++;
			} else {
				row--;
				col++;

				if (row == -1)
					row = 4;

				else if (col == 5)
					col = 0;
			}
			n++;

		}

	}

	// 1 2 3 4 5 10 9 8 7 6 11 12 13 14 15 20 21 22 23 24 25
	private static void fill04(int[][] m) {
//		for (int i = 0; i < m.length; i++) {	
//			for (int j = 0; j < m[i].length; j++) {	
//				 m[i][i%2==0?j:4-j]=5*i+j+1;
//			} // for
//			
//		} // for

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = i % 2 == 0 ? 5 * i + j + 1 : 5 * (i + 1) - j;
			} // for

		} // for
	}

	private static void fill03(int[][] m) {
		// 00 01 02 03 04 5 10 15 20 25
		// 10 11 12 13 14 4 9 14 19 24
		// m[][]위치로
//		for (int i = 0; i < m.length; i++) {
//			for (int j = 0; j < m[i].length; j++) {
//
//				m[4-j][i]=m[i].length*i+j+1;
//				
//			} // for
//			
//		} // for
		// 값 계산하여 대입
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {

				m[i][j] = (5 - i) + 5 * j;

			} // for

		} // for
	}

	private static void fill02(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[4 - i][4 - j] = m[i].length * i + j + 1;
			} // for

		} // for

	}

	private static void fill(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = m[i].length * i + j + 1;
			} // for

		} // for

	}

	private static void dispM(int[][] m) {
		System.out.println("\n\n\n\n");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("[%02d]", m[i][j]);
			} // for
			System.out.println();
		} // for
		
	}
}
