package days11;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author pilot
 * @date 2023. 7. 27. - 오후 4:13:05
 * @subject [다차원 배열은 배열의 배열이다]
 * @content
 */
public class Ex08 {

	public static void main(String[] args) throws IOException {
		// [시험1]

		String name;
		int kor, eng, mat;
		int tot;
		double avg;
		int rank;
		// 배열 사용해서 선언
		final int STUDENT_COUNT = 30; // 총학생수 선언
		String[] names = new String[STUDENT_COUNT];

//		int[] kors = new int[STUDENT_COUNT];
//		int[] engs = new int[STUDENT_COUNT];
//		int[] mats = new int[STUDENT_COUNT];
//		int[] tots = new int[STUDENT_COUNT];
//		int[] ranks = new int[STUDENT_COUNT];

		int[][] infos = new int[STUDENT_COUNT][5];

		double[] avgs = new double[STUDENT_COUNT];
		Scanner sc = new Scanner(System.in);
		int count = 0; // 입력받은 학생수
		char con = 'y';
		do {
			System.out.print(">이름, 국어 ,영어 ,수학 입력? ");
			// sc.next() sc.nextLine()
			name = getName();
			kor = getScore();
			eng = getScore();
			mat = getScore();

			tot = kor + eng + mat;
			avg = (double) (tot) / 3;
			rank = 1;

			names[count] = name;
			infos[count][0] = kor;
			infos[count][1] = eng;
			infos[count][2] = mat;
			infos[count][3] = tot;
			infos[count][4] = rank;
			avgs[count] = avg;
			count++;

			System.out.print(">입력 계속 y: ");
			con = (char) System.in.read();
			System.in.skip(System.in.available());
		} while (Character.toUpperCase(con) == 'Y');

		// 2번 학생의 국어 점수 100점으로 수정
		infos[1][0] = 100;
		// 1번학생 성적 삭제

		// 등수 처리
		proRank(infos, count);

		// 모든 학생 정보 출력
		printStudedntInfor(names, infos, avgs, count);

	} // main

	private static void printStudedntInfor(String[] names, int[][] infos, double[] avgs, int count) {
		for (int i = 0; i < count; i++) {

			System.out.printf("%2d번 \t%s \t3%d \t%3d \t%3d \t%3d \t%3d등 \t%.2f\n", i + 1, names[i], infos[i][0], infos[i][1],
					infos[i][2], infos[i][3], infos[i][4], avgs[i]);

		} // for

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

	private static int getScore() {

		return (int) (Math.random() * 101);
	}

	private static void proRank(int[][] infos, int count) {
		for (int i = 0; i < count; i++) {
			infos[i][4] = 1;
			for (int j = 0; j < count; j++) {
				if (infos[i][3] < infos[j][3])
					infos[i][4]++;
			} // for
		} // for
	}

	private static void procRank(int[] tots, int[] ranks, int count) {
		for (int i = 0; i < count; i++) {
			ranks[i] = 1;
			for (int j = 0; j < count; j++) {
				if (tots[i] < tots[j]) {
					ranks[i]++;
				}
			} // for
		} // for
	}

	private static void printStudedntInfor(String[] names, int[] kors, int[] engs, int[] mats, int[] tots,
			double[] avgs, int[] ranks, int count) {
		for (int i = 0; i < count; i++) {
			System.out.printf("%d번 \t%s \t%d \t%d \t%d \t%d \t%.2f \t%d등\n", i + 1, names[i], kors[i], engs[i], mats[i],
					tots[i], avgs[i], ranks[i]);
		} // for
	}
}// class
