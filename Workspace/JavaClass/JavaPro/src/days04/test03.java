package days04;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author pilot
 * @date 2023. 7. 18. - 오후 4:18:07
 * @subject 컴퓨터 - 사용자(user) 가위, 바위, 보 게임
 * @content
 */
public class test03 {

	public static void main(String[] args) {
		
		int com, user;
		String test;
		String game[] = {"가위","바위","보"};
		try (Scanner sc = new Scanner(System.in)) {
			System.out.printf(">가위(1), 바위(2), 보(3) 유저 선택:");
			
			user = sc.nextInt();
			test = Integer.toString(user);
			com = (int) (Math.random() * 3) + 1;
			// 입력 값에 대한 유효성 검사
			if (Pattern.matches("^[1-3]$", test)) {
			
			
			
			
			System.out.printf(">컴퓨터 %s(%d), 유저 %s(%d)\n", game[com-1],com, game[user-1],user);
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
				//
			}else{
				System.out.println("1~3사이의 숫자를 입력하세요");
			} //if
		} catch (Exception e) {
			e.printStackTrace();
		} // catch
	} // main
}