package days04;

import java.util.Scanner;

/**
 * @author pilot
 * @date 2023. 7. 18. - 오전 10:48:04
 * @subject 제어문
 * @content
 */
public class Ex03_02 {

	public static void main(String[] args) {

		// 정수를 입력받아서 n변수에 저장을 하고 출력
		// 입력값에 대한 유효성 검사 코딩 추가
		// 짝수일경우 짝수 출력
		int n;
		// sc.close(); 자동 close되어짐
		try (Scanner sc = new Scanner(System.in);) {

			System.out.print("정수 입력");
			n = sc.nextInt();
			
			String result = "짝수";
			if (n%2!=0) {
				result = "홀수";
			}
			
//			if (n % 2 == 0) {
//				//System.out.printf("%d는 짝수 입니다\n", n);
//				result = "짝수";
//			} else {
//				//System.out.printf("%d는 홀수 입니다\n", n);
//				result = "홀수";
//			}
//			
			System.out.printf("%d는 %s 입니다\n", n,result);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}// main

}// class
