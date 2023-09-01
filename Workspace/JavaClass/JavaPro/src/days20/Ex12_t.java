package days20;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

//시험[java.time]설명
public class Ex12_t {

   public static void main(String[] args) {
      
      LocalDate d = LocalDate.now();
      // LocalDate d = LocalDate.of(2023,8,9);
      // LocalDate d = LocalDate.ofYearDay(2023, 365);
      System.out.println( d ); // 2023-08-09
      
      // 년
      int year = d.getYear();
      System.out.println( year ); // 2023
      
      year = d.get( ChronoField.YEAR );
      System.out.println( year ); // 2023
      
      // 월
      // Type mismatch: cannot convert from Month to int
      Month eMonth =  d.getMonth();
      System.out.println( eMonth ); // AUGUST
      
      int month = d.getMonthValue();
      System.out.println( month ); // 8
      
      month = d.get( ChronoField.MONTH_OF_YEAR );
      System.out.println( month ); // 8
      
      // 일
      int day = d.getDayOfMonth();
      System.out.println(  day  );
      day = d.get( ChronoField.DAY_OF_MONTH  );
      System.out.println(  day  );
      
      LocalTime t = LocalTime.now();
      // 시간
      int h = t.getHour();
      System.out.println( h );		//16		오후 4시
      t.get(ChronoField.HOUR_OF_DAY); // (밤12==0)~23
      t.get(ChronoField.CLOCK_HOUR_OF_DAY); // 1~24(밤12==24)
      t.get(ChronoField.HOUR_OF_AMPM); // 0~11
      t.get(ChronoField.CLOCK_HOUR_OF_AMPM); // 1~12
      
      // 분
      int m = t.getMinute();
      System.out.println( m );
      t.get(ChronoField.MINUTE_OF_HOUR);
      
      // 초
      int s =  t.getSecond();
      System.out.println(s );
      t.get(ChronoField.SECOND_OF_MINUTE);
      
      // 밀리세컨드
      int n = t.getNano();
      System.out.println( n );
      int ms = t.get(ChronoField.MILLI_OF_SECOND);
      
      // 요일
      DayOfWeek  dof = d.getDayOfWeek();
      System.out.println(  dof   );  // WEDNESDAY
      // Date      0(일)1(월)2(화)~6(토)
      // Calendar  1(일)2(월)3(화)~7(토)
      // LocalDate 1(월)2(화)~~~~ 6(토)7(일)
      System.out.println(  dof.getValue()   );
      


   } // main

} // class







