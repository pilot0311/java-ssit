package days10;

import java.util.Arrays;

public class Ex03_02 {

	public static void main(String[] args) {
		int[]m = new int [3];
		m[0]=1;
		m[1]=2;
		m[2]=3;
		//java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		//m[3]=4;
		int index = 3;
		//	1.	원래 배열크기+3 증가
		//		[][][][][][]			[]temp
		//	2.	m -> temp 요소 복사
		//	3.	temp배열을 m배열로 바꾸는 코딩
		
		if(index==m.length) {
			int []temp = new int [m.length+3];
			for (int i = 0; i < m.length; i++) {
				temp[i]=m[i];
			} // for
			m=temp;
		}
		m[3]=4;
		System.out.println(Arrays.toString(m));
		
	} // main
}
