package days05;

public class Ex04 {
	public static void main(String[] args) {
		// [1] 1+2+3+...+10
//		int sum = 0;
//		for (int i = 1; i <= 10; i++) {
//			System.out.printf(i==10?"%d":"%d+", i);
//			sum += i;
//		} // for

		// [2]1+3+5+7+9 홀수
//		int sum = 0;
//		for (int i = 1; i <= 10; i++) {
//			if(i%2!=0) {
//			System.out.printf(i==9?"%d":"%d+", i);
//			sum += i;
//			}
//		} // for
		
		// [3]1+3+5+7+9
		//continue문 설명
//		int sum = 0;
//		for (int i = 1; i <= 10; i++) {
//			if (i % 2 == 0)
//				continue;
//			System.out.printf(i == 9 ? "%d" : "%d+", i);
//			sum += i;
//		} // for
		
		// [4]1~n 까지의 합 출력
//		int sum = 0;
//		int n =5;
//		for (int i = 1; i <= n; i++) {
//			
//			System.out.printf(i == n ? "%d" : "%d+", i);
//			sum += i;
//		} // for
		
		// [5]1+3+5+7+9
		int sum = 0;
		for (int i = 1; i <= 10; i+=2) {
			System.out.printf(i==9?"%d":"%d+", i);
			sum += i;
		} // for
		System.out.printf("=%d", sum);
	} // main
}
