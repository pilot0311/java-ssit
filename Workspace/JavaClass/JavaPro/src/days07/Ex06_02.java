package days07;

public class Ex06_02 {

	public static void main(String[] args) {
		// 1-2+3-4+5-6+7-8+9-10=-5
		// 스위치 변수 선언 코딩
		boolean sw = false; // 기본값 fales
		int sum = 0;
		for (int i = 1; i <= 10; i++) {

//			if (sw) {
//				System.out.printf("%d+", i);
//				sum -= i;
//				// sw=false;
//			} else {
//				System.out.printf("%d-", i);
//				sum += i;
//				// sw=true;
//			}
			sum+= sw?-i:i;
			System.out.printf(sw?"%d+":"%d-",i);
			sw = !sw;
		} // for
		System.out.printf("=%d", sum);
	} // main
}
