package days11;

import java.util.Arrays;
import java.util.Random;

public class Ex04 {

	public static void main(String[] args) {

		// 문제) int[] m = new int[30];에 0~9 임의의 정수
		// 0 - 3개
		// 1 - 0개
		// .... 9 - 0개
		int[] m = new Random().ints(30, 0, 10).toArray();
		System.out.println(Arrays.toString(m));
		
		int[] count = new int[10];
		
		for (int i = 0; i < m.length; i++) {
			int num = m[i];
			count[num]++;
		}
		for (int i = 0; i < count.length; i++) {
			System.out.printf("%d의 개수: %d\n", i, count[i]);
		}

	} // main

}
