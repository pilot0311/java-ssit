package days03;

import java.util.Scanner;

/**
 * @author pilot
 * @date 2023. 7. 17. - 오후 3:44:31
 * @subject(시험) 두 문자열 비교
 * @content
 */
public class Ex09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//The value of the local variable name is not used  
		String name1 = "홍길동";
		
		Scanner sc = new Scanner(System.in);
		System.out.printf(">비교할 이름을 입력: ");
		
		String name2;
		name2=sc.next();
		System.out.printf("[%s]\n",name2);
		//System.out.println(name1==name2);
		//두 문자열 비교시 equals() 사용
		System.out.println(name1.equals(name2));
		//대/소문자 구분하지 않고 비교
		System.out.println("pilot".equalsIgnoreCase("PILOT"));

	}

}
