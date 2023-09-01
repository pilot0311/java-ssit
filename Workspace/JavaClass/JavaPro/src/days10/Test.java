package days10;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		//32비트 2진수로 출력
//		int n = 10;
//		int[] binary = new int [32];
//		int index = binary.length-1;
//		int share, reminder;
//		while (n!=0) {
//			share = n/2;
//			reminder = n%2;
//			binary[index--] = reminder;
//			n=share;
//		}
//		System.out.println(Arrays.toString(binary).replace(", ", ""));
		
		//생년 월일 나타내기
		String rrn = "980323-1700001";
		String birth = getBirth(rrn);
		System.out.println(birth);
		
		//만 나이 세는 나이
		int age;
		age = getAge(rrn);
		System.out.println(age);
		age = getAmericaAge(rrn);
		System.out.println(age);
		
	} // main
	//만 나이
	private static int getAmericaAge(String rrn) {
		Date d = new Date();
		SimpleDateFormat md = new SimpleDateFormat("MMdd");
		int today = Integer.parseInt(md.format(d));
		int birth = Integer.parseInt(rrn.substring(2, 6));
		int americanAge = getAge(rrn)-1;
		if (today >= birth)
			return americanAge;
		else
			return americanAge - 1;
		
	}

	//세는 나이
	private static int getAge(String rrn) {
		int birthYear = Integer.parseInt(getBirth(rrn).substring(0, 4));
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int age = year - birthYear + 1;
		return age;
	}


	//생년월일
	private static String getBirth(String rrn) {
		int year = Integer.parseInt(rrn.substring(0, 2));
		int month = Integer.parseInt(rrn.substring(2, 4));
		int day = Integer.parseInt(rrn.substring(4, 6));
		int gender = Integer.parseInt(rrn.substring(7, 8));
		int century = 1900;
		switch (gender) {
		case 1:
		case 2:
		case 5:
		case 6:
			century = 1900; // int형
			break;
		case 3:
		case 4:
		case 7:
		case 8:
			century = 2000;
			break;
		case 9:
		case 0:
			century = 1800;
			break;
		default:
			break;
		} // switch
		year += century; 
		String birthDay = String.format("%d.%d.%d", year,month,day);
		return birthDay;
	}
}
