package days21;

//시험
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.plaf.basic.BasicComboBoxUI.ListDataHandler;

public class Ex14_03 {

	public static void main(String[] args) {
//		1조
//		이경서(팀장), 신종혁, 이재영, 송해영 , 신기범, 이준희, 김성준 
//		2조
//		박민석(팀장), 유희진, 고경림, 임경재, 이지현 , 김정주, 김호영
//		3조
//		박정호(팀장), 이상문, 이주영, 정하영, 이동현, 주강민

		ArrayList team1 = new ArrayList();
		// System.out.println(team1.size()); //0 요소의 갯수
		String t1 = "이경서(팀장), 신종혁, 이재영, 송해영 , 신기범, 이준희, 김성준 ";
		t1 = t1.replaceAll("\\(팀장\\)", "");
		String[] t1Arr = t1.split("\\s*,\\s*");
		for (int i = 0; i < t1Arr.length; i++) {

			team1.add(t1Arr[i]);
		} // for

		// System.out.println(team1);

		ArrayList team2 = new ArrayList();
		team2.add("유희진");
		team2.add("고경림");
		team2.add("임경재");

		ArrayList team3 = new ArrayList();
		team3.add("이상문");
		team3.add("정하영");
		team3.add("박정호");

		ArrayList<String> class5 = new ArrayList<String>(team1);
		class5.addAll(team2);
		class5.addAll(team3);

		System.out.println(class5);

		// Iterator 모든 요소 출력
		Iterator ir = class5.iterator();
		while (ir.hasNext()) {
			String name = (String) ir.next();
			// System.out.println(name);
		}

		System.out.println(class5.containsAll(team1)); // team1 이 모두 class5에 포함되어 있는가

		// 이름을 오름차순 정렬
		// 원본 그대로 유지 - 복제본 수정,삭제, 추가
		ArrayList class5Clone = (ArrayList) class5.clone();
		class5Clone.removeAll(team1);
		// 2조+3조
		System.out.println(class5Clone);
		// 이름 순으로 오름차순 정렬
		// Comparator 비교 기준
		
		
		//class5Clone.sort(Comparator.naturalOrder());
		//System.out.println(class5Clone);
		 //Collections.sort(class5Clone);		
		class5Clone.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println(class5Clone);
	} // main

}
