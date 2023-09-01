package days09;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex03_02 {

	public static void main(String[] args) {
		// 주민등록번호
		// 생년월일, 성별(내국인/외국인), 검증
		String rrn = "980323-1700001";
		int age = 0;

		// 주민등록 번호 -> 나이
		// 만 나이 = 0살 (태어 났을떄 0살 시작 + 내가 태어나고 1년 지나야 +1살)
		age = getAmericanAge(rrn);
		System.out.printf("만 나이: %d\n", age);
		// 세는나이 = 1살 (태어나자마자 1살 시작 + 새해마다 +1살)
		age = getCountAge(rrn);
		System.out.printf("세는 나이: %d\n", age);
	} // main

	public static int getCountAge(String rrn) {
		// 올해 2023 생일년도1999
		// 올해 연도 - 생일년도 +1
		// [1]
		int age = Integer.parseInt(getBirth(rrn).substring(0, 4));

		Calendar c = Calendar.getInstance();
		int thisYear = c.get(Calendar.YEAR);
		age = thisYear - age + 1;
		// [2]
//	Date d = new Date();
//	int countingage = d.getYear()+1900;
//	int birthYear=Integer.parseInt(getBirth(rrn).substring(0, 4));

		return age;
	}

	private static int getAmericanAge(String rrn) {
		// 생일이 오늘 날짜 기준으로 지남 여부 체크
		// 생일 지나지 않았다면 -1
		// 만 나이 = 옿해년도 - 생일년도 -1(o,x)
		// 생일 체크	
		//[1]
//		Calendar c = Calendar.getInstance();
//		int thisMonth = c.get(Calendar.MONTH);
//		int thisDay = c.get(Calendar.DATE);
//		int thisMMdd = thisMonth*100+thisDay;
//		int birthMMdd=Integer.parseInt(getBirth(rrn).substring(4).replace(".",""));
//		boolean flag = (thisMMdd - birthMMdd) >= 0;
//		int americanAge = getCountAge(rrn) - 1 +(flag?0:-1);
//		return americanAge;
		//[3]
		Date d = new Date();
		SimpleDateFormat md = new SimpleDateFormat("MMdd");
		int today = Integer.parseInt(md.format(d));
		int birth = Integer.parseInt(rrn.substring(2, 6));
		int americanAge = getCountAge(rrn) - 1;
		if (today >= birth)
			return americanAge;
		else
			return americanAge - 1;
		
		//[3]d.getMonth()+1 사용하기
		//[4] 날짜와 날짜 비교
		

	}

	// 성별
	public static int getGender(String rrn) {
		return Integer.parseInt(rrn.substring(7, 8));
	}

	// yyyy-MM-dd
	public static String getBirth(String rrn) {
		int year = Integer.parseInt(rrn.substring(0, 2)); // int형
		int month = Integer.parseInt(rrn.substring(2, 4));
		int day = Integer.parseInt(rrn.substring(4, 6));
		// System.out.printf("%s년 %s월 %s일\n",year,month,day);
		int g = getGender(rrn);
		int centry = 1800;
		switch (g) {
		case 1:
		case 2:
		case 5:
		case 6:
			centry = 1900; // int형
			break;
		case 3:
		case 4:
		case 7:
		case 8:
			centry = 2000;
			break;
		case 9:
		case 0:
			centry = 1800;
			break;

		default:
			break;
		} // switch
		year = centry + year;
		String birthday = String.format("%d.%s.%s\n", year, month, day);
		return birthday;
	}// getBirth
}
