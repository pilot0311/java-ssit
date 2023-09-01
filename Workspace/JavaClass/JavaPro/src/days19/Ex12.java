package days19;

import java.util.Date;

public class Ex12 {

	public static void main(String[] args) {
		
		//[달력]
		//	년, 월,	1일	무슨요일?
		int year = 2010;
		int month = 5;
		int date = 1;
//		Date d = new Date();
//		d.setYear(year-1900);
//		d.setMonth(month-1);
//		d.setDate(date);
//		System.out.println("일월화수목금토".charAt(d.getDay()));
		
		Date d = new Date(year-1900, month-1, date);
		System.out.println(d.toLocaleString());
		System.out.println("일월화수목금토".charAt(d.getDay()));

		//2010년 5월 마지막 날짜?
		d.setMonth(month);
		System.out.println(d.toLocaleString());
		//2010. 6. 1. 오전 12:00:00 - 하루
		date = d.getDate() -1;
		d.setDate(date);
		System.out.println(d.toLocaleString());
		System.out.println(d.getDate());
	} // main
	
}
