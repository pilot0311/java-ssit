package days18;

import java.util.Arrays;
import java.util.Collections;

public class Ex01 {

	public static void main(String[] args) {
		int [] m = { 3, 5, 2, 4, 1 };
		System.out.println(Arrays.toString(m));
		Arrays.sort(m);
		System.out.println(Arrays.toString(m));
		
		//for
//		int[] temp = new int[m.length];
//		for (int i = m.length-1; i >= 0; i--) {
//			temp[4-i]=m[i];
//		} // for
//		m = temp;
		
		
		//The method sort(int[]) in the type Arrays is not applicable for the arguments (int[], Collections.reverseOrder()) 기본형배열은 Collections 적용 안됨
		// Type[T] = 클래스 , int의 래퍼 클래스 Integer
		//int -> Integer 래퍼 클래스  변환
		//박싱 언박싱
		Integer[] temp= Arrays.stream(m).boxed().toArray(Integer[]::new);
		Arrays.sort(temp, Collections.reverseOrder());		//Comparable이 구현된 클래스
	//	m=Arrays.stream(temp).mapToInt(null)
		System.out.println(Arrays.toString(temp));
		
	} // main
}
