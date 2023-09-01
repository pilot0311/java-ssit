package days08;

public class Ex03 {

	public static void main(String[] args) {
//		[피보나치 수열]
		int firstTerm = 1; // 첫 번째항
		int secondTerm = 1; // 두 번째 항
		int nextTerm;
		int sum = firstTerm + secondTerm;
		System.out.printf("%d+%d+", firstTerm, secondTerm);

		for (int i = 1; i <= 8; i++) {
			nextTerm = firstTerm + secondTerm;
			System.out.printf("%d+", nextTerm);
			sum += nextTerm;
			firstTerm = secondTerm;
			secondTerm = nextTerm;
		} // for

		System.out.printf("=%d", sum);

	} // main
}
