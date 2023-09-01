package days08;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01 {
	public static void main(String[] args) {
		// [2-1]
		try (Scanner sc = new Scanner(System.in)) {
			int kor = getScore(sc,"국어");
			int eng = getScore(sc,"영어");
			int mat = getScore(sc,"수학");
			System.out.printf(">국어: %d, 영어: %d, 수학: %d\n", kor, eng, mat);
			//[2-2]
			char gradeKor = getGrade(kor);
			char gradeEng = getGrade(eng);
			char gradeMat = getGrade(mat);
			System.out.printf(">국어: %c, 영어: %c, 수학: %c\n",gradeKor,gradeEng,gradeMat);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
//		int result = sum(1,2,3,4,5,6,7,8);
//		System.out.println(result);
//		char a= 'a';
//		System.out.println(upper(a));

//		[피보나치 수열]
//		int sum = 1; // 총합 
//		int prev1 = 0;// n-2번쨰 항
//		int prev2 = 1;// n-1번째 항
//		int result = 0; // 이전항들의 합//현재 항
//
//		System.out.printf("%d+", prev2); // 첫번째항
//
//		for(int i = 2; i<=11; i++) {  //2번째 항부터 시작
//			result = prev1 + prev2;
//			System.out.printf("%d+", result);
//			prev1 = prev2;
//			prev2 = result;
//			sum += result;
//		} // while
//		System.out.printf("=%d", sum);
//		

	} // main

	public static int getScore(Scanner sc,String subject) {
		int score = 0;
		String inputData = null;
		do {
			System.out.printf("%s점수를 입력하세요",subject);
			inputData = sc.next();
			System.out.printf("%s는 %s", inputData,
					inputData.matches("100|[1-9]?\\d") ? " 올바른 점수 입니다\n" : "잘못된 점수 입니다\n");
		} while (!inputData.matches("100|[1-9]?\\d"));
		score = Integer.parseInt(inputData);

		return score;
	}// getScore

	public static char getGrade(int score) {
		char c='가';
		
		switch (score / 10) {
		case 10:
		case 9:
			c = '수';
			break;
		case 8:
			c = '우';
			break;
		case 7:
			c = '미';
			break;
		case 6:
			c = '양';
			break;

		default:
			c = '가';
			break;
		} // switch

		return c;

	}// kor

	public static int sum(int... n) {
		int result = 0;
		for (int i = 0; i < n.length; i++) {
			result += n[i];
		} // for
		return result;
	}// sum

	public static char upper(char a) {
		a = Character.toUpperCase(a);
		return a;
	}// upper

}
