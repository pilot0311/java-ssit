package days23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class Ex01_01 {

	public static void main(String[] args) {

		TreeSet lotto = null;
		ArrayList lottos = new ArrayList();
		Scanner sc = new Scanner(System.in);
		System.out.print("> 게임 횟수 입력 ? ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			lotto = new TreeSet();
			fillLotto(lotto);
			lottos.add(lotto);

		} // for
			// test
		dispLotto(lottos);

	} // main

	private static void dispLotto(ArrayList lottos) {
		Iterator ir = lottos.iterator();
		while (ir.hasNext()) {
			TreeSet lotto = (TreeSet) ir.next();
			System.out.println(lotto);
		}

	}

	private static void fillLotto(TreeSet lotto) {
		Random rnd = new Random();
		while (lotto.size() < 6) {
			lotto.add(rnd.nextInt(45) + 1);

		}

	}

}

// LinkedHashset + ArrayList로 로또 만들기