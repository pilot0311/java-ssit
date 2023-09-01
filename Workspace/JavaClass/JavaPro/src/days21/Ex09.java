package days21;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.TemporalAdjusters.*;


import static java.time.DayOfWeek.*;

public class Ex09 {

	public static void main(String[] args) {
		// TemporalAdjusters 클래스
		// - 날짜, 시간 + 수정 : withXXX(), with(), plusXXX(),plus(),minusXXX(),minus()
		//	- 자주 사용되는 날짜, 시간 변경하는 메서드들을 미리 구현해 놓은 클래스
		//	예)	다음 년도의 첫 날
		//			다음 달의 첫 날
		//			올 해의 첫 날
		//			이번 달의 첫 날
		//			올 해의 마지막 날
		//			이번 달의 마지막 날	: lastDayOfMonth()
		//			다음 ?요일
		//			지난 ?요일
		//			이번 달 n번째 ?요일
		//			등등
		LocalDate d =LocalDate.now();
		System.out.println(d);
		//다음달의 첫날
		System.out.println(d.with(firstDayOfNextMonth()));
		// 이번달의 첫날
		System.out.println(d.with(firstDayOfMonth()));
		//이번 달의 첫 번째 월요일
		System.out.println(d.with(TemporalAdjusters.firstInMonth(MONDAY)));
		//지난주 화요일
		System.out.println(d.with(TemporalAdjusters.previous(TUESDAY)));
		//OrSame : 오늘 포함
		System.out.println(d.with(TemporalAdjusters.previousOrSame(TUESDAY)));
		//다음주 금요일 휴강...
		System.out.println(d.with(TemporalAdjusters.next(FRIDAY)));
		//OrSame : 오늘 포함
		System.out.println(d.with(TemporalAdjusters.nextOrSame(FRIDAY)));
		//이번달의 4번째 화요일
		System.out.println(d.with(dayOfWeekInMonth(4,TUESDAY )));
		//3일 뒤에 만나자
		//d = d.plusDays(3);
		d = d.with(new DayAfter3일());
		System.out.println(d);
		
	} // main

}//class

class DayAfter3일 implements TemporalAdjuster{

	@Override
	public Temporal adjustInto(Temporal temporal) {
		
		return temporal.plus(3,ChronoUnit.DAYS);
	}
	
}
