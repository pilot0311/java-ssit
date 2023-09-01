package days07;

public class Ex10 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = 30;
		int d = 40;
		// 두 정수의 합을 구해서 반환 하는 sum 함수 선안
		// sum() 함수 호출
		// int c = a + b;
		// a,b,c 세정수의 합
		int result = sum(a, b);
		result = sum(a, b, c, d);
		System.out.printf("%d+%d=%d", a, b, result);

	} // main

	public static int sum(int a, int b, int c, int d) {

		return a + b + c + d; // return 수식
	}

	public static int sum(int a, int b, int c) {
		return a + b + c;
	}

	public static int sum(int a, int b) {

		return a + b; // return 수식
	}
}// class