package days20;

import java.time.LocalDate;
import java.time.chrono.ThaiBuddhistChronology;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Ex04 {

	public static void main(String[] args) {
		//jdk 1.1 Calendar  추상클래스 - 날짜, 시간
		//Calendar c = new Calendar(); X
		//Calendar c = new GregorianCalendar();
									//ㄴ BuddistCalendar 태국
		Calendar c = Calendar.getInstance();
		//c.add(int field 날짜, 월, 년도, 시간, 분, 초, 얼마나 증가 시킬건지);
		//c.clear(초기화 할 필드);	//== d.setHours()
		
		
		//년
		System.out.println(c.get(1));	//2023			
		System.out.println(c.get(Calendar.YEAR));	//2023
		//월
		System.out.println(c.get(2)+1);	//7
		System.out.println(c.get(Calendar.MONTH)+1);	//7
		//일
		System.out.println(c.get(Calendar.DATE));	//9
		System.out.println(c.get(Calendar.DAY_OF_MONTH));	//9
		//시간
		System.out.println(c.get(Calendar.HOUR));		//12시기준(0~11)
		System.out.println(c.get(Calendar.HOUR_OF_DAY));	//24기준(0~23)
		//분
		System.out.println(c.get(Calendar.MINUTE));
		//초
		System.out.println(c.get(Calendar.SECOND));
		//ms
		System.out.println(c.get(Calendar.MILLISECOND));
		//요일
		//Date = 0(일)~6(토)		Calendar = 1(일)~7(토)
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		
		//오전(Am) 오후(Pm)
		System.out.println(c.get(Calendar.AM));
		System.out.println(c.get(Calendar.AM_PM));
		// 올해1월1일 에서부터 몇일째인지
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
		
		//해당 월의 몇 번째 주
		System.out.println(c.get(Calendar.WEEK_OF_MONTH));
		//해당 년도의 몇 번째 주
		System.out.println(c.get(Calendar.WEEK_OF_YEAR));
		
//		System.out.println(c.getDisplayName(Calendar.DAY_OF_WEEK	, Calendar.NARROW_FORMAT, Locale.KOREAN));
		
	} // main
	
}
