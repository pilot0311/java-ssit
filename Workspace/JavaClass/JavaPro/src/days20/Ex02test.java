package days20;

import java.util.Date;

public class Ex02test {

	public static void main(String[] args) {
		int year = 2023;
		int month = 8;
		int lastDay = getLastDay(year, month);
		int dayOfWeek = getDayOfWeek(year, month, 1);

		Date StartDay = new Date(year, month - 1, 1);
		StartDay.setDate(StartDay.getDate() - dayOfWeek);
		// Date temp = new Date();
		// Date today = new Date(temp.getYear(), temp.getMonth(), temp.getDate());
		int m;
		for (int i = 1; i <= 42; i++) {
			m = StartDay.getMonth() + 1;
			if (month == m) {
				System.out.printf("%d\t", StartDay.getDate());
			} else {
				System.out.printf("\t");
			}

			if (i % 7 == 0) {
				System.out.println();

			} // if
			StartDay.setDate(StartDay.getDate() + 1);
		} // for

	} // main

	private static int getLastDay(int year, int month) {
		Date d = new Date(year - 1900, month, 1);
		int date = d.getDate() - 1;
		d.setDate(date);
		return d.getDate();
	}

	private static int getDayOfWeek(int year, int month, int date) {
		Date d = new Date(year - 1900, month - 1, date);
		return d.getDay(); // 0(일)~6(토)
	}

	private static boolean isEqualsDate(Date d1, Date d2) {
		int index = 10;
		d1.setHours(0);
		d1.setMinutes(0);
		d1.setSeconds(0);
		d2.setHours(0);
		d2.setMinutes(0);
		d2.setSeconds(0);
		//String s1 = d1.toLocaleString().substring(0, index);
		//String s2 =  d2.toLocaleString().substring(0, index);
		return d1.toLocaleString().equals(d2.toLocaleString());
	}

}
