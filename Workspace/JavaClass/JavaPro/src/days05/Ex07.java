package days05;

import java.io.IOException;

public class Ex07 {

	public static void main(String[] args) throws IOException {
		int code;
		char one;
		//[1]
		System.out.print("한 문자 입력:");
		code = System.in.read(); //.read 아스키 코드 반환
		System.out.printf("code= %d\n",code);
		//one = (char) code;
		//System.out.printf("one= %c\n",one);
		
		//System.in.read(); //13 \r
		//System.in.read(); //10 \n
		System.in.skip(System.in.available()); // 입력된 나머지 버림
		
		//[2]
		System.out.print("한 문자 입력:");
		code = System.in.read(); //.read 아스키 코드 반환
		System.out.printf("code= %d\n",code);
		//one = (char) code;
		//System.out.printf("one= %c\n",one);
		
	} // main
}
