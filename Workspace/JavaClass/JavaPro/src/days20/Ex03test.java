package days20;

import java.util.Date;

public class Ex03test {

	public static void main(String[] args) {
		Date d = new Date(2023 - 1900, 7 - 1, 13, 9, 0);
		Date today = new Date();

//		long diff = today.getTime() - d.getTime();
//		long day = diff/(1000*60*60*24);  //(초*분*시간*하루)
//		System.out.println(day+"일 지났음");

		dispDiffDays(d, today);

	} // main

	public static void dispDiffDays(Date d, Date today) {
		long diff = today.getTime() - d.getTime();
		int[] time = { 1000 * 60 * 60 * 24, 1000 * 60 * 60, 1000 * 60, 1000, 1 };
		String[] timea = { "일", "시간", "분", "초", "ms" };
		for (int i = 0; i < time.length; i++) {
			System.out.printf(" %d%s", (diff / time[i]), timea[i]);
			diff %= time[i];
		}
//		System.out.println(" 지났음");
//		try {
//			Thread.sleep(1000); //1s
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} 
//		dispDiffDays(d, new Date());
	}
}
