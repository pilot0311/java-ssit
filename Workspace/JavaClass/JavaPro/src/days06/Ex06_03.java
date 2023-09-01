package days06;

public class Ex06_03 {

	public static void main(String[] args) {
		//가로로 출력
//		for (int dan = 2; dan <= 9; dan++) {
//			for (int i = 1; i <= 9; i++) {
//				System.out.printf("%d*%d=%02d \t", dan, i, dan * i);
//
//			} // for

		//세로로 출력
		for (int i = 2; i <= 9; i++) {
			System.out.printf("   [%d]단\t",i);
		} // for
		System.out.println();
		for (int i = 1; i <= 9; i++) {
			
			for (int dan = 2; dan <= 9; dan++) {
				
				System.out.printf("%d*%d=%02d\t", dan, i, i * dan);
				
			} // for
			
			System.out.println();
		} // for
	} // main
}
