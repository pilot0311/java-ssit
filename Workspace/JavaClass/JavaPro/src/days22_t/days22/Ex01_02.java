package days22_t.days22;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex01_02 {

	public static void main(String[] args) {
		// [2-2]
		String s = "2023.08.11 (금)";
		String pattern = "yyyy.MM.dd (E)";
		DateTimeFormatter dtf =  DateTimeFormatter.ofPattern(pattern);
		LocalDate d = LocalDate.parse(s, dtf);
		System.out.println( d );
		
		/*
		String s = "2023-08-11";
		LocalDate d = LocalDate.parse(s);
		System.out.println( d );
		*/
	} // main
	
}
