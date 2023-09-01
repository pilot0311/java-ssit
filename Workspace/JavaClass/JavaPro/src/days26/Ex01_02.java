package days26;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pilot
 * @date 2023. 8. 18. - 오전 9:01:39
 * @subject DataInputStream / DataOutputStream
 * @content 바이트 스트림 - 기본형 8가지를 읽기 / 쓰기 가능한 바이트 스트림
 */
public class Ex01_02 {

	public static void main(String[] args) {

		// String data = String.format("%s, %d, %d, %d, %d, %f, %b",
		// name,kor,eng,mat,tot,avg,gender);
		// 원하는 학생의 정보를 출력
		// FileReader 문자 파일 스트림
		// BufferedReader 문자 보조 스트림
		String name;
		int kor, eng, mat;
		int tot;
		double avg;
		boolean gender;

		// 한 학생 정보를 student[.txt] 파일에 저장~~~
		// FileReader 문자 파일 스트림
		// BufferedReader 문자 보조 스트림
		String fileName = ".\\src\\days26\\student.txt";

		try (FileReader in = new FileReader(fileName); BufferedReader br = new BufferedReader(in)) {
			String line = br.readLine(); // 첫 라인
			// 임경재,87,79,80,246,82.000000,true
			// String.split(",");
			// [MessageFormat 형식화 클래스 사용]
			String pattern = "{0}, {1}, {2}, {3}, {4}, {5}, {6}";
			MessageFormat mf = new MessageFormat(pattern);
			Object[] datas = mf.parse(line);

			// Object [] --> stream --> String [] 변환
			String[] s = Arrays.asList(datas).toArray(new String[datas.length]);

			name = s[0];
			kor = Integer.parseInt(s[1]);
			eng = Integer.parseInt(s[2]); // 예외발생
			mat = Integer.parseInt(s[3]); // "null"

			avg = Double.parseDouble(s[5]);
			gender = Boolean.parseBoolean(s[6]);

			/*
			 * // String = Object // Type mismatch: cannot convert from Object to String
			 * name = (String) datas[0]; // int = String = Object kor = Integer.parseInt(
			 * (String) datas[1] ); eng = Integer.parseInt( datas[2].toString() ); // 예외발생
			 * mat = Integer.parseInt( String.valueOf(datas[3]) ); // "null"
			 * 
			 * avg = Double.parseDouble( datas[5].toString() ); gender =
			 * Boolean.parseBoolean( datas[6].toString() );
			 */

			System.out.printf("%s %d %d %d %f %b\n", name, kor, eng, mat, avg, gender);

		} catch (Exception e) {
			e.printStackTrace();
		} // catch

		System.out.println("end ");

	} // main

} // class
