package days10;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex01_02 {

	public static void main(String[] args) {
		int n = 125; // 0x7D 10->A
		int share, reminder;
		// 012345679ABCDEF
		char[] ch = { '0','1','2','3','4','5','6','7','8','9','A', 'B', 'C', 'D', 'E', 'F' };
		String s = "";
		
		while (n != 0) {
			share = n / 16;
			reminder = n % 16;
			s = ch[reminder]+s;
			n = share;
		}
		System.out.printf("0x%s", s);

	}// main

	private static int getAmericanAge(String rrn) {
		Date d = new Date();
		SimpleDateFormat md = new SimpleDateFormat("MMdd");
		int today = Integer.parseInt(md.format(d));
		int birth = Integer.parseInt(rrn.substring(2, 6));
		int americanAge = days09.Ex03_02.getCountAge(rrn) - 1;
		if (today >= birth)
			return americanAge;
		else
			return americanAge - 1;

	}

	private static boolean isRRNCheck(String rrn) {
		boolean ch = true;
		int[] ck = { 2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5 };
		int total = 0;

		int lastN = rrn.charAt(rrn.length() - 1) - '0';
		for (int i = 0; i <= 12; i++) {
			total += (rrn.charAt(i) - '0') * ck[i];
		} // for
		int check = 11 - total % 11;

		return lastN == check ? true : false;
	}

}
