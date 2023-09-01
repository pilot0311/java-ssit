package days04;

import java.util.Scanner;

public class Ex09 {
	public static void main(String[] args) {
		// 국어점수입력받아 수우미양가 등급 출력 -> switch

		int kor;
		char grade = 0;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("점수 입력");
			kor = sc.nextInt();

			//break;=제어문 빠져나옴 break문 없을시 모든 분기 실행
			switch (kor / 10) {
			case 10:
			case 9:
				grade = '수';
				break;
			case 8:
				grade = '우';
				break;
			case 7:
				grade = '미';
				break;
			case 6:
				grade = '양';
				break;
			case 5:
			case 4:
			case 3:
			case 2:
			case 1:
			case 0:
				grade = '가';
				break;
			default:
				System.out.println("점수 잘못 입력");
				break;
			} // switch
			System.out.println(grade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main
}
