package days08;

public class Ex06_02 {

	public static void main(String[] args) {
		// [시험] 1~n 합 재귀 함수
		// 1~n 합 함수
		int n = 10;
		int result = sum(n);
		System.out.printf("1~%d=%d\n", n, result);
		result = recursiveSum(n);
		System.out.printf("1~%d=%d\n", n, result);
	} // main

	// 재귀함수<-가능하면 안쓰는게 좋음
	// 트리구조 검색 = 재귀함수 쓰는 경우
	private static int recursiveSum(int n) {
		if (n == 1)
			return n;
		else
			return n + recursiveSum(n - 1);
	}
	//n =10
	//10+ recursiveSum(9);
					//9+recursiveSum(8);
//									8+recursiveSum(7); ....
//												2+recursiveSum(1);
	//															1
	//= 10+9+8+7+....+2+1=55

	private static int sum(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result += i;
		} // for
		return result;
	}
}
