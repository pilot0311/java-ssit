package days21;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class Ex06 {

	public static void main(String[] args) {
		
		LocalTime t = LocalTime.now();
		//getXXX(), get(Chrono.필드)
		System.out.println(t.getHour());
		System.out.println(t.getMinute());
		System.out.println(t.getSecond());
		System.out.println(t.getNano());
		//밀리 세컨드
		System.out.println(t.get(ChronoField.MILLI_OF_SECOND));
		
		//30분후 점심
		//t = t.plusMinutes(30);
		//t = t.minusMinutes(10);
		t = t.plusMinutes(90);
		System.out.println(t);
		
	} // main
	
}
