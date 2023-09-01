package days11;

import java.util.Arrays;

public class Ex05 {

	public static void main(String[] args) {

		int[] m = { 3, 5, 2, 4, 1 };
		// 12345 오름 차순
		// 54321 내림 차순
		// 0-1비교 1-2비교 2-3 3-4 1회전
		// 0-1비교 1-2비교 2-3 2회전
		// 0-1비교 1-2비교 3회전
		// 0-1비교 비교 4회전
		// 버블 정렬

		

		//bubbleSort(m);


		// 선택정렬
		 //selectionSort(m);

		//selectionSort2(m);


		
		//삽입정렬
		//병합정렬

	} // main
	//[시험]
	private static void selectionSort2(int[] m) {
		// 0 1 2 3 4 index
		// 3 5 2 4 1 element
		// i=0 가장작은 값의 위치 기억후 0번과 바꾼다

		for (int i = 0; i < m.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < m.length; j++) {
				if(m[minIndex]>m[j]) {
					minIndex=j;
				}
			} // for
			
			int temp = m[i];
			m[i]=m[minIndex];
			m[minIndex]=temp;
			System.out.println(Arrays.toString(m));
			System.out.println();
		} // for
		//System.out.println(Arrays.toString(m));
	}

	private static void selectionSort(int[] m) {
		// 0 1 2 3 4 index
		// 3 5 2 4 1 element
		// [선택]
		// 0-1 0-2 0-3 0-4 1 5 3 4 2 [1회전]
		// 1-2 1-3 1-4 1 2 5 3 4 [2회전]
		// 2-3 2-4 1 2 3 5 4 [3회전]
		// 3-4 1 2 3 4 5 [4회전]
		for (int i = 0; i < m.length - 1; i++) {
			for (int j = i + 1; j < m.length; j++) {
				if (m[i] > m[j]) {
					int temp = m[i];
					m[i] = m[j];
					m[j] = temp;
				}
				System.out.println(Arrays.toString(m));
			} // for
			System.out.println();
		} // for

	}

	public static void bubbleSort(int[] m) {
		for (int i = 0; i < m.length - 1; i++) {
			for (int j = 1; j < m.length - i; j++) {
				if (m[j] < m[j - 1]) {
					int temp = m[j - 1];
					m[j - 1] = m[j];
					m[j] = temp;
					
				}
				System.out.println(Arrays.toString(m));
			} // for
			System.out.println();
		} // for

	}
}
