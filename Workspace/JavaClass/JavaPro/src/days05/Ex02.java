package days05;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex02 {
	public static void main(String[] args) {
		// 6번
		
			
		
		
		
		
		String s;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("한문자입력:");
			s = sc.next();
			if (Pattern.matches("^[0-9]$", s)) {
				System.out.println("숫자입니다");
			} else if (Pattern.matches("^[a-zA-Z]$", s)) {
				System.out.println("영어입니다");
			} else if (Pattern.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]$", s)) {
				System.out.println("한글입니다");
			} else
				System.out.println("특수 문자 입니다");
			
//		char c;
//		c = sc.next().charAt(0);
//		if('0'<=c&&c<='9') {
//			System.out.println("숫자 입니다");
//		}else if(('A'<=c&&c<='Z') || ('a'<=c&&c<='z') ) {
//			System.out.println("영어 입니다");
//		}else if(('가'<=c&&c<='힣') || ('ㄱ'<=c&&c<='ㅎ') || ('ㅏ'<=c&&c<='ㅣ')) {
//			System.out.println("한글 입니다");
//		}else 
//			System.out.println("특수 문자 입니다");
//		

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main
}
