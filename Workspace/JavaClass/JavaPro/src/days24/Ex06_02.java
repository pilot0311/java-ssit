package days24;

import java.util.Arrays;
import java.util.Comparator;

public class Ex06_02 {

	public static void main(String[] args) {
		String[] names = { "이지현", "김호영", "임경재", "유희진" };
		System.out.println(Arrays.toString(names));

		// 내림차순 정렬
		// Arrays.sort(names,Comparator 객체);
		// Arrays.sort(names,new StringDescendingComparator());

//		2.	사용 형식
		// 부모타입 객체명 = new 부모타입(매개변수...){
		// 필드
		// 메서드
		// @Override 재정의 함수 구현
		// };
		// 부모타입 == 클래스, 인터페이스

//		Comparator  c = new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {	
//				return o2.compareTo(o1);
//			}
//		};
//		
//		Arrays.sort(names,c);

		// sort()메서드 호출 부분
		// 매개변수로 익명 클래스 사용한 예
//		Arrays.sort(names, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o2.compareTo(o1);
//			}
//		});

		//	람다식
		Arrays.sort(names, (o1, o2) -> o2.compareTo(o1));

		System.out.println(Arrays.toString(names));
	} // main
}

//	1.	Comparator 인터페이스를 구현한 클래스
//class StringDescendingComparator implements Comparator<String>{
//
//	@Override
//	public int compare(String o1, String o2) {
//		// TODO Auto-generated method stub
//		return o2.compareTo(o1);	//내림차순정렬
//	}
//	
//}
