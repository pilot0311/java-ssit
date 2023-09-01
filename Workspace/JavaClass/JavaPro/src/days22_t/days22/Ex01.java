package days22_t.days22;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author kenik
 * @date 2023. 8. 11. - 오전 6:56:41
 * @subject
 * @content
 */
public class Ex01 {
	
	public static void main(String[] args) {
		//[2]
		LocalDateTime dt =  LocalDateTime.now();
		// 2023-08-11T10:05:18.953979700
		System.out.println( dt );
		// 2023/08/11 금요일   07:02:32.259
		// 형식화 클래스  Date, Calendar  SimpleDateFormat
		//                                parse(), format()
		String pattern = "yyyy/MM/dd E요일   hh:mm:ss.SSS";
		DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
		String output = df.format(dt); // 매개변수 다형성
		System.out.println( output );
	} // main

} // class








