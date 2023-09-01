package days13;

public class Ex08 {
	
	//필드
	//인스턴스 변수
	public int age;
	//[시험]
	public static void main(String[] args) {
		String name; // 지역 변수
		//	[JVM의 메모리 구조]
		//	응용프로그램 -> JVM 실행 -> 응용프로그램이 사용할 메모리 할당
		//	메모리를 용도에 따라  영역 나누어서 관리
		//	1) Call Stack(스택영역)
		//		메서드의 작업에 필요한 메모리 공간 제공
		//		지역변수, 매개변수
		//	2)	Heap(동적영역)
		//		new 객체생성() 즉, 인스턴스 생성되는 공간
		//	3)	Method Area
		//		클래스 파일(???.class)에 대한 정보 저장
		//		클래스 변수 저장
		//		[자바 변수는 선언되는 위치에 따라 3가지 종류]
		//	1.	지역변수
		//	2.	필드
		//		1)	인스턴스 변수
		//		2)	클래스 변수
	} // main
}
