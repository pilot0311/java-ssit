package days21;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Ex10 {

	public static void main(String[] args) {
		//	개강일 + 100 일
		//	수료일 - 오늘 날짜: ~차
		
		//날짜와 날짜 사이의 간격(차) : Period
		//시간과 시간 사이의 간격(차) : Duration
		
		//	between() == until()
		//static메서드			인스턴스메서드
		
		//of(), with() 변경
		//plus(), minus() 등등 메서드
		
		//개강일
		LocalDate s = LocalDate.of(2023, 7, 13);
		//오늘 날짜
		LocalDate t = LocalDate.now();
		t = t.plusDays(1);
		System.out.println(t);
		//개강일과 오늘 날짜 사이의 간격
		//	날짜 차							s<=t
		Period p = Period.between(s, t);
		int year =p.getYears();
		System.out.println(year);
		long month = p.get(ChronoUnit.MONTHS);
		System.out.println("m:"+month);
		long day = p.getDays();
		System.out.println(day);
		
		//시간 차 Duration
		LocalTime st = LocalTime.of(9, 0, 0);
		LocalTime tt = LocalTime.now();
		Duration d = Duration.between(st, tt);
		//시간차
		long ss = d.getSeconds();
		System.out.println(ss);	//초
		System.out.println(ss/60);	//분
		System.out.println(ss/(60*60));	//시간
		//UnsupportedTemporalTypeException 지원하지 않음
		//long h = d.get(ChronoUnit.HOURS);
		//System.out.println(h);
		
	} // main
	
}
