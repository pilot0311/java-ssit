package days04;

public class Ex06 {

	public static void main(String[] args) {

		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum = sum + i;
			
			if (i ==10 ) {
				System.out.printf("%d", i);
			}else
				System.out.printf("%d+", i);
		} // for
		System.out.printf("=%d", sum);

	}// main
}
