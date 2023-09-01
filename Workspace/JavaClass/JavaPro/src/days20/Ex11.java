package days20;
//시험[java.time]설명	+ SimpleDateFormat, ChoiceFormat, MessageFormat
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class Ex11 {

	public static void main(String[] args) {
		//Date (Jdk1.0)
		//Calendar (Jdk1.1)
		
		//Jdk1.8에 새로 추가된 날짜, 시간 클래스 (java.time패키지)
		//	1.java.time 날짜, 시간 다루는 핵심 클래스 제공	(j.t=java.time)
		//		ㄴ	j.t.chrono: 표준(ISO)이 아닌 달력 시스템을 위한 클래스 제공
		//		ㄴ	j.t.format: 형식화(파싱) 클래스 제공
		//		ㄴ	j.t.temporal(시간의): 날짜, 시간의 필드(field)와 단위(unit) 클래스 제공
		//		ㄴ	j.t.zone: 시간대(time-zone) 클래스 제공
		
		//	2.	java.time 날짜, 시간 다루는 핵심 클래스 제공
		//		1)	날짜 : LocalDate 클래스
		//		2)	시간 : LocalTime 클래스
		//		3)	날짜 + 시간: LocalDateTime 클래스
		//		4)	날짜 + 시간 + 시간대 : zonedDateTime 클래스
		//			->Temporal, TemporalAdjuster 인터페이스 구현
		
		//	3.	위의 핵심 클래스들은 new 연산자로 객체 생성 x -> now(), of() 메서드 예제) Ex11_02
		
		//	4. 날짜와 날짜 사이의 간격 : Period
		//		시간과 시간 사이의 간격 : Duration
		//		->	TemporalAmount 인터페이스 구현
		
		//	5.	날자와 시간의 [단위(Unit)]를 정의해 놓은 것이
		//		ㄴ Temporal[Unit] 인터페이스
		//			ㄴ	Chrono[Unit] 클래스 가 구현
		
		//	6.	년, 월, 일 등의 날짜와 시간의 [필드(field)]를 정의해 놓은 것
		//			ㄴ	Temporal[Field] 인터페이스
		//				ㄴ Chrono[Field] 클래스 에서 구현
		//	예) Ex12
		
		//	7.	특정 필드(년, 월, 일, 시간, 분...등) 가져오기
		//		  	ㄴ getXXX()
		//			ㄴ	get(필드)
		
		//	8.	특정 필드 수정	:	with(), plus(), minus()
		//		1)	Date d.setYear()년도 수정
		//		2)	Calendar c.set(Calendar.Year, 수정); 			roll(), add();
		//	
	} // main
}
