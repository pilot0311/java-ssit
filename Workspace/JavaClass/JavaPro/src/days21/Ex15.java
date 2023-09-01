package days21;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) throws IOException {
		// 한 반에 30명 학생 이름 국 영 수 총 평 등
		// 1차원
		// 2차원
		// 3차원
		// 클래스 배열 Studendt
		// Student 클래스 + ArrayList 처리
		final int STUDENT_COUNT = 30;
		String name;
		int kor, eng, mat;
		int tot;
		double avg;
		int rank;
		int wrank;
		Student s = new Student();
		ArrayList list = new ArrayList();
		
		Scanner sc = new Scanner(System.in);
		
		char con = 'y';
		int no = 1;
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
			wrank = 1;
			
			 s = new Student(no++, name, kor, eng, mat, tot, avg, rank, wrank);
			 
			list.add(s);
			

			System.out.print(">입력 계속 y: ");
			con = (char) System.in.read();
			System.in.skip(System.in.available());
		} while (Character.toUpperCase(con) == 'Y');
		//	[문제]
		// 1.등수처리
			
		Student rs1, rs2;
		for (int i = 0; i < list.size(); i++) {
			rs1 = (Student) list.get(i);
			for (int j = 0; j < list.size(); j++) {
				rs2 = (Student) list.get(j);
				if (rs1.getAvg()<rs2.getAvg()) {
					rs1.setRank(rs1.getRank()+1);
				} //if
				
			} // for
		} // for
		
		

		
		//	2. 성적 순 출력
		
		
		
		list.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				
				return o1.getRank() - o2.getRank(); 
			}
		});
		
		
		
		
		
//	      list.sort(new Comparator<Student>() {
//
//	          @Override
//	          public int compare(Student o1, Student o2) {
//	             
//	             return o1.getRank() - o2.getRank();
//	          }
//	       });
		
		
		
//		//모든 학생 출력
		System.out.println(">입력 받은 학생수: " + list.size());
		Iterator ir = list.iterator();
		while (ir.hasNext()) {
			Student a = (Student) ir.next();
			System.out.println(a);
		}
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
