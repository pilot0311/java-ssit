package days05;

import java.util.Scanner;

public class Ex04_02 {

	public static void main(String[] args) {
		// 1~10 합
		// [문제] 두 정수 n,m을 입력 받아 두 정수 사이의 합을 입력
		try (Scanner sc = new Scanner(System.in)) {
			int n, m;
			System.out.print("정수 입력:");
			n = sc.nextInt();
			System.out.print("정수 입력:");
			m = sc.nextInt();
			int sum = 0;
			//[1] if
//			if (n < m) {
//				for (; n <= m; n++) {
//					System.out.printf(n == m ? "%d" : "%d+", n);
//					sum += n;
//				} // for
//			} else {
//				for (; n >= m; n--) {
//					System.out.printf(n == m ? "%d" : "%d+", n);
//					sum += n;
//				}
//			}
			//[2]
//			if (n>m) {
//				int temp = n;
//				n=m;
//				m=temp;
//			} //if
//			for (; n <= m; n++) {
//				System.out.printf(n == m ? "%d" : "%d+", n);
//				sum += n;
//			} // for
			
			//[3]
//			int min= n>m?m:n;
//			int max= n>m?n:m;
//			for (; min <= max; min++) {
//				System.out.printf(min == max ? "%d" : "%d+", min);
//				sum += min;
//			} // for
			
			//[4] Math 클래스 - 수학과 관련된 메서드
			//		Math.random()
			int min= Math.min(n, m);
			int max= Math.max(n, m);
			for (; min <= max; min++) {
				System.out.printf(min == max ? "%d" : "%d+", min);
				sum += min;
			} // for
			
//			
			System.out.printf("=%d", sum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// main

}
