package days06;

import java.io.IOException;

public class Ex02 {

	public static void main(String[] args) throws IOException {
		int one;
		// syntax error on token "continue", invalid VariableDeclaratorId -> 예약어는 변수명으로
		// 쓸수 없다
		char con = 'y';
//		System.out.print("> 한 문자 입력 ?");
//		one = System.in.read();
//		System.out.printf("one='%c' \n", one);
//		System.in.skip(System.in.available());
//		System.out.print("> 한 문자 입력 ?");
//		one = System.in.read();
//		System.out.printf("one='%c' \n", one);

		do {
			System.out.print("> 한 문자 입력 ?");
			one = System.in.read();
			System.out.printf("one='%c' \n", one);
			System.in.skip(System.in.available());
			System.out.print("\n\n 계속? ");
			// br, scanner, read 다 가능
			one = System.in.read(); // 'y' 'n'
			con = (char) one;
			System.in.skip(System.in.available());
		} while (con == 'y' || con == 'Y');
		System.out.println("end");
	} // main
}
