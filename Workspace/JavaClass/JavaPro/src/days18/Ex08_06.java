package days18;

import java.util.Arrays;

public class Ex08_06 {

	public static void main(String[] args) {
		String s = "TODO Auto-generated method stub";
		//	1) String -> char[] 변환
		char[] sArr = s.toCharArray();
		for (char c : sArr) {
			//System.out.println(c);
		} //foreach
		//	2) char[] -> String 변환
		//s = String.valueOf(sArr);
		s = new String(sArr);
		
		//	3) String -> byte[] 변환
		// -128 ~ 127 정수
		byte[] bArr = s.getBytes();
		
		//	4) byte[] -> String
		s = new String(bArr);
		
		System.out.println("-".repeat(40));
		
		String name = "       홍길동      ".trim();	//trim() 공백 제거
		System.out.printf("[%s]",name);
		
	}

}
