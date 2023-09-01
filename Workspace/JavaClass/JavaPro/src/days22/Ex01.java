package days22;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex01 {

	public static void main(String[] args) {
		
		//[2]
		String pattern = "yyyy/MM/dd E요일   hh:mm:ss.SSS";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime ldt = LocalDateTime.now();
		 String s = dtf.format(ldt);
		System.out.println(s);
		
	
	} // main
}

//2-2. String s = "2023.08.11 (금)" 문자열을 LocalDate 클래스로 변환시키세요.
//현재 날짜와 시간 정보를   LocalDateTime 클래스
//2023/08/11 금요일   07:02:32.259