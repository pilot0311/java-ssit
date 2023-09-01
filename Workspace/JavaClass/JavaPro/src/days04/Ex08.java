package days04;

import java.util.Scanner;

public class Ex08 {
	public static void main(String[] args) {
		//
		//	if 조건문
		// for 반복문
		// switch 분기문
		
		//key:	변수, 수식 (정수, 문자열, 문자)
		//value:	 리터럴, 변수X
		/*
		switch (key) {
		case value:	//case는 여러개 있어되 됨
			
			break;

		[default:		// default = 생략가능
			break;]
		}
		*/
		//정수 입력 받아서  짝수 홀수 출력
		int n;
		String result = null; // String 기본값 null 할당
		try (Scanner sc = new Scanner(System.in);) {
			
			System.out.print("정수 입력");
			n = sc.nextInt();
			switch (n % 2) {
			case 0:
				result = "짝수";
				break;
			case 1:
				result = "홀수";
				break;

			} // switch
				// The local variable result may not have been initialized 변수 초기화 안됨
			System.out.println(result);

		} catch (Exception e) {
			System.out.println("end");
		}

	} // main
}
