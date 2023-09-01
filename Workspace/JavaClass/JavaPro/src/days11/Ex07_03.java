package days11;

import java.util.Arrays;

public class Ex07_03 {

	public static void main(String[] args) {
		//3차원 배열 선언
		//int[][][] m = new int[2][3][4];
		//	1.	배열의 크기: 배열명.length
		
//		System.out.println(m.length);			//면크기
//		System.out.println(m[0].length);		//행크기
//		System.out.println(m[1].length);		//행크기
//		System.out.println(m[0][0].length);		//열크기
//		System.out.println(m[0][1].length);		//열크기
//		System.out.println(m[0][2].length);		//열크기
//		System.out.println(m[1][0].length);		//열크기
//		System.out.println(m[1][1].length);		//열크기
//		System.out.println(m[1][2].length);		//열크기
		
		//3차원 배열 초기화
		int[][][]m= {
							{
								{ 1, 2, 3, 4 },
								{ 5, 6, 7, 8 }
							},
							{
								{ 9, 10, 11, 12 },
								{ 13, 14, 15, 16 }
							}
						};// 2/2/4
		System.out.println(Arrays.toString(m));
		//dispM(m);
		
	} // main

	private static void dispM(int[][][] m) {
		for (int i = 0; i < m.length; i++) {	//면크기
			System.out.printf("[%d]면\n",i);
			for (int j = 0; j < m[i].length; j++) {	//행크기
				System.out.printf("[%d]면[%d]행\n",i,j);
				for (int j2 = 0; j2 < m[i][j].length; j2++) {
					System.out.printf("m[%d][%d][%d]= %d\n",i,j,j2,m[i][j][j2]);
				} // for
			} // for
			System.out.println();
		} // for
		
	}
}
