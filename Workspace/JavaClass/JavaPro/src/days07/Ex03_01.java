package days07;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex03_01 {

	public static void main(String[] args) {
		int com, user;
		String test, s = "Y";
		String game[] = { null, "가위", "바위", "보" };
		boolean flag = false;
		//	for, while, do~while ->do while
		try (Scanner sc = new Scanner(System.in)) {

			do {
				do {
					if (flag) {
						
					} //if
					System.out.printf(">가위(1), 바위(2), 보(3) 유저 선택:");
					test = sc.next();
					flag=true;
				} while (Pattern.matches("^[1-3]$", test));
				
				
				com = (int) (Math.random() * 3) + 1;

			
					user = Integer.valueOf(test);
					System.out.printf(">컴퓨터 %s(%d), 유저 %s(%d)\n", game[com], com, game[user], user);
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
					System.out.printf("계속 하실려면 y를 입력 하세요");
					s = sc.next();
					s=s.toUpperCase();
//					if (!s.equals("y"))
//						break;		
				
			} while (s.equals("Y"));
			System.out.println("게임 종료");
		} catch (Exception e) {
			e.printStackTrace();
		} // try catch
	} // main
}
