package days03;

/**
 * @author pilot
 * @date 2023. 7. 17. - 오후 4:41:36
 * @subject	(시험) 인덱스 연산자 []
 * 						String[]	args
 * 						
 * @content
 */
public class Ex11 {

	public static void main(String[] args) {
		// 1. 국어 점수를 저장할 변수 선언
		//int kor;
		
		//	2.	국어점수를 5만명 저장할 변수 선언
		//	인덱스[]연산자를 사용해 배열 선언
		/*
		 *참조형: 배열 클래스 인터페이스
		 * 
		 * 1.	배열 정의: 동일한 자료형을 메모리 상에 연속적으로 놓이게 한것
		 * 2.	배열 선언 형식
		 * 		자료형[] 배열명 = new 자료형[배열크기];
		 * 		자료형 배열명[] = new 자료형[배열크기];
		 * */
		int[] kors = new int[5];
		System.out.println(kors.length); //배열명.length = 배열 크기
		System.out.println(kors.length - 1); //배열명.length-1 = 윗 첨자값
		kors[0] = 90;
		kors[1] = 100;
		kors[2] = 80;
		
		System.out.println(kors[0]);
		System.out.println(kors[1]);
		System.out.println(kors[2]);

	}

}
