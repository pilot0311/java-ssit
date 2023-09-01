package days02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("나이 입력: ");
		byte age=0;
		//Type mismatch: cannot convert from String to byte
		age = Byte.parseByte(br.readLine());
		//정수형은 %d
		System.out.printf("나이는 %d입니다", age);

	}//main

}//class
