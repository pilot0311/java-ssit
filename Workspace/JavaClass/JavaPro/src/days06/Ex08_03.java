package days06;

public class Ex08_03 {

	public static void main(String[] args) {
		// *      i=1   j=1
		// **     i=2   j=2
		// ***    i=3   j=3
		// ****   i=4   j=4
		/*
		for (int i = 1; i <= 4; i++) {  // 행갯수
			for (int j = 1; j <= i; j++) { // 열(별)갯수
				System.out.print("*");
			} // for
			System.out.println();
		} // for
		 */


		// ****   i=1   j=4
		// ***    i=2   j=3
		// **     i=3   j=2
		// *      i=4   j=1
		//         j = 5 - i
		/*
		for (int i = 1; i <= 4; i++) {  // 행갯수
			for (int j = 1; j <= 5-i ; j++) { // 열(별)갯수
				System.out.print("*");
			} // for
			System.out.println();
		} // for
		*/
	 
//		___*
//		__**
//		_***
//		****
		
//		for (int i = 1; i <= 4; i++) {  // 행갯수
//			// 공백찍는for [2]
//			for (int j = 1; j <= 4-i; j++) { // 열(별)갯수
//				System.out.print("_");
//			} // for
//			
//			// 별찍는 for [1]
//			for (int j = 1; j <= i; j++) { // 열(별)갯수
//				System.out.print("*");
//			} // for
//			
//			System.out.println();
//		} // for
		//[4]
//		for (int i = 1; i <= 4; i++) {  // 행갯수
//		// 공백찍는for [2]
//		for (int j = 1; j <= i-1; j++) { // 열(별)갯수
//			System.out.print("_");
//		} // for
//		
//		// 별찍는 for [1]
//		for (int j = 1; j <= 5-i; j++) { // 열(별)갯수
//			System.out.print("*");
//		} // for
//		
//		System.out.println();
//	} // for
		
		
		// i=1   j=1
		// i=2   j=3
		// i=3   j=5
		//   2*i-1
		
//		for (int i = 1; i <=3 ; i++) { // 행갯수
//			// 공백 for
//			for (int j = 1; j <= 3-i; j++) {
//				System.out.print("_");
//			} // for 
//			// 별 for
//			for (int j = 1; j <= 2*i-1; j++) {
//				System.out.print("*");
//			} // for
//			System.out.println();
//		} // for
		

		// __
		// _
		// 
		// _
		// __
		
		// 3-i < 0 ? -1*(3-i) : 3-i
//		for (int i = 1; i <=5 ; i++) { // 행갯수
//			// 공백 for 
//			for (int j = 1; j <= Math.abs(3-i); j++) {
//				System.out.print("_");
//			} // for
//			// 별 for
//			System.out.println();
//		} // for i

	} // main

} // class
