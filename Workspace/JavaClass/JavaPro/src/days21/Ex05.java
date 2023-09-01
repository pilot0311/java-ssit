package days21;

import java.time.LocalDate;

public class Ex05 {

	public static void main(String[] args) {
		//plusXXX(), plus(), minusXXX, minus();
		//날짜와 시간 비교 : isAfter(), isBefore(), isEqual()
		
		//오늘이 생일인가
		//1999.8.10
		//2023.8.10
		LocalDate today = LocalDate.now();
		LocalDate birth = LocalDate.of(1999, 8, 1);
		birth = birth.withYear(today.getYear());
		System.out.println(today.isBefore(birth));	//생일 안지남
		System.out.println(today.isEqual(birth));	// 새일
		System.out.println(today.isAfter(birth));	//생일 지남		
		System.out.println(today.compareTo(birth)); // 양수 [0] 음수	//9 생일이 지남
	} // main
	
}
