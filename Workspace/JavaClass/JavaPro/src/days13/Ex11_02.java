package days13;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

import days10.Ex06_04;

public class Ex11_02 {
	public static void main(String[] args) throws IOException {
		// 3반 30명 학생 이름 국 영 수 총 평 반등수 전교등수 처리 -> Student 클래스 사용 수정
		final int STUDENT_COUNT = 30;
		final int CLASS_COUNT = 3;
		
		//	클래스 2차원 배열
		Student[][] student = new Student[CLASS_COUNT][STUDENT_COUNT];
		char con = 'y';
		
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
			//클래스(객체) 복사
			Student s = student[ban-1][counts[ban-1]] = new Student();
			s.no = counts[ban - 1]+1;
			s.name = name;
			s.kor = kor;
			s.eng = eng;
			s.mat = mat;
			s.tot = tot;
			s.rank = rank;
			s.wrank = wrank;
			s.avg = avg;

			counts[ban - 1]++;
			// 입력 계속
			System.out.print("\n>입력 계속 ? ");
			con = (char) System.in.read();
			System.in.skip(System.in.available());
		} while (Character.toUpperCase(con) == 'Y');

		// 등수처리
		Student k;
		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				k = student[i][j];
				k.rank = 1; // 반등수
				k.wrank = 1; // 전교 등수

				for (int i2 = 0; i2 < counts.length; i2++) {
					for (int j2 = 0; j2 < counts[i2]; j2++) {
						
						if (k.tot < student[i2][j2].tot) { // 모든 반
							k.wrank++;
							if (i == i2) { // 같은반
								k.rank++;
							}
						}

					} // for j2
				} // for i2
			} // for j
		} // for i

		
		int totstudent = IntStream.of(counts).sum();
		System.out.printf("\t[전체 학생 수 : %d]\n", totstudent);
		
		
		for (int i = 0; i < counts.length; i++) {
			System.out.printf("\t\t[%d반 학생: %d명]\n", i + 1, counts[i]);
			for (int j = 0; j < counts[i]; j++) {
				student[i][j].printStudedntInfor();
			} // for
		} // for
		
	} // main

	private static void disp(String[][] names, int[][][] infos, double[][] avgs, int[] counts) {


		for (int i = 0; i < counts.length; i++) {
			System.out.printf("\t\t[%d반 학생: %d명]\n", i + 1, counts[i]);
			for (int j = 0; j < counts[i]; j++) {
				System.out.printf("%2d번\t%s\t%2d\t%2d\t%2d\t%3d\t%.2f\t%2d\t%2d\n", j + 1, names[i][j], infos[i][j][0],
						infos[i][j][1], infos[i][j][2], infos[i][j][3], avgs[i][j], infos[i][j][4], infos[i][j][5]);
			} // for
		} // for

	}
}
