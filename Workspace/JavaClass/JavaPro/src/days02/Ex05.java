package days02;

/**
 * @author pilot
 * @date 2023. 7. 14. - 오전 11:04:36
 * @subject 표준 입력, 표준 출력 => System클래스
 * @content 객체=개체=Object=클래스=물건
 * 					System 클래스 안에 [표준 출력 함수]
 * 					println(), printf(), print()
 * 					void	println​(이름, 나이)
 * 					PrintStream	printf​(String format, Object... args)
 * 					void	print​(이름, 나이)
 */				
public class Ex05 {
	
	public static void main(String[] args) {
		//java.lang 패키지 안에 있는 System 클래스
		//java.lang.System.out.println("trlqja");
		//함수(메서드) 3가지 파악 -> 정확히 사용할 수 있다
		//1. 함수의 기능(일) 파악
		//2. 함수가 일처리를 할 때 필요한 값 파악(매개변수, 파라미터, 인자, 인수)
		//3. 함수가 일처리를  한 후에 반환(리턴)하는 값 파악 (리턴 값, 리턴자료형)
		//예) main()함수
		//1. 기능: 프로그램 시작, 종료
		//2. 매개변수: Sring[] args 문자열 배열 args= 인자들
		//3. 리턴값: X, 리턴자료형 void선언
		
		//System.out.printf("qwer").printf("20");
		System.out.println("qwer");
		System.out.println("asdf");
		System.out.println("zxcv");
		
		//개행방법
		System.out.print("qwer" + '\n');
		System.out.print("asdf\n");
		System.out.print("zxcv");
		System.out.println(); //개행
		System.out.print("1234");
		
	}//main
}//class
