package days02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author pilot
 * @date 2023. 7. 14. - 오후 5:29:05
 * @subject	br
 * @content	Scanner 클래스
 */
public class Ex17_02 {

	public static void main(String[] args) throws IOException {
		
		//이름 국어 영어 수학을 입력 받아서 총점, 평균을 계산 하고 000님은 국:00 영:00 수:00 총점:000 평균:00.00 이다.
		String name;
		byte kor;
		byte eng;
		byte	math;
		short sum;
		float avg;
		
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(", \\s*");
		
		System.out.print("이름, 국어, 영어, 수학, 입력 ");
		
		name = sc.next();
		kor = sc.nextByte();
		eng = sc.nextByte();
		math = sc.nextByte();
		
		sc.close();
		
		sum = (short) (kor + eng + math);
		avg = (float)sum/3;
		System.out.printf("%s님은 국:%d 영:%d 수:%d 총점:%d 평균:%.2f 이다.",name,kor,eng,math,sum,avg);
		
	}//main

}//class
