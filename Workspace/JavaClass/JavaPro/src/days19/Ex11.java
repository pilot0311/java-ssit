package days19;

import java.util.Date;

//	날짜, 시간 클래스	+	형식화(fommating) 클래스
//	[일정관리]
//				남은 자바
// 		 	컬렉션 프레임워크
//			제네릭 + 어노테이션
//			자바 입출력(IO)
//				시간 있으면
//				스레드 + 네트워크
//				람다식 + 스트림
public class Ex11 {


	
	public static void main(String[] args) {
		
		// jdk 1.0		java.util.Date
		// jdk 1.1		java.util.Calendar
		//									ㄴ	GregorianCalendar
		//	jdk 1.8		java.tiom 패키지 안에 여러 하위 패키지와 다양한 클래스 추가
		
		Date d = new Date();
		System.out.println(d);	//Tue Aug 08 15:40:00 KST 2023
		System.out.println(d.toGMTString());	//GMT = 그리니치 표준시 (세계표준시)	8 Aug 2023 06:40:00 GMT
		System.out.println(d.toLocaleString());		//현재 지역에 맞는 표준시	2023. 8. 8. 오후 3:40:00
		//년
		System.out.println(d.getYear()+1900);
		//월
		System.out.println(d.getMonth()+1);
		//일
		System.out.println(d.getDate());
		//시간
		System.out.println(d.getHours());
		//분
		System.out.println(d.getMinutes());
		//초
		System.out.println(d.getSeconds());
		//밀리세컨드	1000ms = 1s
		
		//요일
		System.out.println(d.getDay()); //0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 =Thursday, 5 = Friday, 6 = Saturday
		System.out.println("일월화수목금토".charAt(d.getDay())); //0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 =Thursday, 5 = Friday, 6 = Saturday
		// 1970.1.1 0:0:0 ~ ms long***
		System.out.println(d.getTime());	//1691477469444	
		
	} // main
	
}
