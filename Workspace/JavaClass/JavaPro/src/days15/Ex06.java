package days15;

import java.io.*;
import static java.lang.Math.random;
import static java.lang.System.out;
public class Ex06 {

	public static void main(String[] args) {
//			1.	패키지(package)
//				1)	서로 관련있는 클래스들, 인터페이스들의 묶음
//				2)	클래스를 효율적으로 관리
//				예)java.io패키지  - 서로 관련된 클래스 input/output 입출력
//				3)	클래스의 이름이 충돌하는 것을 막아준다
//					다른 개발자가 구현한 클래스 라이브러리의 클래스와 이름이 충돌되는 것을 피할 수 있다
//				4)	자신만이 사용할 패키지 체계 있어야 한다
//					도메인명
//				5)	클래스 -> 물리적으로 -> ???.class(클래스 파일)
//					패키지 -> 물리적으로 -> 디렉토리생성
//					예) java.lang.System클래스: java폴더 - lang 폴더 - System.class파일
//				6) 선언 형식: 소스파일의 첫 번째 라인(문장) 단 한번 선언
//					package 패키지명.패키지명;
//				7)	패키지명은 소문자로 작명
//		
//			2.	import문
		//		1)	소프파일에서 다른 패키지의 클래스를 사용하려면 패키지명이 포함된 클래스이름을 사용해야 된다
		//		2)	패키지이름 + 클래스이름 = 클래스 이름 풀네임 ex) java.io.클래스명
		//		3)	풀네임 java.lang.System.out.println();
		//		4)	import 문 사용해서 미리 풀네임을 명시 : import java.lang.System;
		//		5) import문 자동완성 : Ctrl + Shift + o
		//		6)	import java.io.BufferedReader;
		//			import java.io.InputStreamReader;
		//			import java.io.*  :  java.io의 모든 클래스 다 사용\
		
		//		7)	static import 문
		//	static Random 함수
		//System.out.println(Math.random());
		//System.out.println(Math.PI);
		out.println(random());		//import static java.lang.Math.random; == 앞에  Math없어도 사용가능
		
	} // main
}
