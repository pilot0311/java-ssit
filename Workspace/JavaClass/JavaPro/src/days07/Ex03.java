package days07;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex03 {

	public static void main(String[] args) {
		int com, user;
		String test, s;
		String game[] = { null, "가위", "바위", "보" };
		//	for, while, do~while ->do while
		try (Scanner sc = new Scanner(System.in)) {

			while (true) {

				System.out.printf(">가위(1), 바위(2), 보(3) 유저 선택:");

				test = sc.next();
				com = (int) (Math.random() * 3) + 1;

				if (Pattern.matches("^[1-3]$", test)) {
					user = Integer.parseInt(test);
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
					test=null;
					System.out.printf("계속 하실려면 y를 입력 하세요");
					s = sc.next();
					if (!s.equals("y"))
						break;
					
				} else {
					System.out.println("1~3사이의 숫자를 입력하세요");

				} // if
			} // while
			System.out.println("게임 종료");
		} catch (Exception e) {
			e.printStackTrace();
		} // try catch
	} // main
}
