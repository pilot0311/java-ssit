package days21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex01test {

	public static void main(String[] args) {
		//[1]
//		Calendar c = new GregorianCalendar(2020, 3, 2);
		//Date d = c.getTime();
//		System.out.println(d);
		
//		Date d = new Date();
//		Calendar c = new GregorianCalendar(2020, 3, 2);
//		c.setTime(d);
//		System.out.println(c.getTime());
		
		//[2]
		String source = "2023/08/10 (목) 12:23:01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd (E) hh:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("\"yyyy년 M월 dd (E)\"");
		try {
			Date d = sdf.parse(source);
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			System.out.println(sdf2.format(c.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//"2023년 8월 10일 (목)"
		
	} // main
}
