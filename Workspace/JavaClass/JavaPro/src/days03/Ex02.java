package days03;

import java.util.Calendar;

public class Ex02 {
	public static void main(String[] args) {
		
		// java.util.IllegalFormatConversionException: d != java.lang.String  
//		System.out.printf("%d\n","ghdrl");
		
		
		Calendar c = Calendar.getInstance();
		String s = String.format("%1$tm %1$te,%1$tY\n", c);
//		System.out.printf("%1$tm %1$te,%1$tY, %1$tH %1$tM\n", c);
		System.out.println(s);
//		  %[argument_index$][flags][width][.precision]conversion
		//% 								#		10							d
		System.out.printf("%(d\n",-123);
		System.out.printf("%,d\n",123123123); //기억
	}
}
