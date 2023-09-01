package days01;


/**
 * @author pilot
 * @date 2023. 7. 13. - 오후 3:39:05
 * @subject 자바의 변수와 상수
 * @content 	1. 변수,상수 개념
 * 					2. 변수 선언 형식
 * 					3. 예제
 */
public class Ex03 {
	public static void main(String[] args) {
		//1. 변수(variable)
		//	1)변하는 수(수학적 의미)
		//	2)메모리상의 값을 저장하는 공간(프로그램 언어)
		
		//2. 상수(const)
		//	1)변하지 않는 수(==고정된 수)
		//	2)메모리상의 값을 저장하는 공간(프로그램 언어)
		
		//[선언 형식] 1.클래스 2.함수(메서드)
		//3. 변수 선언 형식
		//		자료형 변수명 [=초기 값];
		//		자료형 == 데이터 타입(data type)
		
		//4. 실습
		// ;세미콜론 명령라인 종결
		// cannot be resolved to a variable 
		//자바에서 문자열 == 문자의 나열  "문자열"
		//자바에서 한 문자    '신'
		//신기범 = 변수로 인식
		//이름을 저장하는 문자열 변수 선언
		//변수 이름을 명명하는 규칙
		//1)반드시  숫자가 아닌 문자로 시작(한글도 가능)
		//2)공백을 포함 할 수 없다
		//3)특수 기호는 $ _ 만 허용
		//4)대/소문자 구분한다 ex)score 와 SCORE는 다른 변수
		//5)자바에서 미리 지정한 예약어 사용 못함 ex)int, class, public 등 사용 불가
		//6)소문자로 시작 하고 새로운 단어가 결합되면 첫글자는 대문자로 변경 ex)javaScript
		
		System.out.println("신기범");
		//System.out.println(신기범); 오류  신기범 = 변수로 인식
//		String s = "신기범"; // =대입(할당)연산자
		//Duplicate local variable s = 지역 변수 중복
		String s = "신기범"; // =대입(할당)연산자
		System.out.println(s);
		String s1 = "hello";
		System.out.println(s1);
		s = "world";
		System.out.println(s);
		
		
		
	}//main

}//class
