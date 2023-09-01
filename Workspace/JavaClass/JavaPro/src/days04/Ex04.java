package days04;

import java.util.Scanner;

/**
 * @author pilot
 * @date 2023. 7. 18. - 오전 11:44:28
 * @subject
 * @content
 */
public class Ex04 {

	public static void main(String[] args) {
		//국어 점수를 kor변수에 입력받아서 등급 출력 0~59가 60~69양 70~79미 80~89우 90~100수
		int kor;
		String grade = "가";
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("점수 입력");
			kor = sc.nextInt();
			//중첩 if문
			if (kor>=0 && kor<=100) {
				if (kor>=90) {
					System.out.println("수");
				}
				if ( 80<=kor && kor<=89) {
					System.out.println("우");
				}
				if (70<=kor && kor<=79) {
					grade = "미";
				}
				if (60<=kor && kor<=69) {
					System.out.println("양");
				}
				if (kor<=59) {
					System.out.println("가");
				}
				
				System.out.println(grade);
			} else {
				System.out.println("점수 잘못 입력");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
