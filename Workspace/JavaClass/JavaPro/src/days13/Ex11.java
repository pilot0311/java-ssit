package days13;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Ex11 {
	//	한 학생의 성적 관리 Student 클래스 선언
	// 한 반에 30명 성적 처리 -> 클래스 사용 수정
	public static void main(String[] args) throws IOException {

		String name;
		int kor, eng, mat;
		int tot;
		double avg;
		int rank;
		// 배열 사용해서 선언
		final int STUDENT_COUNT = 30; // 총학생수 선언
		
		// 클래스 배열
		Student[] students = new Student[STUDENT_COUNT];
		//students = 배열명
		
		
		Scanner sc = new Scanner(System.in);
		int count = 0; // 입력받은 학생수
		char con = 'y';
		do {
			System.out.printf(">이름, 국어 ,영어 ,수학 입력? ");
			// sc.next() sc.nextLine()
			name = getName();
			kor = getScore();
			eng = getScore();
			mat = getScore();
			tot = kor + eng + mat;
			avg = (double) (tot) / 3;
			rank = 1;
			
			students[count] = new Student();
			students[count].no = count+1;
			students[count].name=name;
			students[count].kor = kor;
			students[count].eng = eng;
			students[count].mat = mat;
			students[count].tot = tot;
			students[count].avg = avg;
			students[count].rank = rank;
			count++;

			System.out.print(">입력 계속 y: ");
			con = (char) System.in.read();
			System.in.skip(System.in.available());
		} while (Character.toUpperCase(con) == 'Y');
		//등수처리
		
		for (int i = 0; i < count; i++) {
			students[i].printStudedntInfor();
		} // for
		
	} // main

	public static String getName() {
		Random rnd = new Random();
		char[] nameArr = new char[3];
		for (int i = 0; i < nameArr.length; i++) {
			nameArr[i] = (char) (rnd.nextInt('힣' - '가' + 1) + '가');
		} // for

		String name = String.valueOf(nameArr);

		return name;
	}

	public static int getScore() {

		return (int) (Math.random() * 101);
	}

	

	
}
