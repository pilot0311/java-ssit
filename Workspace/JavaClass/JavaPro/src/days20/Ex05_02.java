package days20;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//날짜, 시간 정보를 사용자가 원하는 형식으로 출력
public class Ex05_02 {

	public static void main(String[] args) {
		//SimpleDateFormat  형식화 클래스
		String pattern = "yyyy. MM. dd. a hh:mm:ss";		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
//		Date today = new Date();
//		System.out.println(sdf.format(today));
		Calendar c = Calendar.getInstance();
		long t = c.getTimeInMillis();
		//[1]
		//Date today = new Date(t);
		//System.out.println(sdf.format(today));
		//[2]
		Date today = c.getTime();
		System.out.println(sdf.format(today));
	} // main
}
