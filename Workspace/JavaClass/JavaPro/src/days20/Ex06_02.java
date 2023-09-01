package days20;
//add()	set()	roll()
import java.util.Calendar;
import java.util.GregorianCalendar;
//[시험] 달력 그리기 Calendar사용 해서 add 사용해서
public class Ex06_02 {

	public static void main(String[] args) {
		// 2023. 8
		Calendar c = new GregorianCalendar(2023,8-1,1);
		//.set() 그 날짜로 세팅 하겠다
		//c.set(Calendar.DATE, 0);		//	7/31 
		//c.set(Calendar.DATE, -1);	 	//	3/30
		//c.set(Calendar.DATE, 10);		//	8/10
		//c.set(Calendar.DATE, 32);		//	9/1
		
		//.add()	c의 날짜를 증/감 
		//c.add(Calendar.DATE, -1);		// 7/31
		//c.add(Calendar.DATE, 1);		//	8/2
		
		//.roo() c의 날짜를 증/감 하지만 다른 필드(년,월)에는 영향 없음
		//c.roll(Calendar.DATE, -2);		//	8/30
		System.out.println(Ex05.getPatterDate(c, "yyyy-MM-dd"));
		
	} // main
	
}
