package days12;

import java.util.Arrays;

//버블정렬
//선택정렬
public class Ex02Test {

	public static void main(String[] args) {
		int[] m = { 3, 5, 2, 4, 1 };
		//bubbleSort(m);
		//selectSort(m);
		selectSort2(m);
		
	} // main

	private static void selectSort2(int[] m) {
		
		for (int i = 0; i < m.length-1; i++) {
			int index=i;
			for (int j = i+1; j < m.length; j++) {
				if(m[index]>m[j]) {
					index=j;	
				}
			} // for
			int temp = m[i];
			m[i]=m[index];
			m[index]=temp;
			System.out.println(Arrays.toString(m));
			System.out.println();
		} // for
		
	}

	private static void selectSort(int[] m) {
		for (int i = 0; i < m.length-1; i++) {
			for (int j = i+1; j < m.length; j++) {
				if(m[i]>m[j]) {
					int temp = m[i];
					m[i]=m[j];
					m[j]=temp;
					
				}
				System.out.println(Arrays.toString(m));
			} // for
			System.out.println();
		} // for
		
	}

	private static void bubbleSort(int[] m) {
		for (int i = 1; i < m.length; i++) {
			for (int j = 0; j < m.length-i; j++) {
				if(m[j]>m[j+1]) {
					int temp = m[j];
					m[j]=m[j+1];
					m[j+1]=temp;
					System.out.println(Arrays.toString(m));
				}
			} // for
			System.out.println();
		} // for
		
	}
}
