package Programmer;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Localdate {

	public static void main(String[] args) {
		int year = 2023;
		int month = 8;
		LocalDate d = LocalDate.of(year, month, 1);
		LocalDate td = LocalDate.now();
		int dat = d.get(ChronoField.DAY_OF_WEEK);
		d = d.minusDays(dat);
		//System.out.println(d);
		for (int i = 1; i <= 42; i++) {
			System.out.printf(d.getMonthValue()==month?td.equals(d)?"[%d]\t":"%d\t":"(%d)\t",d.getDayOfMonth());
			d = d.plusDays(1);
			
			if (i % 7 == 0) {
				System.out.println();
			}
		} // for
		
		
	} // main
}
