package days12;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Test {

	public static void main(String[] args) {
		
		int[] m = new int[50];
		int index = -1;
		int startIndex = 0;
		for (int i = 0; i < m.length; i++) {
			m[i]= (int)(Math.random()*30)+1;
		} // for
		
				System.out.println(Arrays.toString(m));
				int n = (int)(Math.random()*30)+1;
				System.out.printf("찾을 수:%d\n",n);
		//selectionSort(m);
				
		 while ((index= sequentialSearch(m,n,startIndex)) != -1) {
			index =  sequentialSearch(m,n,startIndex);
			System.out.printf("%d\n",index);
			 startIndex = index+1;
		}
		 
		 
	} // main

	

	private static int sequentialSearch(int[] m, int n, int startIndex) {
		int index = -1;
		for (int i = startIndex; i < m.length; i++) {
			if (m[i]==n) {
				index = i;
				break;
			} //if
		} // for
		return index;
	}



	private static void selectionSort(int[] m) {
		for (int i = 0; i < m.length-1; i++) {
			int index = i;
			for (int j = i+1; j < m.length; j++) {
				if(m[index]>m[j])
				index = j;
			} // for
			int temp = m[i];
			m[i]=m[index];
			m[index]=temp;
			System.out.println(Arrays.toString(m));
		} // for
	}
}
