package days21;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;

public class Ex08 {

	public static void main(String[] args) {
		//이번 달이 마지막 날짜 몇일 까지
		//	1. Date
		//Date d = new Date();
		//Date d2 = new Date(d.getYear(),d.getMonth()+1,1);
		//d2.setDate( d2.getDate()-1);
		//System.out.println(d2.toLocaleString());
		
		//	2.	Calendar
		//Calendar c = Calendar.getInstance();
		//System.out.println(c.getActualMaximum(Calendar.DATE));
		
		//	3. LocalDate
	//DateTimeFormatter 찾아보자
		//String source = "2009-12-30";
		//String source = "2009.12.30";
		//String source = "2009/12/30";
		//LocalDate ld = LocalDate.parse(source);
		
		//[1]
//		LocalDate today = LocalDate.now();
//		LocalDate firstDay = today.withDayOfMonth(1);
//		System.out.println(firstDay);
//		System.out.println(today.lengthOfMonth());
//		LocalDate lastDay = today.withDayOfMonth(today.lengthOfMonth());
//		System.out.println(lastDay);
		//[2]
		LocalDate today = LocalDate.now();
		LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(lastDay);
		
		//TemporalAdjuster ?
		
		
	} // main

}
