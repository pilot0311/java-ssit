package days20;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Ex13 {

	public static void main(String[] args) {
		//LocalDate 불변객체
		LocalDate d = LocalDate.now();
		System.out.println(d);	//2023-08-09
		//withXXX()
		//불변 객체 이기에 새 객체 만듬
		d = d.withYear(2020);
		d = d.withMonth(5);
		d = d.withDayOfMonth(11);
		System.out.println(d);	
		
		//with()
		d = d.with(ChronoField.YEAR, 2010);
		System.out.println(d);
	} // main
	
}
