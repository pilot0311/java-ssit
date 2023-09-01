package days07;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex07_03 {

	public static void main(String[] args) {
		// [문제] 피보나치 수열
		// 항이 100 같거나 작을때까지의 수열을 출력 하고 합
		// 1+1+2+3+5+8+13+21.....+

//		int sum = 0; // 총합
//		int prev1 = 0;// n-2번쨰 항
//		int prev2 = 1;// n-1번째 항
//		int result = 0; // 이전항들의 합//현재 항
//
//		System.out.printf("%d+", prev2);
//
//		while ((prev1 + prev2) <= 100) {
//			result = prev1 + prev2;
//			System.out.printf("%d+", result);
//			prev1 = prev2;
//			prev2 = result;
//
//			sum += result;
//		} // while
//		System.out.printf("=%d", sum);

		// [1]
//		int[] f=new int[1000];
//		f[1]=f[0]=1;
//		int index=2;
//		int term=0;
//		while (true) {
//			term = f[index-1]+f[index-2];
//			if(term>100)break;
//			f[index]=term;
//			index++;
//		}
//		int sum=IntStream.of(f).sum();
//		System.out.println(sum);

		// [2-a]
		// 첫째항 1
		// 두번째항 2
		int firstTerm = 1;
		int secondTerm = 1;
		int nextTerm;
		int sum = firstTerm + secondTerm;
		System.out.printf("%d+%d+", firstTerm, secondTerm);
//		while (true) {
//			nextTerm=firstTerm+secondTerm;
//			if(nextTerm>100)break;
//			System.out.printf("%d+",nextTerm);
//			sum+=nextTerm;
//			firstTerm=secondTerm;
//			secondTerm=nextTerm;
//		}
		// [2-b]
		while ((nextTerm = firstTerm + secondTerm) <= 100) {
			System.out.printf("%d+", nextTerm);
			sum += nextTerm;
			firstTerm = secondTerm;
			secondTerm = nextTerm;
		}
		System.out.printf("=%d", sum);
		
	} // main
}
