package days26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

/**
 * @author pilot
 * @date 2023. 8. 18. - 오전 9:01:39
 * @subject DataInputStream / DataOutputStream	보조 스트림
 * @content 바이트 스트림 - 기본형 8가지를 읽기 / 쓰기 가능한 바이트 스트림
 */
public class Ex02_02 {

	public static void main(String[] args) {

		String name;
		int kor, eng, mat;
		int tot;
		double avg;
		boolean gender;
		
		//	한 학생 정보를 student.dat에 파일에 저장
		//	FileWriter			문자 파일 스트림
		//BufferedWriter	문자 보조 스트림
		String fileName = ".\\src\\days26\\student.dat";
		try(FileInputStream in = new FileInputStream(fileName); DataInputStream dis = new DataInputStream(in)) {
			name = dis.readUTF();
			kor = dis.readInt();
			eng = dis.readInt();
			mat = dis.readInt();
			tot = dis.readInt();
			avg = dis.readDouble();
			gender = dis.readBoolean();
			System.out.printf("%s %d %d %d %d %f %b\n", name, kor, eng, mat, tot, avg, gender);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END");
		

	} // main

}
