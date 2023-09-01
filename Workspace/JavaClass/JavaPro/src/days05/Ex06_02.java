package days05;

import java.util.Scanner;

public class Ex06_02 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int n, m;
			System.out.print("정수 입력:");
			n = sc.nextInt();
			System.out.print("정수 입력:");
			m = sc.nextInt();
			int sum = 0;
			int min = Math.min(n, m);
			int max = Math.max(n, m);
			
			if (min % 2 == 0)
				min++;
			//while
			while (min<=max) {
				System.out.printf("%d+", min);
				sum+=min;
				min+=2;
			}

//			
			System.out.printf("=%d", sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main
}
