package days11;

import java.util.Scanner;
//인텔리제이 테스트
public class Ex09 {

	public static void main(String[] args) {
		// days08.Ex09_03t.java 로또 코딩 예제
		Scanner sc = new Scanner(System.in);
		System.out.println("몇게임 할까요?");
		int gn = sc.nextInt();
		int[][] lotto = new int[gn][6];

		fillLotto(lotto,gn);
		dispLotto(lotto,gn);

	} // main

	private static void dispLotto(int[][] lotto,int gn) {
		  for (int i = 0; i < gn; i++) {
			  System.out.printf("%d번째 게임\t",i+1);
			  for (int j = 0; j < lotto[i].length; j++) {
				  System.out.printf("[%d]", lotto[i][j]);
			} // for
			  System.out.println();
		      } // for      
		     
		
	}

	private static void fillLotto(int[][] lotto,int gn) {
	
		boolean flag = false; // 로또번호가 중복이 되면 true 할당.
		for (int i = 0; i < gn; i++) {
			int lottoNumber = (int) (Math.random() * 45) + 1;
			int index = 0;
			lotto[i][index++] = lottoNumber;
			while (index <= 5) {			
				flag = false;
				lottoNumber = (int) (Math.random() * 45) + 1; // 12
				lotto[i][index] = lottoNumber;
			//	isDuplicateLotto() 중복이되면 true, 중복이되지않으면 false
				
			if (!isDuplicateLotto(lotto, lottoNumber, index,i))
				lotto[i][index++] = lottoNumber;
			} // for
		} // for
	}//fillLotto

	private static boolean isDuplicateLotto(int[][] lotto, int lottoNumber, int index,int i) {
			for (int j = 0; j < index; j++) {
				if( lotto[i][j] == lottoNumber ) {
		            return true;
		         } // if
			} // for

	      
	      return false;
		
	}
	
}//class
