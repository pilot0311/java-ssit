package days02;

/**
 * @author pilot
 * @date 2023. 7. 14. - 오전 10:08:54
 * @subject 식별자와 키워드 구분
 * @content 변수, 상수, 리터럴 구분
 * 					성수 문법 - 대문자, final, 단어 사이에 _ 사용, 한번 할당시 다시 할당 못함
 */
public class Ex02 {

	public static void main(String[] args) {
		/* 키워드: 의미가 부여된 예약어
		 * 식별자: 개발자 부여한 이름들(변수명, 클래스명, 함수명 등등)*/
		
		String name;
		name = "qwe";
		//출력
		name = "asd";
		//출력
		
		//변수와 상수 설명
		// -값을 저장하는 메모리사으이 저장공간
		// - 변하는 수, 고정된수
		
		//원주울 PI 3.141592 = 실수
		//변수(숫자: 정수, 실수)
		 final double PI = 3.141592;
		//상수 선언: final 자료형 변수명 [=초기값;]
		 //상수 변수명은 대문자로 단어사이에는 _ 사용 ex) final String FIRST_NAME
		 //pi = 3.23; 오류 pi는 final로 상수 선언이 되있기에 다시 할당 불가
		 
		 // 리터럴		1	true	'A'	 3.14
		
	}//main

}//class
