package days10;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		//[시험1]
		//한반에 30명의 학생
		//성적처리(이름,국,영,수,총점,평균,등수)
		//	1.	학생 정보 입력
		//	2. 총점 평균
		//	3.	등수
		//	4.	학생 정보 출력
		//	5.	파일 저장 및 DB저장
		String name;
		int kor,eng,mat;
		int tot;
		double avg;
		int rank;
		// 배열 사용해서 선언
		final int STUDENT_COUNT = 30;		//총학생수 선언
		String [] names = new String[STUDENT_COUNT];
		int[]	kors = new int[STUDENT_COUNT];
		int[]	engs = new int[STUDENT_COUNT];
		int[]	mats = new int[STUDENT_COUNT];
		int[]	tots = new int[STUDENT_COUNT];
		double[]	avgs = new double[STUDENT_COUNT];
		int[] ranks = new int[STUDENT_COUNT];
		
//		names[0]="홍길동";
//		System.out.println(names[0]);
		Scanner sc = new Scanner(System.in);
		int count = 0; //입력받은 학생수
		char con = 'y';
		
		System.out.printf(">이름, 국어 ,영어 ,수학 입력? ");
		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		tot=kor+eng+mat;
		avg=(double)(tot)/3;
		rank = 1;
		
		names[0]=name;
		kors[0] = kor;
		engs[0] = eng;
		mats[0] = mat;
		tots[0] = tot;
		avgs[0] = avg;
		ranks[0] = rank;
		count++;
		
		
		
	} // main
}
