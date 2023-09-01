package days07;

public class Ex06 {

	public static void main(String[] args) {
		// 1-2+3-4+5-6+7-8+9-10=-5

		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum+=i%2==0?-i:i;
			System.out.printf(i%2==0?"%d+":"%d-", i);
//			if (i % 2 == 0) {
//				System.out.printf("%d+", i);
//				sum -= i;
//			} else {
//				System.out.printf("%d-", i);
//				sum += i;
//			}

		} // for
		System.out.printf("=%d", sum);
	} // main
}
