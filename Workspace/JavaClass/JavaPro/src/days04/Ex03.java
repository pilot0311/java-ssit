package days04;

import java.util.Scanner;

/**
 * @author pilot
 * @date 2023. 7. 18. - 오전 10:48:04
 * @subject	제어문
 * @content
 */
public class Ex03 {

	public static void main(String[] args) {
		// 제어문
		//	1. 정의:	프로그램의 실행 순서를 제어하는 문
		//					(건너띄기, 반복 처리 등등)
		//	2.	종류
		//		1)	조건문			if,	ifelse,	ifelseif	...else
		//		2)	분기문			switch
		//		3)	반복문			for,	foreach
		//		4)	조건반복문	do~while	while
		//		5)	기타			break,	continue
		
		//condition(조건식):	참/거짓으로 판가름할 수 있는 식
		//boolean
		/*
		if (condition) {
			
			//조건식이 참일때만 { }수행
		}//if
		*/
		
		//정수를 입력받아서 n변수에 저장을 하고 출력
		//입력값에 대한 유효성 검사 코딩 추가
		//짝수일경우 짝수 출력
		int n;
		//sc.close(); 자동 close되어짐
		try (Scanner sc = new Scanner(System.in);){
			
			System.out.print("정수 입력");
			n=sc.nextInt();
			if (n%2==0) {
				System.out.printf("%d는 짝수 입니다\n",n);
			}
			if (n%2!=0) {
				System.out.printf("%d는 홀수 입니다\n",n);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}//main

}//class
