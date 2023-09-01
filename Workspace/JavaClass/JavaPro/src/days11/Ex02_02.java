package days11;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex02_02 {

	public static void main(String[] args) {
		//검색 search
		//	1.	순차검색(sequential Search)
		//	2.	이진검색(binary Search) => 정렬되있어야함
//		int[] m = { 3, 5, 2, 4, 1 };
//		//정수 4가 있는 위치에 100을 삽입하는 코딩
//		int n = 4;
//		int index = sequentialSearch(m,n);
//		System.out.printf("index: %d\n",index);
//		//System.arraycopy();
//		int [] temp = new int [m.length+1];
//		for (int i = 0; i < m.length; i++) {
//			temp[index>i?i:i+1]=m[i];
//			
//		} // for
//		temp[index]=100;
//		System.out.println(Arrays.toString(temp));
		
		//위의 코딩처럼 배열 m사용 -> 단점
				//	1)	요소추가(배열크기 자동 증가/감소)
				//	2) 요소삽입
				//	3) 요소삭제
				
				//->컬렉션(collection) 클래스
				//ArrayList<E> 	jdk 1.5 제네릭스
				ArrayList list = new ArrayList();
				list.add(3);
				list.add(5);
				list.add(2);
				list.add(4);
				list.add(1);
				
				int index = list.indexOf(4);//요소의 위치
				System.out.println(index);
				System.out.println(list);
				list.add(index, 100);//요소 삽입
				System.out.println(list);
	} // main
	
	private static int sequentialSearch(int [] m, int n) { // Starts from n to m
	    int index = -1;
	    for (int i = 0; i < m.length; i++) {
			if(n==m[i]) {
				index = i;
				break;
			}
		} // for
	    return index;
	}
	
}
