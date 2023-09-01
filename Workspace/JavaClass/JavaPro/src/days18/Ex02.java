package days18;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] stick = new int[n];
		for (int i = 0; i < n; i++) {
			stick[i]=sc.nextInt();
		} // for
		Arrays.sort(stick);
		int count = n;
		System.out.println(count);
		int index=0;
		for (int i = 0; i < n; i++) {
			if (stick[index] != stick[i]) {
				index=i;
				count = n - index;
				System.out.println(count);
			} //if
		} // for
	} // main
}

/*
6 
5 4 4 2 2 8
 */

//checked Exception excetion을 상속 반드시 예외처리 해야함
//Unchecked Exception RuntimeException 상속 예외처리 안해도 됨
//사용자 지정 예외 