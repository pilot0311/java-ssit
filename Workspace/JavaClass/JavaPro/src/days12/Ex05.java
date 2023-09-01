package days12;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

import days10.Ex06_04;

public class Ex05 {

	public static void main(String[] args) throws IOException {
		// 3반 30명 학생 이름 국 영 수 총 평 반등수 전교등수 처리
		final int STUDENT_COUNT = 30;
		final int CLASS_COUNT = 3;
		// 행=반 열=학생
		String[][] names = new String[CLASS_COUNT][STUDENT_COUNT];
		// 3차원 배열의 열: 국어(0) 영어(1) 수학(2) 총점(3) 반등수(4) 전교등수(5)
		int[][][] infos = new int[CLASS_COUNT][STUDENT_COUNT][6];
		// 행=반 열=학생
		double[][] avgs = new double[CLASS_COUNT][STUDENT_COUNT];
		char con = 'y';
		// 입력 받은 학생 수
//		int count1 =0;	counts[0];
//		int count2 =0;	counts[0];
//		int count3 =0;	counts[0];
		int[] counts = new int[CLASS_COUNT]; // 3반 학생 수
		String name;
		int kor, eng, mat, tot, rank, wrank;
		double avg;
		Scanner sc = new Scanner(System.in);
		int ban;

		do {
			// 1. 반 입력
			System.out.printf("> 반 입력 ? ");
			ban = sc.nextInt(); // 1, 2, 3
			// 2. 입력 받은 반의 학생 정보 입력
			System.out.printf("> %d반의 [%d]번 학생의 이름 , 국어, 영어, 수학 입력 ?", ban, counts[ban - 1] + 1);
			name = Ex06_04.getName();
			kor = Ex06_04.getScore();
			eng = Ex06_04.getScore();
			mat = Ex06_04.getScore();

			tot = kor + eng + mat;
			avg = (double) tot / 3;
			rank = wrank = 1;

			names[ban - 1][counts[ban - 1]] = name;
			infos[ban - 1][counts[ban - 1]][0] = kor;
			infos[ban - 1][counts[ban - 1]][1] = eng;
			infos[ban - 1][counts[ban - 1]][2] = mat;
			infos[ban - 1][counts[ban - 1]][3] = tot;
			infos[ban - 1][counts[ban - 1]][4] = rank;
			infos[ban - 1][counts[ban - 1]][5] = wrank;
			avgs[ban - 1][counts[ban - 1]] = avg;

			counts[ban - 1]++;
			// 입력 계속
			System.out.print("\n>입력 계속 ? ");
			con = (char) System.in.read();
			System.in.skip(System.in.available());
		} while (Character.toUpperCase(con) == 'Y');

		// 등수처리
		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				infos[i][j][4] = 1; // 반등수
				infos[i][j][5] = 1; // 전교 등수

				for (int i2 = 0; i2 < counts.length; i2++) {
					for (int j2 = 0; j2 < counts[i2]; j2++) {
						if (infos[i][j][3] < infos[i2][j2][3]) { // 모든 반
							infos[i][j][5]++;
							if (i == i2) { // 같은반
								infos[i][j][4]++;
							}
						}

					} // for j2
				} // for i2
			} // for j
		} // for i

		// 학생 정보 출력(7명)
		// 학생정보 출력
		// [1반학생 : 4명]
		// 1
		// 2
		// 3
		// 4
		// [2반 학생: 2명]
		// 1
		// 2
		int totstudent = IntStream.of(counts).sum();
		System.out.printf("\t[전체 학생 수 : %d]\n", totstudent);
		disp(names, infos, avgs, counts);
	} // main

	private static void disp(String[][] names, int[][][] infos, double[][] avgs, int[] counts) {
//		int n =0;
//		for (int i = 0; i < counts.length; i++) {
//			n += counts[i];		
//		} // for
//		System.out.printf("전체 학생 수 : %d\n",n);

		for (int i = 0; i < counts.length; i++) {
			System.out.printf("\t\t[%d반 학생: %d명]\n", i + 1, counts[i]);
			for (int j = 0; j < counts[i]; j++) {
				System.out.printf("%2d번\t%s\t%2d\t%2d\t%2d\t%3d\t%.2f\t%2d\t%2d\n", j + 1, names[i][j], infos[i][j][0],
						infos[i][j][1], infos[i][j][2], infos[i][j][3], avgs[i][j], infos[i][j][4], infos[i][j][5]);
			} // for
		} // for

	}
}
