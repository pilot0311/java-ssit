package days07;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.printf("행의 갯수 입력: ");
			int row = sc.nextInt();
			int col = 2*row-1;
			
			//n->2*n-1		
			for (int i = 1; i <=row; i++) {
				for (int j = 1; j <=col; j++) {
					if(i+j>=row+1 && j-i<=row-1 )System.out.printf("*");
					else System.out.printf("_");
				} // for
				System.out.println();
			} // for
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main
}
