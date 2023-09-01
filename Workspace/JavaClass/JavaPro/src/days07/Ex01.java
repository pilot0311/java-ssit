package days07;

public class Ex01 {

	public static void main(String[] args) {
		//1.	구구단 가로 출력
		// for i =1
		//		for j =1
		// i=1 j=1,2,3,4...9
		// i=2 j=1,2,3,4...9
		// 2*1 2*2 2*3
			
//				for (int dan = 2; dan <=9; dan++) {
//					for (int i = 1; i <= 9 ; i++) {
//					System.out.printf("%d*%d=%2d\t",dan,i,dan*i);					
//				} // for
//				System.out.println();
//			} // for
		
			//[2]	구구단 세로 출력
//		for (int i = 2; i <=9; i++) {
//			System.out.printf("  [%d단]\t",i);
//		} // for
//		System.out.println();
//			for (int i = 1; i <= 9 ; i++) {
//				for (int dan = 2; dan <=9; dan++) {
//					System.out.printf("%d*%d=%2d\t",dan,i,dan*i);					
//				} // for
//				System.out.println();
//			} // for
		
		//[3]이등변 삼각형 별찍기
		// --*		i = 1 	 j =2
		// -***	i =2	j=1
		// *****i = 3 j=0
		for (int i = 1; i <=3; i++) { //행
			
			for (int j = 1; j <=5; j++) {
				if(i+j>=4 && j-i<=2 )System.out.printf("*");
				else System.out.printf("_");
			} // for
			System.out.println();
		} // for
		
		//[4]
//		for (int i = 1; i <=5; i++) {
//			for(int j=1;j<=5; j++) {
//				
//				if((i==j) || (j+i==6)) {
//				System.out.printf("*");
//				}else
//					System.out.printf("_");		
//			}
//			System.out.println();
//		} // for
		
	} // main
}
