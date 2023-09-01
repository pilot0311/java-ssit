package days03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author pilot
 * @date 2023. 7. 17. - 오후 5:19:04
 * @subject	
 * @content
 */
public class Ex12 {

	public static void main(String[] args) throws IOException{
		String name;
		int kor,eng,math,sum;
		
		float avg;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//홍길동, 90, 70, 60
		System.out.print("이름, 국어, 영어, 수학 입력:  ");
		String inputData = br.readLine();
		//"홍길동, 90, 70, 60" 구분자 콤마(,) 잘라내기 => "홍길동" "90" "70" "60"
		//1)기능	2)매개변수	3)리턴값(리턴자료형)
		String[] data = inputData.split(",");
		name = data[0];
		kor = Integer.parseInt(data[1]);
		eng = Integer.parseInt(data[2]);
		math = Integer.parseInt(data[3]);
		
		sum = kor + eng + math;
		avg = (float)sum/3;
		System.out.printf("%s님은 국:%d 영:%d 수:%d 총점:%d 평균:%.2f 이다.",name,kor,eng,math,sum,avg);

	}//main

}//class
