package days04;

public class Ex06_03 {

	public static void main(String[] args) {

		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;

			System.out.printf("%d+", i);
		} // for
		// \b는 백스페이스 효과 하지만 이클립스에선 공백이나 이상한 문자로 나올수 도있음
		//cmd로 확인시 정상 출력
		System.out.printf("\b=%d", sum);

	}// main
}
