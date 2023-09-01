package days06;

public class Ex06_04 {

	public static void main(String[] args) {

		// 세로로 출력
//		for (int k = 1; k <= 2; k++) {
//			for (int i = 4 * k - 2; i <= 4 * k + 1; i++) {
//				System.out.printf("   [%d]단\t", i);
//			} // for
//			System.out.println();
//			for (int i = 1; i <= 9; i++) {
//
//				for (int dan = 4 * k - 2; dan <= 4 * k + 1; dan++) {
//					System.out.printf("%d*%d=%02d\t", dan, i, i * dan);
//				} // for
//				System.out.println();
//			} // for
//
//			System.out.println();
//		} // for k
		// 2345		6789
		for (int k = 1; k <= 3; k++) {
			for (int dan = 3 * k - 1; dan <= 3 * k + 1 && dan != 10; dan++) {
				// if(dan==10)continue;
				System.out.printf("   [%d]단\t", dan);

			} // for
			System.out.println();
			for (int i = 1; i <= 9; i++) {

				for (int dan = 3 * k - 1; dan <= 3 * k + 1 && dan != 10; dan++) {
					// if(dan==10)break;
					System.out.printf("%d*%d=%02d\t", dan, i, i * dan);

				} // for
				System.out.println();
			} // for

			// System.out.println();
		} // for k
	} // main
}
