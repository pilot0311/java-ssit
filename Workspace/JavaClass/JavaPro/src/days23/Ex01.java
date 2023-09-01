package days23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// Set 은 순서가 없기에 .get(index); 없음
		LinkedHashSet<Integer> lotto = null; // LinkedHashSet 에 Integer타입만 넣겠다
		ArrayList<LinkedHashSet<Integer>> lottos = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("> 게임 횟수 입력 ? ");
		int n = sc.nextInt();
		int lottoNumber = -1;
		for (int i = 0; i < n; i++) {
			lotto = new LinkedHashSet<>(6);
			while (lotto.size() < 6) {
				lottoNumber = (int) (Math.random() * 45) + 1;
				lotto.add(lottoNumber);
			}
			lottos.add(lotto);
		} // for

		//정렬
		ArrayList<Integer> sList = null;
		// 출력
		int no = 1;
		Iterator<LinkedHashSet<Integer>> ir = lottos.iterator();
		while (ir.hasNext()) {
			lotto = ir.next();
			
			sList = new ArrayList<Integer>(lotto);
			Collections.sort(sList);
			
			Iterator<Integer> ir2 = sList.iterator();
			System.out.printf("%d게임 : ", no++);
			while (ir2.hasNext()) {
				//Integer -> int 오토언박싱
				lottoNumber = ir2.next();
				System.out.printf("[%02d]", lottoNumber);
			}
			System.out.println();
		}

	} // main
}
