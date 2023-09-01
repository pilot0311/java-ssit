package days02;

/**
 * @author pilot
 * @date 2023. 7. 14. - 오후 3:30:40
 * @subject	실수계열 double(8) float(4) 
 * @content
 */
public class Ex14 {

	public static void main(String[] args) {
		//실수계열 float(4), double(8)
		float f; //32비트 [[0]00000000	8지수][00000000000000000000000	23가수]
		double d; //64 비트[[0]00000000000	11지수][0000000000000000000000000000000000000000000000000000	52가수]
		
		//10 -> 0000 1010
		//-10 2의 보수 -> 1111 0110
		// 'A' -> 65 -> 00000000 01000001
		//9.1234567 실수
		//1001.001000111111100....
		//1.XXX  x 2^n 정규화
		//1.001000111111100....  x 2^3
		
		//모든 실수 자료형 double 기본으로 사용
		//Type mismatch: cannot convert from double to float
		float pi = 3.14f;
//		float pi = (float) 3.14;
		System.out.printf("pi = %.2f",pi);
		
	}//main

}//class
