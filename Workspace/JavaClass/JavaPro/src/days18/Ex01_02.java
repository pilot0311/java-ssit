package days18;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Ex01_02 {

	public static void main(String[] args) {
		String[] names = { "김호영", "박정호", "주강민", "김정주", "고경림" };
		//							String[] ->	Object[]
		//								매개변수	다형성
		System.out.println(Arrays.toString(names));
		//이름을 오름 차순 정렬 출력
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		
		//이름을 내림 차순 정렬
		//익명 클래스 [3]
//		Arrays.sort(names, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				//return o1.equals(o2);
//				return o2.compareTo(o1); //양수,0, 음수  리턴
//			}
//		});
		
		//[3]
		Arrays.sort(names, (o1, o2)  -> o2.compareTo(o1));	// 위의 코딩(익명 클래스) 람다식으로 변경
		
		
		//[2]
		// 배열을 다루기 쉽게 기능 구현 클래스 -> Arrays 클래스
		//	컬랙션 다루기 쉽게 기능 구현 클래스 -> Collections
		//Arrays.sort(names,Collections.reverseOrder());
		
		
		//for[1]
//		String[] temp = new String[names.length];
//		for (int i = names.length-1; i >= 0; i--) {
//			temp[4-i]=names[i];
//		} // for
//		names = temp;
		
		System.out.println(Arrays.toString(names));
	} // main
}
