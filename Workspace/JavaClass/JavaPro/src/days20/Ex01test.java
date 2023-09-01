package days20;

import java.util.Date;
import java.util.Scanner;

public class Ex01test {

	public static void main(String[] args) {
		
		
		try (Scanner sc = new Scanner(System.in)) {
		int year =sc.nextInt();
		int lastday = 0;
		System.out.println(year+"년");
		
		for (int i = 1; i <=12; i++) {
			lastday= getLastDay(year, i);
			System.out.printf("%d월 : %d일\n",i,lastday);
		} // for
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
	
	private static int getLastDay(int year, int month) {
		Date d = new Date(year - 1900, month, 1);
		int date = d.getDate() - 1;
		d.setDate(date);
		return d.getDate();
	}
	
}
