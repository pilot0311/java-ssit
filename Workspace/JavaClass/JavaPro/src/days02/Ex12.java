package days02;

public class Ex12 {
	public static void main(String[] args) {
		//문자형		char(2)
		//진법변환
		// 16진수: 0 1 2 3 4 5 6 7 8 9 a b c d e f
		// 10진수: 0 1 2 3 4 5 6 7 8 9
		// 	8진수: 0 1 2 3 4 5 6 7
		// 	2진수: 0 1
		byte b = 10; 	// [00001010]
		int i = 10; 	// [00000000	00000000	00000000	00001010]
		char c = 'A'; //2진수[0,1]  65 -> [01000001]	ASCII 7비트(128문자)
		//자바 유니코드 2바이트	[00000000][00000000]
		// 확장ASCII(8비트 256문자)
		//인코딩(encoding)  'A' -> 65 변화
		// 디코딩	65 -> 'A' 변환
		
		// '\u0000' ~ '\uffff'
		// 16진수 61 -> 10진수
		char d = '\u0061';
		int a =c;
		System.out.printf("d: %c", d);  // 'a' = 97  'A' = 65
		
		// 대문자 - 소문자 = 65 - 95 = -32
	}//main
}//class
