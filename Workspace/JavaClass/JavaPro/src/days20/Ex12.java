package days20;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

// 시험[java.time]설명
public class Ex12 {

	public static void main(String[] args) {
		
		LocalDate d = LocalDate.now();	//2023-08-09
		LocalTime t = LocalTime.now();
		//LocalDate d = LocalDate.of(2023, 8, 9);
		//LocalDate d = LocalDate.ofYearDay(2023, 365);
		System.out.println(d);	//2023-08-09
		//년
		int year = d.getYear();	//메서드로 년도 가져오기
		year = d.get(ChronoField.YEAR);	//필드로 가져오기
		System.out.println(year);
		//월
		//Type mismatch: cannot convert from Month to int
		Month emonth = d.getMonth();		//영어로 AUGUST month형 반환
		System.out.println(emonth);		//AUGUST
		int month = d.getMonthValue();	//1~12월 int형 반환
		System.out.println(month);	//8
		month = d.get(ChronoField.MONTH_OF_YEAR);
		System.out.println(month);	//8
		//일
		int day = d.getDayOfMonth();
		System.out.println(day);	//9
		day = d.get(ChronoField.DAY_OF_MONTH);
		System.out.println(day);
		//시간
		int time = t.getHour();
		System.out.println(time);	//16
		time = t.get(ChronoField.HOUR_OF_DAY);
		System.out.println(time);	//16
		//분
		int minute = t.getMinute();
		System.out.println(minute);//33
		minute = t.get(ChronoField.MINUTE_OF_HOUR);
		System.out.println(minute);	//33
		//초
		int sec = t.getSecond();
		System.out.println(sec);	//37
		sec = t.get(ChronoField.SECOND_OF_MINUTE);
		System.out.println(sec);	//37
		//ms
		long ms = t.get(ChronoField.MILLI_OF_SECOND);
		System.out.println(ms);
		//요일
		DayOfWeek date = d.getDayOfWeek();	//WEDNESDAY
		System.out.println(date);
		int dat = d.get(ChronoField.DAY_OF_WEEK);	//3			Monday (1) to Sunday (7)
		System.out.println(dat);
	} // main
	
}
