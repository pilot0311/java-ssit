package days06;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		int min,max,a,b,c;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("정수 정수 정수 입력:");
			a=sc.nextInt();
			b=sc.nextInt();
			c=sc.nextInt();
			max=Math.max(a, b);
			max=Math.max(max, c);
			min=Math.min(a, b);
			min=Math.min(min, c);
			System.out.printf("max=%d, min=%d\n",max,min);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//중첩 if문 삼항연산자 
	} // main
}