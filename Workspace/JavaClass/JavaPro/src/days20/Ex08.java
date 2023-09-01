package days20;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author pilot
 * @date 2023. 8. 9. - 오후 2:32:52
 * @subject		형식화 클래스
 * 					DecimalFormat
 * 						format()	숫자 -> 원하는 형식의 문자열
 * 						parse()		문자열 -> 숫자
 * 				SimpleDateFormat
 * 					format()	 날짜 -> 원하는 형식의 문자열
 * 					parse()	 	문지열->	날짜
 */			
public class Ex08 {

	public static void main(String[] args) throws ParseException {
		String strDate = "23년 8월 9일 \"수요일\"";		// -> 날짜로 변환
		String pattern = "yy년 MM월 d일 \"E\"";
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 d일 \"E\"");
		Date d = sdf.parse(strDate);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		System.out.println(d.toLocaleString());
		System.out.println(Ex05.getPatterDate(c, pattern));
	} // main
	
}
