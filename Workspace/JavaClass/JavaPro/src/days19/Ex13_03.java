package days19;

import java.util.Date;

/**
 * @author kenik
 * @date 2023. 8. 8. - 오후 5:12:31
 * @subject
 * @content
 */
public class Ex13_03 {

	public static void main(String[] args) {

		Date today = new Date();
		today.setHours(0);
		today.setMinutes(0);
		today.setSeconds(0);

		// 2023. 8. 8. 오후 5:25:58
		System.out.println(today.toLocaleString());

		System.out.println(today.getTime());

		Date d = new Date(2023 - 1900, 8 - 1, 8);
		System.out.println(d.toLocaleString());

		System.out.println(today.equals(d));
		System.out.println(d.getTime());

		// "2023. 8. 8.".equals( "2023. 8. 8." )
		// "2023. 8. 8.".compareTo( "2023. 8. 8." ) == 0

	} // main

} // class
