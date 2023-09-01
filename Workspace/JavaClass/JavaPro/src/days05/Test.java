package days05;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		int com, user;
		String test, user2;
		String game[] = { "가위", "바위", "보" };
		try (Scanner sc = new Scanner(System.in)) {
			System.out.printf(">가위(1), 바위(2), 보(3) 유저 선택:");

			user2 = sc.next();
			
			com = (int) (Math.random() * 3) + 1;
			if (user2.equals("가위")) {
				user=1;
			}else if (user2.equals("바위")) {
				user=2;
			}else 
				user=3;

				System.out.printf(">컴퓨터 %s(%d), 유저 %s(%d)\n", game[com - 1], com, game[user - 1], user);
				switch (user - com) {
				case 1:
				case -2:
					System.out.println("사용자 승리");
					break;
				case 2:
				case -1:
					System.out.println("컴퓨터 승리");
					break;
				default:
					System.out.println("무승부");
					break;
				} // switch
					
			
		} catch (Exception e) {
			e.printStackTrace();
		} // catch
	} // main
}