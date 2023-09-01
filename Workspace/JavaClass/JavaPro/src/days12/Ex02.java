package days12;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// days08.Ex09_03t.java 로또 코딩 예제
		Scanner sc = new Scanner(System.in);
		System.out.println("몇게임 할까요?");
		
		int[][] lottos = new int[sc.nextInt()][6];

		fillLotto(lottos);
		dispLotto(lottos);

	} // main

	private static void dispLotto(int[][] lottos) {
		for (int i = 0; i < lottos.length; i++) {
			System.out.printf("%d번째 게임\t", i + 1);
			for (int j = 0; j < lottos[i].length; j++) {
				System.out.printf("[%d]", lottos[i][j]);
			} // for
			System.out.println();
		} // for

	}

	private static void fillLotto(int[][] lottos) {

		boolean flag = false; // 로또번호가 중복이 되면 true 할당.
		for (int i = 0; i < lottos.length; i++) {
			int lottoNumber;// = (int) (Math.random() * 6) + 1;
			int index = 0;
			
			while (index <= 5) {
				flag = false;
				lottoNumber = (int) (Math.random() * 6) + 1; // 12
				
				if (!isDuplicateLotto(lottos, lottoNumber, index, i))
					lottos[i][index++] = lottoNumber;
			} // while
		} // for
	}// fillLotto

	private static boolean isDuplicateLotto(int[][] lottos, int lottoNumber, int index, int i) {
		for (int j = 0; j < index; j++) {
			if (lottos[i][j] == lottoNumber) {
				return true;
			} // if
		} // for

		return false;

	}

}// class
