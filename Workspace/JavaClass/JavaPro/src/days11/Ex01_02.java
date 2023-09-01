package days11;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Ex01_02 {

	public static void main(String[] args) {
		int[] m = { 3, 92, 3, 40, 71, 91, 61, 92, 76, 71, 59, 54, 64, 48, 66, 92, 25, 20, 73, 37 };

		int max = IntStream.of(m).max().getAsInt();

//		int count = 0;
//		for (int i = 0; i < m.length; i++) {
//			if (max == m[i]) {
//				count++;
//			}
//		} // for
		int count = (int)IntStream.of(m).filter(i->i==max).count();
		int[] index = new int[count];
		for (int i = count = 0; i < m.length; i++) {
			if (max == m[i]) {
				index[count++] = i;
			}
		} // for
			// String.join(null, null)
		System.out.printf("max= %d\n", max);
		// Arrays.copyOf(복사할 배열, 어디까지 복사할껀지)
		System.out.println("index= " + Arrays.toString(index).replace("[", "").replace("]", ""));
	}

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

	public static void maxIndex() {
		int[] m = { 3, 92, 3, 40, 71, 91, 61, 92, 76, 71, 59, 54, 64, 48, 66, 92, 25, 20, 73, 37 };

		int max = IntStream.of(m).max().getAsInt();

		int count = 0;
		for (int i = 0; i < m.length; i++) {
			if (max == m[i]) {
				count++;
			}
		} // for
		int[] index = new int[count];
		for (int i = count = 0; i < m.length; i++) {
			if (max == m[i]) {
				index[count++] = i;
			}
		} // for
			// String.join(null, null)
		System.out.printf("max= %d\n", max);
		// Arrays.copyOf(복사할 배열, 어디까지 복사할껀지)
		System.out.println("index= " + Arrays.toString(index).replace("[", "").replace("]", ""));
	}

}
