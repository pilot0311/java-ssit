package days21;

import java.text.MessageFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex05test {

	public static void main(String[] args) {
		
		//[5]
//		LocalDate ld = LocalDate.of(2023, 7, 13);
//		//ld = ld.plusDays(100);
//		ld = ld.plus(100, ChronoUnit.DAYS);
//		System.out.println("LocalDate: " + ld);
//		
//		Date d = new Date(2023-1900, 7-1, 13);
//		int m = d.getDate()+100;
//		d.setDate(m);
//		System.out.println("Date: " + d.toLocaleString());
//		
//		Calendar c = new GregorianCalendar(2023, 7-1, 13);
//		c.add(Calendar.DAY_OF_MONTH, 100);
//		System.out.println("Calendar: " + c.getTime());
		
		
		//[6]
//		Date d = new Date(2023-1900, 12-1, 27);
//		Date t = new Date();
//		long diff = d.getTime() - t.getTime();
//		long n = diff/(1000 * 60 * 60 * 24);
//		
//		int[] time = { 1000 * 60 * 60 * 24, 1000 * 60 * 60, 1000 * 60, 1000, 1 };
//		String[] timea = { "일", "시간", "분", "초", "밀초" };
//		for (int i = 0; i < time.length; i++) {
//			System.out.printf(" %d%s ", (diff / time[i]), timea[i]);
//			diff %= time[i];
//		}
	
		
		String source = "번호:1,이름:홍길동,주소:서울 양천구 목동";
		String pattern = "번호:{0},이름:{1},주소:{2}";
		MessageFormat mf = new MessageFormat(pattern);
		try {
			Object[]objs = mf.parse(source);
			for (Object obj : objs) {
				System.out.println(obj);
			} //foreach
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	} // main
}
