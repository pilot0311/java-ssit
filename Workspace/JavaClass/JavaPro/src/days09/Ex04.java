package days09;

import java.util.Iterator;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
//		int year, month;
//		try (Scanner sc = new Scanner(System.in)) {
//			System.out.print(">년도 월 입력 ? ");
//			year = sc.nextInt();
//			month = sc.nextInt();
//			printCalendar(year, month);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		for (int y = 2020; y <=2023; y++) {
			for (int i = 1; i <=12; i++) {
				printCalendar(y, i);
			} // for
		} // for
		

	} // main

	private static void printCalendar(int year, int month) {
		
		// 년 월 1일 요일
		int dayOfWeek = getDayOfWeek(year, month, 1); // 요일 일0 월1 화2 수3 목4 금5 토6
		// 년,월 마지막 일자
		int lastDay = getLastDay(year, month);
		System.out.printf("\t\t\t[%d년 %d월]\n", year, month);
		System.out.println("-".repeat(55));
		String week = "일월화수목금토";
		for (int i = 0; i < week.length(); i++) {
			System.out.printf("\t%c", week.charAt(i));
		} // for
		System.out.println();
		System.out.println("-".repeat(55));
		//날짜 출력
		//1일 날짜 앞의 공백 찍는 for문
		for (int i = 0; i <dayOfWeek; i++) {
			System.out.print("\t");
		} // for
		for (int i = 1; i <=lastDay; i++) {
			System.out.printf("\t%d", i);
			if((i+dayOfWeek) % 7 ==0) System.out.println();			
		} // for
		System.out.println();
		System.out.println("-".repeat(55));
	}

	private static int getDayOfWeek(int year, int month, int day) {
		// 1.1.1 ~ year.month.day 총 날짜 수
		int totalDays = getTotalDays(year, month, day);
		int dayOfWeek = totalDays % 7;
//		System.out.println("일월화수목금토".charAt(dayOfWeek));
		return dayOfWeek;
	}

	private static int getTotalDays(int year, int month, int day) {
		// int year=2023, int month=7, int day=1
		int totalDays = 0;
//		for (int i = 1; i < year; i++) {
//			totalDays += days08.Ex05.isLeapYear(i) ? 366 : 365;
//		} // for
		totalDays=(year-1)*365+(year-1)/4 - (year-1)/100 + (year-1)/400;
			// 2023 1+2+3+4+5+6 +1
		
		for (int i = 1; i < month ; i++) {
				totalDays += getLastDay(year,	i);
		} // for
		totalDays++;
		return totalDays;
	}

	private static int getLastDay(int year, int month) {
		int lastDay = 0;
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		lastDay = months[month - 1];
		if (month == 2 && days08.Ex05.isLeapYear(year))
			lastDay++;
		return lastDay;
	}

//	[1]
//	private static int getLastDay(int year, int month) {
	// 31일: 1,3,5,7,8,10,12
	// 30일: 4,6,9,11
	// 28일 or 29일 2
//		int lastDay=0;
//		switch (month) {
//		case 2:
//			lastDay=(days08.Ex05.isLeapYear(year))?29:28;
//			break;
//		case 4:
//		case 6:
//		case 9:
//		case 11:
//			lastDay = 30;
//			break;
//		case 1:
//		case 3:
//		case 5:
//		case 7:
//		case 8:
//		case 10:
//		case 12:
//			lastDay =31;
//			break;
//		default:
//			break;
//		} // switch
//		return 0;
//	}
}
