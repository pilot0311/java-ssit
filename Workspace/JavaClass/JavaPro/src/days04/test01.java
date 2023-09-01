package days04;

import java.util.Scanner;
import java.util.regex.Pattern;

public class test01 {

	public static void main(String[] args) {
		
				int n;
				String test;
				String result = "짝수";
				try (Scanner sc = new Scanner(System.in);) {

					System.out.print("정수 입력");
					test = sc.next();
					if (Pattern.matches("^[0-9]*$", test)) {
						n=Integer.parseInt(test);
						if (n%2!=0) {
							result = "홀수";
						}
						System.out.printf("%d는 %s 입니다\n", n,result);
					}else {
						System.out.println("정수가 아닙니다");
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

}
