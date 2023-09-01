package Programmer;

import java.util.Date;

public class dateTest {

	public static void main(String[] args) {
		int year = 2023;
		int month = 8;

		// 오늘 날짜 객체 2023.8.8

		int dayOfWeek = getDayOfWeek(year, month, 1);
		int lastDay = getLastDay(year, month);

		// System.out.println(dayOfWeek +" / " + lastDay);

		Date d = new Date(year - 1900, month - 1, 1); // 2023.8.1
		Date temp = new Date();
		Date today = new Date(temp.getYear(), temp.getMonth(), temp.getDate());
		
		int date = d.getDate() - dayOfWeek;
		d.setDate(date);
		// System.out.println( d.toLocaleString());
		
		for (int i = 0; i <7 ; i++) {
			System.out.printf("%s\t","일월화수목금토".charAt(i));
		} // for
		System.out.println();
		for (int i = 1; i <= 42; i++) {

			// true/false d.after(d2)
			// true/false d.before(d2)
			// true/false d.equals(d2)
			// int d.compareTo(d2)
			// System.out.println( d.toLocaleString());
			int m = d.getMonth() + 1;

			// System.out.printf(m != month?"(%d)\t":today.equals(d)?"[%d]":"%d\t",
			// d.getDate() );
			System.out.printf((m != month) ? "(%d)\t" : (today.equals(d) ? "[%d]\t" : "%d\t"), d.getDate());
			// 년, 월, 일

			if (i % 7 == 0) {
				System.out.println();
			}
			date = d.getDate() + 1;
			d.setDate(date);

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
	} // main
}
