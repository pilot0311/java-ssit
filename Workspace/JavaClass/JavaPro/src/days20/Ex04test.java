package days20;

import java.util.Date;

public class Ex04test {

	public static void main(String[] args) {
		Date startDay = new Date(2023-1900,8-1,2);
		Date endDay = new Date(2023-1900,8-1,15,18,0);
		Date today = new Date();
		System.out.println(startDay.before(today)&&endDay.after(today)?"설문 조사 가능":"설문 조사 불가능");
	
	} // main
}
