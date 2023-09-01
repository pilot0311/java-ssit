package days07;

import java.net.Inet4Address;
import java.util.Scanner;

public class Ex04_02 {
	public static void main(String[] args) {

		String inputData;
		int user;
		String regex = "[1-3]";
		int n = 0; // 실패횟수 저장 변수
		boolean flag = false;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				if (flag) {
					n++;
					System.out.printf("%d번 잘못 입력\n", n);
					if (n == 5) {
						System.out.printf("%d번 잘못 입력하여 프로그램 종료\n", n);
						//return; //main 함수 빠져나옴
						System.exit(-1); //어디에 있든 프로그램 종료
					}
				}
				System.out.printf(">가위(1), 바위(2), 보(3) 유저 선택:");
				inputData = sc.next();
				flag = true;
			} while (!inputData.matches(regex));
			user = Integer.parseInt(inputData);
			System.out.printf("%d", user);

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main
}
