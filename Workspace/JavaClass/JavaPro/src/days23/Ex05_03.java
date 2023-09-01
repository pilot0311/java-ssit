package days23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Ex05_03 {

	public static void main(String[] args) {
		
		int[] score = {80,95,50,85,45,65,10,100};
		
		//[1]
//		TreeSet<Integer> ts = new TreeSet<Integer>();
//		for (Integer n : score) {
//			ts.add(n);
//		} //foreach
		
		//[2]
		//int[] -> ArrayList -> TreeSet변환
		//Arrays.asList(T...배열)	T 클래스
		
		//																 Arrays.stream(score) = IntStream	->		Integer Stream변환
		//																							.boxed() = Stream<Integer>
		ArrayList<Integer> list =  (ArrayList<Integer>) Arrays.stream(score).boxed().collect(Collectors.toList());
		TreeSet<Integer> ts = new TreeSet<Integer>(list);
		
		System.out.println(ts);
		//Arrays.sort(score);
		//	1)	75 보다 큰 점수를 얻어와서 출력
//		for (int i = 0; i < score.length; i++) {
//			if (score[i]>75) {
//				System.out.printf("[%d]",score[i]);
//			} //if
//		} // for
		NavigableSet<Integer> ss = ts.tailSet(75,false);	//지정한 값보다 큰 값의 객체들을 반환		false면 지정한 값 포함x
		System.out.println(ss);
		//System.out.println(ts.subSet(75, ts.last()));
		//System.out.println();
		//	2)	50 보다 작은 점수를 얻어와서 출력
//		for (int i = 0; i < score.length; i++) {
//			if (score[i]<50) {
//				System.out.printf("[%d]",score[i]);
//			} //if
//		} // for
		NavigableSet<Integer> ss2 = ts.headSet(50, false);		//지정한 값보다 작은객체들을 반환 false면 지정한 값 포함x
		System.out.println(ss2);
		//	3)	50~75 사이의 점수를 얻어와서 출력
//		for (int i = 0; i < score.length; i++) {
//			if (score[i]>50&&score[i]<75) {
//				System.out.printf("[%d]",score[i]);
//			} //if
//		} // for
		
		NavigableSet<Integer> ss3 = ts.subSet(50, false, 75, false);
		System.out.println(ss3);
	} // main
	
}
