package days05;

import java.util.Scanner;

public class Ex02_04 {
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			char c;
			
			System.out.print("한문자입력:");
			c = sc.next().charAt(0);
			if (Character.isDigit(c)) {
				System.out.println("숫자 입니다");
			} else if (Character.isAlphabetic(c)) {
				System.out.println("영어 입니다");
			} else if (('가' <= c && c <= '힣') || ('ㄱ' <= c && c <= 'ㅎ') || ('ㅏ' <= c && c <= 'ㅣ')) {
				System.out.println("한글 입니다");
			} else if (String.valueOf(c).matches("[@$#?!]")) {
				System.out.println("특수 문자");
			}else
				System.out.println("잘못 입력");

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main
}
