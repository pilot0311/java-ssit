package days08;

import java.util.Calendar;

public class Ex05 {

	public static void main(String[] args) {
		// 년도 입력받아서 윤년/평년 체크하는 코딩
		// 년도를 매개변수로 받아서 윤녕/평년 boolean 반환 하는 함수 선언
//		int year = 2100;
//		if (isLeapYear(year)) {
//			System.out.println("윤년(leap year)");
//		} else {
//			System.out.println("평년(common year)");
//		} // else

		// 2000~올해까지 윤년/평년 체크
		Calendar c = Calendar.getInstance();
		int thisYear = c.get(Calendar.YEAR);
//		System.out.println(c.get(1));
//		System.out.println(Calendar.YEAR); //1
		for (int i = 2000; i <= thisYear; i++) {
			System.out.printf("%d(%s)\n", i, isLeapYear(i) ? "윤년" : "평년");

		} // for

	} // main

	// 윤년 true, 평년 false 반환

	public static boolean isLeapYear(int year) {
		// 그레고리력 : 1년 = 365.2425
//		1.서력 기원 연수가 4로 나누어 떨어지는 해는 윤년으로 한다. (1988년, 1992년, 1996년, 2004년, 2008년, 2012년, 2016년, 2020년, 2024년, 2028년, 2032년, 2036년, 2040년, 2044년 ...)
//		2.서력 기원 연수가 4, 100으로 나누어 떨어지는 해는 평년으로 한다. (1700년, 1800년, 1900년, 2100년, 2200년, 2300년...)
//		3.서력 기원 연수가 4, 100, 400으로 나누어 떨어지는 해는 윤년으로 둔다. (1600년, 2000년, 2400년...)
//			400년마다 97번의 윤년
		// 4년마다 윤년 = 100번
		// 100년마다 평년 =4번 96번
		// 400년 평년 1번 97번

		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}
}// class
