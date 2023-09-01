package days11;

import java.util.Arrays;

public class Ex02 {

	public static void main(String[] args) {
		
		
		
	} // main
	public static void insertList() {
		int[] m = { 3, 5, 2, 4, 1 };
		int index = 3;
		int n = 100;
		int[] temp = new int[m.length + 1];
		for (int i = 0; i < m.length; i++) {
			if (index > i) {
				temp[i] = m[i];
			} else if (index <= i) {
				temp[i + 1] = m[i];
			}
		} // for
		temp[index] = n;
		m = temp;
		System.out.println(Arrays.toString(m));
	}
}
