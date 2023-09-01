package days05;

import java.util.Scanner;

public class Ex04_03 {

	public static void main(String[] args) {
		// 1~10 합
		// [문제] 두 정수 n,m을 입력 받아 두 정수 사이의 홀수 합을 입력
		try (Scanner sc = new Scanner(System.in)) {
			int n, m;
			System.out.print("정수 입력:");
			n = sc.nextInt();
			System.out.print("정수 입력:");
			m = sc.nextInt();
			int sum = 0;
			int min = Math.min(n, m);
			int max = Math.max(n, m);
			if(min%2==0)min++;
			for (; min <= max; min+=2) {
				//if (min % 2 != 0) {
					System.out.printf(min == max ? "%d" : "%d+", min);
					sum += min;
			//	} // if
			} // for

//			
			System.out.printf("=%d", sum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// main

}
