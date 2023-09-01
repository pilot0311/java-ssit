package days03;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {

		String name;
		int age;
		int kor;
		int eng;
		int math;
		int total;
		double avg;
		Scanner sc = new Scanner(System.in);
		System.out.printf("이름 나이 국어 영어 수학 입력");
		name = sc.next();
		age = sc.nextInt();
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		sc.close();
		total = kor + eng + math;
		avg = (double) total / 3;
		System.out.printf("\"%s\" %d살 %d %d %d %d %.2f", name, age, kor, eng, math, total, avg);

	}//main
}//class
