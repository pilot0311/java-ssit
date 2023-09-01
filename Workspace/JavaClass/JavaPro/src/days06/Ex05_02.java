package days06;

import java.util.Scanner;

/**
 * @author pilot
 * @date 2023. 7. 20. - 오후 12:06:57
 * @subject 제어문 활용
 * @content
 */
public class Ex05_02 {

	public static void main(String[] args) {
		int n;

		try (Scanner sc = new Scanner(System.in)) {
			// 문자, 실수X 반드시 정수 입력만 가능

			System.out.print("정수(n) 입력");
			String inputData = sc.nextLine();
			
			
			//boolean flag = false; // 숫자가 아니면 true

			//정규 표현식(regular expression)
			String regex="^[0-9]+$";// == "^\d+$"
			String regex2="^\\d+$";// == "^\\d+$"
			String regex1="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,15}$"; // 비밀번호 최소 8-15 ([0-9].[a-z][A-Z])*{8,16}
			
			boolean flag =inputData.matches(regex1);
			
			
			
			if (flag) { // flag == false
				n = Integer.parseInt(inputData);
				System.out.println(n);
			} else {

				System.out.println("입력 잘못함");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main
}
