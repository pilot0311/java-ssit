package days21;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ex07 {

	public static void main(String[] args) {
		//LocalDate + LocalTime = LocalDateTime
		
//		LocalDateTime dt = LocalDateTime.now();
//		//2023-08-10T11:19:44.265693100
//		System.out.println(dt);
//		//truncated 절삭(내림)
//		dt = dt.truncatedTo(ChronoUnit.DAYS);		//Days 밑으로 절삭
//		System.out.println(dt);
		
//		LocalDate d = LocalDate.now();
//		LocalTime t = LocalTime.now();
//		
//		LocalDateTime dt = LocalDateTime.of(d, t);
//		
//		LocalDateTime dt2 = d.atTime(t);
//		LocalDateTime dt3 = t.atDate(d);
		
		LocalDateTime dt = LocalDateTime.now();
		
		//LocalDateTime -> LocalDate 변환
		LocalDate d = dt.toLocalDate();
		//LocalDateTime -> LocalTime 변환
		LocalTime t = dt.toLocalTime();
		
	} // main
	
}
