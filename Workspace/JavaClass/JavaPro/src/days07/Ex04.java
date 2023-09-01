package days07;

import java.net.Inet4Address;
import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		// [character]한문자를 대 소문자 로 바꿔 주는 메서드
//		System.out.println(Character.toUpperCase('y'));
//		System.out.println(Character.toUpperCase('Y'));
//		System.out.println(Character.toLowerCase('y'));
//		System.out.println(Character.toLowerCase('Y'));
		String inputData;
		
		int user;
		//[2]
		String regex = "[1-3]";
		int n =0;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				if(n>0&&n<5) {System.out.printf("%d번 잘못 입력\n",n);
				}else if(n==5) {System.out.printf("%d번 잘못 입력하여 프로그램 종료\n",n);return;}
				System.out.printf(">가위(1), 바위(2), 보(3) 유저 선택:");	
				inputData = sc.next();
				n++;
				
				
			} while (!inputData.matches(regex));
			user = Integer.parseInt(inputData);
			System.out.printf("%d",user);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main
}
