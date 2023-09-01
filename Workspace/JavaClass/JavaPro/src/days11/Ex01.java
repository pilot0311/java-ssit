package days11;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Ex01 {

	public static void main(String[] args) {
		// 30명 학생의 성적처리 ( 이름, 국,영,수, 총,평, 등수 )
		final int STUDENT_COUNT = 30;
		String name;
		int count = 0;
		int kor, eng, mat;
		int tot;
		double avg;
		int rank;

		String[] names = new String[STUDENT_COUNT];
		int[] kors = new int[STUDENT_COUNT];
		int[] engs = new int[STUDENT_COUNT];
		int[] mats = new int[STUDENT_COUNT];
		int[] tots = new int[STUDENT_COUNT];
		double[] avgs = new double[STUDENT_COUNT];
		int[] ranks = new int[STUDENT_COUNT];
		Arrays.fill(ranks, 1);

		do {
			name = getName();
			kor = getScore();
			eng = getScore();
			mat = getScore();
			tot = kor + eng + mat;
			avg = tot / 3;
			names[count] = name;
			kors[count] = kor;
			engs[count] = eng;
			mats[count] = mat;
			tots[count] = tot;
			avgs[count] = avg;
			count++;

		} while (count != STUDENT_COUNT);

		rankUp(avgs, ranks, count);
		 //pirntScore(names, kors, engs, mats, tots, avgs, ranks, count);
		//insertList();
		maxIndex();
	} // main

	private static void pirntScore(String[] names, int[] kors, int[] engs, int[] mats, int[] tots, double[] avgs,
			int[] ranks, int count) {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등수");
		for (int i = 0; i < count; i++) {
			System.out.printf("%s:%d\t%d\t%d\t%d\t%.2f\t  %d\n", names[i], kors[i], engs[i], mats[i], tots[i], avgs[i],
					ranks[i]);
		} // for

	}

	private static void rankUp(double[] avgs, int[] ranks, int count) {
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				if (avgs[i] < avgs[j])
					ranks[i]++;
			} // for
		} // for
	}

	private static int getScore() {

		return (int) (Math.random() * 101);
	}

	private static String getName() {
		Random rnd = new Random();
		char[] nameArr = new char[3];
		for (int i = 0; i < nameArr.length; i++) {
			nameArr[i] = (char) (rnd.nextInt('힣' - '가' + 1) + '가');
		} // for
		String name = String.valueOf(nameArr);
		return name;
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
		//String.join(null, null)
		System.out.printf("max= %d\n", max);
		//Arrays.copyOf(복사할 배열, 어디까지 복사할껀지)
		System.out.println("index= " + Arrays.toString(index).replace("[","").replace("]", ""));
	}

}
