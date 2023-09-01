package days22;

import java.time.LocalDateTime;

public class Ex04 {

	public static void main(String[] args) {
		LocalDateTime sdt = LocalDateTime.of(2023, 8, 10, 9, 00, 00);
		LocalDateTime edt = LocalDateTime.of(2023, 8, 15, 18, 00, 00);
		LocalDateTime now = LocalDateTime.now();
		/*
		now.isAfter(a);			now가 a 이후이면 true
		now.isBefore(a);		now가 a 이전이면 true
		now.isEqual(a);			now와 a가 같으면 true
		now.compareTo(a);	
		 */
		
		if (edt.isAfter(now) && sdt.isBefore(now)) {
			System.out.println("가능");
		} else
			System.out.println("불가능");
	} // main

}

//) 설문 시작일 : 23.8.10   9:00:00
//2) 설문 종료일 : 23.8.15  18:00:00