package days02;

/**
 * @author pilot
 * @date 2023. 7. 14. - 오전 10:22:15
 * @subject 지역변수(local variable)
 * @content
 */
public class Ex03 {

	public static void main(String[] args) {
		//문자열  정수형 실수형
		//String, int, double
		//한 문자를 저장하는 자료형: char
		//자바에서 문자를 나타낼 때는 '한문자'
		
		char grade = 'A'; //(지역변수)
		//코드영역(블럭)
		//{}영역(범위)연산자
		{
			
			System.out.printf("등급: '%c'", grade);
		}
		//grade cannot be resolved to a variable: grade 변수 인식 못함
		System.out.printf("등급: '%c'", grade);
	}//main

}//class
