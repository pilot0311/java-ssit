package days22_t.days22;

import java.time.LocalDateTime;

/**
 * @author kenik
 * @date 2023. 8. 11. - 오전 10:46:41
 * @subject
 * @content
 */
public class Ex04 {

	public static void main(String[] args) {
		/*
		java.time.LocalDateTime 클래스 사용
		   1) 설문 시작일 : 23.8.10   9:00:00
		   2) 설문 종료일 : 23.8.15  18:00:00
		   
		   지금 현재 설문 가능여부에 대해서 출력하세요.
		*/
		LocalDateTime surveyStartDate = LocalDateTime.of(2023, 8, 10,   9, 0, 0);
		LocalDateTime surveyEndDate = LocalDateTime.of(2023, 8, 15, 18, 0, 0);
		
		LocalDateTime now = LocalDateTime.now();
		
		/*
		now.isAfter( );
		now.isBefore();
		now.isEqual();
		now.compareTo();
		*/
		
		System.out.println( now.isAfter( surveyEndDate ) );
		
		/* 11:03 수업 시작
		LocalDate a = LocalDateTime.of(2012, 6, 30, 12, 00);
		LocalDate b = LocalDateTime.of(2012, 7, 1, 12, 00);
		   a6.isAfter(b7) == false  결과 분석
		   *** a6.isAfter(a6) == false  결과 분석
		   b7.isAfter(a6) == true   결과 분석
		*/   
		
		if( now.isBefore(surveyStartDate) || now.isAfter(surveyEndDate) ) 
			System.out.println("투표 기간 X");
		else
			System.out.println("투표 기간 O");

	} // main

} // class






