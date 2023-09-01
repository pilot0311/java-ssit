package days12;

import java.util.Scanner;

public class Ex02_02 {

	public static void main(String[] args) {
		// 배열 초기화 안하면 기본형의 초기값으로 설정 int의 기본값: 0
		Scanner sc = new Scanner(System.in);
		System.out.println("몇게임 할까요?");
		int[][] lottos = new int[sc.nextInt()][6];
		for (int i = 0; i < lottos.length; i++) {
			fillLotto(lottos[i]);
		} // for
		for (int i = 0; i < lottos.length; i++) {
			System.out.printf("%d번째 게임\t",i+1);
			dispLotto(lottos[i]);
		} // for
		

	} // main

	private static void fillLotto(int[] lotto) {
		int index = 0;
		int lottoNumber = (int) (Math.random() * 45) + 1;
		lotto[index++] = lottoNumber;
		boolean flag = false; // 로또 번호 중복시 true
		while (index <= 5) {
			flag = false;
			lottoNumber = (int) (Math.random() * 45) + 1;
			// 중복 확인
			for (int i = 0; i < index; i++) {
				if (lotto[i] == lottoNumber) {
					flag = true;
					break;
				} // if
			} // for
			if (!flag)
				lotto[index++] = lottoNumber;
		} // while

	}// fillLotto

	private static void dispLotto(int[] lotto) {
		for (int i = 0; i < lotto.length; i++) {
			System.out.printf("[%02d]", lotto[i]);
		} // for
		System.out.println();
	}// dispLotto
}
