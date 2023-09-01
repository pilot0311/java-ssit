package days04;

import java.util.Scanner;

/**
 * @author pilot
 * @date 2023. 7. 18. - 오후 4:18:07
 * @subject	컴퓨터	-	사용자(user) 가위, 바위, 보 게임
 * @content
 */
public class Ex10 {
	
	public static void main(String[] args) {
		//가위(1), 바위(2), 보(3)
		//컴퓨터는 1~3 임의의  수를 발생
		//사용자는 1~3 정수를 Scanner통해 입력
		int com,user;
		try(Scanner sc = new Scanner(System.in)) {
			System.out.printf(">가위(1), 바위(2), 보(3) 유저 선택:");
			//입력 값에 대한 유효성 검사
			user=sc.nextInt();
			com = (int)(Math.random()*3)+1;
			System.out.printf(">컴퓨터 %d, 유저 %d",com,user);
			switch (user-com) {
			case 1: case -2:
				System.out.println("사용자 승리");
				break;
			case 2: case -1:
				System.out.println("컴퓨터 승리");
				break;
			default:
				System.out.println("무승부");
				break;
			} // switch
			//
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	} // main
}
