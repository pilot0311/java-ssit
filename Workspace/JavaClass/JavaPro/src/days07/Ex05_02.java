package days07;

import java.util.Scanner;

public class Ex05_02 {

	public static void main(String[] args) {
		//국어점수 kor을 입력 받아서 0<=kor<=100 올바른 국어 점수 잘못된 국어점수
		int kor=0;
		String inputData;
		String regex="\\d{1,2}|100"; //09 true
		String regex1="\\d|[1-9]{2}|100";
		String regex2="100|[1-9]?\\d";
		boolean flag;
		
		try (Scanner sc = new Scanner(System.in)) {
			inputData=sc.next();
			flag = inputData.matches(regex2);
			if(flag) kor=Integer.parseInt(inputData);
			System.out.printf("%s는 %s 국어점수",flag?kor:inputData, flag?"올바른":"잘못된");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	} // main
}
