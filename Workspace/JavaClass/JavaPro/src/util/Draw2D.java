package util;

public class Draw2D {
	// 2D 그리기 작업할 수 있는 모든 기능들을 구현한 클래스

	// 함수 선언 3가지
	// 1) 기능 : 선 긋기 drawLine
	// 2) 매개변수 : X
	// 3) 리턴값(리턴자료형) : X void
	// [접근 지정자][기타제어자]리턴자료형 함수명 ([매개변수...])
	public static void drawLine() {
		System.out.println("----------------");
	}

	// Duplicate method drawLine() in type Ex08_02 =클래스 x08_02에 메서드 drawLine() 이 중복됨
	public static void drawLine(int n) {
		System.out.println("-".repeat(n));
	}

	public static void drawLine(int n, String style) {
//		for (int i = 1; i <=n; i++) {
//			System.out.print(style);	
//		} // for
		System.out.print(style.repeat(n));
	}
}
