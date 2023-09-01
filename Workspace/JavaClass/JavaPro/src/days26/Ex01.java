package days26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author pilot
 * @date 2023. 8. 18. - 오전 9:01:39
 * @subject DataInputStream / DataOutputStream
 * @content 바이트 스트림 - 기본형 8가지를 읽기 / 쓰기 가능한 바이트 스트림
 */
public class Ex01 {

	public static void main(String[] args) {

		String name = "신기범";
		int kor = 67, eng = 56, mat = 34;
		int tot = kor + eng + mat;
		double avg = (double) tot / 3;
		boolean gender = false;
		
		//	한 학생 정보를 student.txt에 파일에 저장
		//	FileWriter			문자 파일 스트림
		//BufferedWriter	문자 보조 스트림
		String fileName = ".\\src\\days26\\student.txt";
		try(FileWriter out = new FileWriter(fileName, true);BufferedWriter bw = new BufferedWriter(out)) {
			
			String data = String.format("%s, %d, %d, %d, %d, %f, %b", name,kor,eng,mat,tot,avg,gender);
			bw.append(data);
			bw.flush();
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END");
		

	} // main

}
