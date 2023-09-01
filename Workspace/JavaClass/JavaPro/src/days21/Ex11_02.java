package days21;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ex11_02 {

	public static void main(String[] args) {
		//	DateTimeFormat.format()
		//	DateTimeFormat.parse()
		
		//String source = "2023-08-10";
		//DateTimeParseException
		String source = "2023년08월10일 (목)";
		String pattern = "yyyy년MM월dd일 (E)";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		LocalDate d = LocalDate.parse(source, dtf);
		System.out.println(d);
		
		LocalTime t = LocalTime.parse("12:23:43");
		System.out.println(t);
	} // main
}
