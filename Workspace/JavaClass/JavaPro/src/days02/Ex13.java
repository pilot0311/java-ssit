package days02;

/**
 * @author pilot
 * @date 2023. 7. 14. - 오후 3:25:42
 * @subject	음수 표현
 * @content	정수의 진법변환
 * 					10 -> /2		00000000 00001010
 * 					실수의 진법변환
 */
public class Ex13 {
	
	public static void main(String[] args) {
		//정수	10			0000 1010
		// 'A'				00000000 01000001
		// 음수 -10		
		//2의 보수법								
		// 1. 음수 절대치  |-10| -> 10 -> 0000 1010
		// 2. 보수								1111 0101
		// 3. 1더하기							1111 0110 -> -10
		
		// 예)
		// 0.625 x 2 = [1].25
		// 0.25 x 2 = [0].5
		// 0.5 x 2 = [1].0
		// 0.625 실수 -> 0.101(2)
		byte a = 10;
		byte b = -10;
		String t = Integer.toBinaryString(a);
		String q = Integer.toBinaryString(b);
		System.out.printf("%s \n%s", t, q);
	}// main
}// class
