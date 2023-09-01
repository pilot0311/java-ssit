package days13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 게임 할까요? : ");
		int[][]lottos = new int[sc.nextInt()][6];
		
		fill(lottos);
		disp(lottos);
		
	} // main

	private static void disp(int[][] lottos) {
		for (int i = 0; i < lottos.length; i++) {
			System.out.printf("%d번쨰 게임:  ",i );
			for (int j = 0; j < lottos[i].length; j++) {
				System.out.printf("[%d]",lottos[i][j]);
			} // for
			System.out.println();
		} // for
		
	}

	private static void fill(int[][] lottos) {
		
		
		
		for (int i = 0; i < lottos.length; i++) {
			int number;
			int index = 0;
			while (index<=5) {
				number = (int)(Math.random()*6)+1;
				if (!isDuplicateLotto(lottos,index,number,i)) {
					lottos[i][index++] = number;
				} //if
			}
			} // for
		} // for

	private static boolean isDuplicateLotto(int[][] lottos, int index, int number, int i) {
		for (int j = 0; j < index; j++) {
			if(lottos[i][j]==number)return true;
		} // for
		return false;
	}
		
	
}
