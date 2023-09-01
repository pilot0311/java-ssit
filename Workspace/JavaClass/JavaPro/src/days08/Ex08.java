package days08;

/**
 * @author pilot
 * @date 2023. 7. 24. - 오후 2:13:32
 * @subject 재귀함수
 * @content
 */
public class Ex08 {

	public static void main(String[] args) {
		// 2^3=2*2*2=8 거듭제곱=pow
		// 밑수(2)를 지수(3)만큼 반복해서 곱하는 것

		// 일반함수
		// double result = pow(2, 3);
		// double result = pow(2, -3);
		// System.out.println(result);
		// 재귀함수
		double result = recursivePow(3, 0);
		// double result = pow(2, -3);
		System.out.println(result);
	} // main
		// 재귀함수

	private static double recursivePow(int n, int m) {
		if (m > 0)
			return n * recursivePow(n, m - 1);
		else if (m == 0)
			return 1;
		else
			return  1 / recursivePow(n, Math.abs(m));
	}// recursivePow

	// 일반함수
	private static double pow(int n, int m) {
//		int result=(int) Math.pow(n, m);
		double result = 1;

		for (int i = 0; i < Math.abs(m); i++) {
			result *= n;
		} // for
		if (m > 0) {
			return result;
		} else {
			return 1 / result;
		} // else
	}// pow
}// class

