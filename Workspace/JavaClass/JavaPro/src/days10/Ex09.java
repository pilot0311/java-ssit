package days10;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Ex09 {

	public static void main(String[] args) {
		// [내일]
		// 1. 배열의 1차원,2차원,3차원[다차원 배열]
		// 2. 정렬[SORT]
		// 3. 검색(SEARCH)
		// 4. 활용 예제
		// (클래스 5장 6장 읽기)

		
		// 문제) int[] m = new int[30];에 0~9 임의의 정수
		int[] m = new Random().ints(30, 0, 10).toArray();
		System.out.println(Arrays.toString(m));
		// int[] count = {0,1,2,3,4,5,6,7,8,9};
		int[] count = new int[10];
		Arrays.fill(count, 0);
		for (int i = 0; i < m.length; i++) {
			int num = m[i];
			count[num]++;
		}
		for (int i = 0; i < count.length; i++) {
			System.out.printf("%d의 개수: %d\n", i, count[i]);
		}

		// 0 - 3개
		// 1 - 0개
		// .... 9 - 0개
	} // main
}
