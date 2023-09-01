package days13;

public class Ex06 {

	public static void main(String[] args) {

		// 좌표점 20개 쓰기 + 읽기
		// main.x, y 지역 변수
		int x = 10, y = 20;
		int x1 = 10, y1 = 20;
		int x2 = 10, y2 = 20;
		int x3 = 10, y3 = 20;
		int x4 = 10, y4 = 20;
		int x5 = 10, y5 = 20;

		dispXY(x, y); // Call By Value

	} // main

	// disp.x=10, y=20 지역 변수
	private static void dispXY(int x, int y) {

		System.out.printf("x=%d, y=%d\n", x, y);

	}

	// The variable argument type int of the method dispXY must be the last
	// parameter
	// 가변인자 여러개 사용 못함
	// 가변인자는 마지막 인자로 선언해서 사용
//	private static void dispXY(int ...x ,int ...y) {	
//	}
	
//	private static void dispXY(int [] x, int [] y) {
//		System.out.printf("x=%d, y=%d\n", x, y);
//	}

}
