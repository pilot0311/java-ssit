package days16;

public class Ex03 {

	public static void main(String[] args) {

		// 1. 지역변수 -> 상수 final키워드
		final double PI = 3.141592;

		FinalTest obj = new FinalTest();
		obj.finalTest(100);
//		System.out.println(obj.PI);
		// he final field FinalTest.PI cannot be assigned final변수 다른값 할당 불가
		// obj.PI = 3.14;

	} // main
}

//class Parent {
//	
//	//재정의 할 수 없는 최종 메서드
//	final void dispA() {
//		
//	}
//}
//
//class Child extends Parent {
//	@Override
//	public void dispA() {
//		
//	}
//}

final class FinalTest {
	// public static final double PI = 3.141592; //명시적 초기화
	// The blank final field PI may not have been initialized final변수 초기화 해야함
	final double PI;
	int a =1;

//	{						//인스턴스 초기화 블럭
//		PI = 3.14;
//	}
	public FinalTest() {
		PI = 3.14; // 생성자 초기화
	}

	public void finalTest(final int value) {
		// int value 지역변수, 매개변수
	}
}