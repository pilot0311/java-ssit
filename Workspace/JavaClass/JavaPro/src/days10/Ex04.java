package days10;

import java.util.Arrays;

public class Ex04 {

	public static void main(String[] args) {
		int[] m = { 3, 5, 2, 4, 1 };
		//System.out.println(Arrays.toString(m));

		// 추가 append
		// 삽입 insert
		// 수정
		//삭제
		int index = 2;
		int n = 100;
		//int[] temp = new int[m.length + 1];
		m[index]=n;
		//System.out.println(Arrays.toString(m));
		//삭제
		int[] temp = new int[m.length-1];
		//[1]
		System.arraycopy(m, 0, temp, 0, index);
		for (int i = index+1; i < m.length; i++) {
			temp[index++]=m[i];
		} // for
		
//		for (int i = 0; i < temp.length; i++) {
//			if (index > i) {
//				temp[i] = m[i];
//			} else if (index <= i) {
//				temp[i] = m[i+1];
//			}			
//		} // for
		m=temp;
		System.out.println(Arrays.toString(m));
	} // main
}
