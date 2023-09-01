package days11;

import java.util.Arrays;
import java.util.Random;

public class Ex04_02 {

	public static void main(String[] args) {

		// 문제2) int[] m = new int[30];에 0~9 임의의 정수
		// 0 - 3개
		// 1 - 0개
		// .... 9 - 0개
		int[] m = new int [30];
		int n;
		int [] counts = new int[10];
		//count[0] = 0의 개수
		//count[1] = 1의 개수
		//count[2] = 2의 개수
		//count[3] = 3의 개수
		//count[9] = 9의 개수
		
		for (int i = 0; i < m.length; i++) {
			n = getRandomInt(0, 9);
			m[i]=n;
			counts[n]++;
		} // for
		System.out.println(Arrays.toString(m));
			//System.out.printf("%d의 개수: %d\n", i, counts[i]);
		

	} // main
	
	
	// 3~ 14 사이의 임의의 수
	public static int getRandomInt(int min, int max) {
		return (int)(Math.random()*(max-min+1))+min;
	}

}
