package days05;

import java.util.Scanner;

public class Ex02_05 {
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			char c;
			String s;
			System.out.print("한문자입력:");
			s = sc.next();
			String regex = "[#@$!?]*";	// [^aeiou]-> 부정
			if (s.matches(regex)) {
				System.out.println("특수 문자");
			} //if
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main
}
