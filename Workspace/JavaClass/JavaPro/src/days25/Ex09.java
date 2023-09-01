package days25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex09 {

	public static void main(String[] args) throws IOException {
		//	본인의 이름을 입력받아서 출력
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름 입력: ");
		String name = br.readLine();
		System.out.println(name);
		*/
		
		//	1.	키보드(표준입력장치)로 부터 입력 -> 표준 입력 스트림
		//	- 바이트 스트림
		InputStream is = System.in;
		System.out.print("한글 한 문자 입력");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		int code = isr.read();
		System.out.println((char)code);
		/*
		int code;
		System.out.print("이름 입력: ");
		code = is.read();	// 1바이트 (0~255 정수 int) 반환
		System.out.println((char)code);	//한글은 2바이트라 못 읽음
		*/
		/*
		byte[] cbuf = new byte[3];
		System.out.print("이름 입력: ");
		is.read(cbuf);
		// byte[] cbuf -> char one 변환
		*/
		
		//InputStream[Reader] 보조 [문자]스트림
		// byte -> char 변환해주는 보조 스트림
		
		//Buffered[Reader] br
		
	} // main
	
}
