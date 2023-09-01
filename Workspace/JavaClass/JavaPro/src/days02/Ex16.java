package days02;

public class Ex16 {

	public static void main(String[] args) {
		// 1. 자동 형변환 - 2가지
		int i = 10; // [][][][] 4바이트
		// 더 큰 자료형으로 할당 되면 자동으로 형변환 EX)int->long 4바이트 -> 8바이트
		long l = i; // [][][][][][][][] 8바이트
		float f = l;
		System.out.println(f);

		long L = l + i; // long + int = 큰 자료형인 long형이됨

		// 2. 강제 형변환
		// 3*(5+2) 에서 () 최우선 연산자
		// (변환하고자하는 타입) cast 연산자			캐스트강제형변환
		int a = 20;
		int b = 3;
		System.out.println((double)a/b); // int / int = int 6, double / int = double 6.666666667
		

	}// main

}// class
