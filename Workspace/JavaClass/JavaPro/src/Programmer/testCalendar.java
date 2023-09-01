package Programmer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class testCalendar {

	public static void main(String[] args) {
		int year = 2023;
		int month = 8;
		
		Calendar c = new GregorianCalendar(year,month-1,1);
		Calendar t = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s =  sdf.format(t.getTime());
		String s2;
		System.out.println(c.getTime());
		System.out.println(t.getTime());
		int n =	c.get(Calendar.DAY_OF_WEEK);
		c.add(Calendar.DAY_OF_MONTH, -n+1);
		//System.out.println(c.getTime());
		
		for (int i = 1; i <= 42; i++) {
			
			s2 =sdf.format(c.getTime());
			//System.out.println(s2);
			System.out.printf(s.equals(s2)?"[%d]\t":"%d\t",c.get(Calendar.DAY_OF_MONTH));
			c.add(Calendar.DAY_OF_MONTH, 1);
			
			if(i%7==0)System.out.println();
		} // for
		
	} // main
	
}
