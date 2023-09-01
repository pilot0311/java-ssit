package days23;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import days10.Ex06_04;

/**
 * @author sangmun
 * @date 2023. 8. 14. - 오전 10:52:24
 * @subject
 * @content
 */
public class Ex02_01 {

	public static void main(String[] args) throws IOException {
		ArrayList<Student> class1 = new ArrayList<>();
		ArrayList<Student> class2 = new ArrayList<>();
		ArrayList<Student> class3 = new ArrayList<>();
		
		ArrayList<ArrayList<Student>> sistList = new ArrayList<>();
		sistList.add(class1);
		sistList.add(class2);
		sistList.add(class3);
		
		char con = 'y';
		String name;
		int kor, eng, mat, tot, rank, wrank;
		double avg;
		
		Scanner sc = new Scanner(System.in);
		int ban;
		
		do {
			// 1. 반 입력
			System.out.print("> 반 입력 ? ");
			ban = sc.nextInt();
			ArrayList<Student> classList = sistList.get(ban-1);
			// 2. 그 반의 학생 정보 입력
			System.out.printf("> %d반의 [%d]번 학생의 이름 국어 영어 수학 입력 ? ",
					ban, classList.size()+1);
			name = Ex06_04.getName();
			kor = Ex06_04.getScore();
			eng = Ex06_04.getScore();
			mat = Ex06_04.getScore();
			
			tot = kor + eng + mat;
			avg = (double)tot / 3;
			wrank = rank = 1;
			
			Student s = new Student(classList.size()+1, name, kor, eng, mat, tot, avg, rank, wrank);
			classList.add(s);
			
			System.out.print("> 입력 계속 ? ");
			con = (char)System.in.read();
			System.in.skip(System.in.available());
		} while(Character.toUpperCase(con) == 'Y');
		
		// [1]
		/*
		int totalStudents = 0;
		Iterator<ArrayList<Student>> ir = sistList.iterator();
		while (ir.hasNext()) {
			ArrayList<Student> classList = ir.next();
			totalStudents += classList.size();
		} // while
		System.out.printf("\t\t학생 정보 출력( %d명 )\n", totalStudents);
		*/
		
		int sum = sistList.stream().mapToInt(ArrayList::size).sum();
		System.out.printf("\t\t학생 정보 출력( %d명 )\n", sum);

		Iterator<ArrayList<Student>> ir = sistList.iterator();
		ban = 1;
		while (ir.hasNext()) {
			ArrayList<Student> classList = ir.next();
			System.out.printf("[%d반 학생 : %d명 ]\n", ban++, classList.size());
			Iterator<Student> ir2 = classList.iterator();
			while (ir2.hasNext()) {
				Student s = ir2.next();
				System.out.print(s.getNo() + "\t" + s);
			}
		}
	}

}
