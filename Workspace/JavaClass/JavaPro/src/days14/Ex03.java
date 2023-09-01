package days14;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		
		Random rnd =new Random(10000L);		//long seed -> 필드 초기화
		rnd.toString();
		Math.random();
		Scanner scanner = new Scanner(System.in);
		
		//현재 시스템의 날짜 + 시간
		//2023. 8. 1. 오전 10:48:37
		int year = 2023;
		int month = 10;
		int day = 25;
		Date d = new Date(year-1900, month-1, day);
		System.out.println(d.toString());
		System.out.println(d.toLocaleString());		//Locale = 해당지역
		System.out.println(d.getDay());	//3  수요일
	} // main
}
