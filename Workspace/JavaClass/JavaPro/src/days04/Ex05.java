package days04;

import java.util.Iterator;

/**
 * @author pilot
 * @date 2023. 7. 18. - 오후 12:28:47
 * @subject	switch 분기문
 * @content	for 반복문
 */
public class Ex05 {

	public static void main(String[] args) {
		/*
		반복횟수 i 
		for(초기식;	조건식;	증감식)
		for (int i = 0; i < args.length; i++) {
			
		}
*/
		//1~10까지의 합 출력
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum+=i;
			System.out.printf("%d",i);
			if (i<10) {
				System.out.printf("+");
			}
			
		}
		System.out.printf("=%d",sum);
	}

}
