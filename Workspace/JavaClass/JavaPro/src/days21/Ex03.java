package days21;

import java.util.Date;

import days20.Ex03test;

public class Ex03 {

	public static void main(String[] args) {
		
		//[6]
		Date d = new Date(2023-1900, 12-1, 27);
		Date t = new Date();
		long diff = d.getTime() - t.getTime();
		
		Ex03test.dispDiffDays(t, d);
		
//		int[] time = { 1000 * 60 * 60 * 24, 1000 * 60 * 60, 1000 * 60, 1000, 1 };
//		String[] timea = { "일", "시간", "분", "초", "밀초" };
//		for (int i = 0; i < time.length; i++) {
//			System.out.printf(" %d%s ", (diff / time[i]), timea[i]);
//			diff %= time[i];
//		}
		
	} // main
}
