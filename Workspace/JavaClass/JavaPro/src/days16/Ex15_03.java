package days16;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author kenik
 * @date 2023. 8. 3. - 오후 4:40:27
 * @subject  [ 개발자가 고의로 예외 발생시키기 ]
 * @content  1. new 예외클래스()
 *           2. throw 문을 사용해서 예외를 발생킬 수 있다.
 *           
 *           예) 국어점수 입력받아서 수~가 등급(성적) 처리.
 *               0<= ~ <=100 점수범위가 벗어나면 예외 발생-> 처리
 */
public class Ex15_03 {

	public static void main(String[] args)  {
		
		try {
			int kor = getScore(); 
			System.out.println(kor);
		} catch (ScoreOutOfBoundsException e) { 
			System.out.println( e );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외 발생 유무 상관없이 처리할 코딩..
		}
		 
		System.out.println(" end ");


	} // main

	private static int getScore() throws ScoreOutOfBoundsException {
		
		Scanner scanner = new Scanner(System.in);
		int score;
		
		System.out.print("> 점수 입력 ? ");
		String input = scanner.next();
		String regex = "100|[1-9]?\\d";
		
		if ( input.matches(regex) ) {
			score = Integer.parseInt(input);
			return score;
		} else {
			// 개발자 고의로 예외 발생 시키자.
			throw new ScoreOutOfBoundsException("> 점수 범위(0~100) 벗어났다. <");

		} // if
		
		
	}

} // class
