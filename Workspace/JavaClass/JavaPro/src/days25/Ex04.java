package days25;

import java.util.Date;
import java.util.Scanner;

public class Ex04 {

	
	public static void main(String[] args) {
		
		//	[	어노테이션(Annotation)	]
		/*
		 * 	1.	사전적 의미 : 주석
		 * 	2.	정의 : 프로그램의 소스 코드 안에 다른 프로그램을 위한 미리 약속된 형식을 포함시킨 것
		 * 3.	jdk 에서 기본적으로 제공하는 어노테이션을 "표준 어노테이션"이라고 한다
		 * 	4.	표준 어노테이션 -> 컴파일러(다른 프로그램)
		 * 	5.	표준 어노테이션
		 * 		1)	@Override : 컴파일러에게 오버라이딩 한 메서드임을 알려주는 표준 어노테이션
		 * 		2)	@SuppressWarnings : 컴파일러의 특정 경고 메세지가 나타나지 않게 사용하는 어노테이션
		 * 		3)	@Deprecated : 앞으로 없어질 생성자, 필드, 메서드 를 알려주는 어노테이션
		 * 		4)	@FunctionInterface : 함수형 인터페이스를 알려주는 어노테이션(람다식)
		 * 					함수 + 인터페이스
		 * 		5)	@SafeVarargs : 제네릭 타입의 가변인자에 사용되는 어노테이션
		 * 		6)	@Native : nativ 메서드에서 참조되는 상수 앞에 붙인다
		 * 					[C언어 메서드]
		 * 
		 * 			[메타 어노테이션] : 어노테이션에 사용되는 어노테이션
		 * 		7)	@Target
		 * 		8) @Documented
		 * 		9) @Inherited
		 * 		10) @Retention
		 * 		11) @Repeatable
		 */
			
		//	컴파일러가 경고
		// 선언했는데 사용 안함
		// 개발자가 컴파일러한테 더 이상 경고 억제 @SuppressWarnings("resource")
		@SuppressWarnings("unused" )
		Scanner scanner = new Scanner(System.in);
		@SuppressWarnings("unused")
		String name = "ewas";
		
		Date d = new Date();
		
	} // main

	@Override
	 public String toString() {
		return "Ex04 []";
	}

}
