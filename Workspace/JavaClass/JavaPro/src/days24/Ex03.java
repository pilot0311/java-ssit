package days24;

import java.util.ArrayList;
import java.util.Collections;

public class Ex03 {

	public static void main(String[] args) {
		//	Arrays : 배열 사용하기 쉽도록 기능이 구현된 클래스
		//				sort(), binarySearch(), fill(), copy() 등등
		//	Collections 클래스
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(list);	//[]
		
		//1,2,3,4,5
		//									<? super Object>의 의미
		//				 Collections.addAll(? super Object);
		//						Object
		Collections.addAll(list, 1,2,3,4,5);
		System.out.println(list);
		
		//자리회전 
		Collections.rotate(list, 2);
		System.out.println(list);
		//자리 바꾸기
		Collections.swap(list, 0, 2);
		System.out.println(list);
		
		// 무작위 자리 바꿈
		Collections.shuffle(list);
		System.out.println(list);
		
		//정렬
		Collections.sort(list);
		System.out.println(list);
		//내림차순 정렬
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
		//채우기
		Collections.fill(list, -1);
		System.out.println(list);
		
		//복사
		//Collections.copy(null, null);
		//바꾸기
		//Collections.replaceAll(null, null, null)
		//등등
		
	} // main
	
}
