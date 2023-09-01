package days26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

/**
 * @author pilot
 * @date 2023. 8. 18. - 오전 9:01:39
 * @subject DataInputStream / DataOutputStream	보조 스트림
 * @content 바이트 스트림 - 기본형 8가지를 읽기 / 쓰기 가능한 바이트 스트림
 */
public class Ex02 {

	public static void main(String[] args) {

		String name = "이지현";
		int kor = 67, eng = 56, mat = 34;
		int tot = kor + eng + mat;
		double avg = (double) tot / 3;
		boolean gender = false;
		
		//	한 학생 정보를 student.dat에 파일에 저장
		//	FileWriter			문자 파일 스트림
		//BufferedWriter	문자 보조 스트림
		String fileName = ".\\src\\days26\\student.dat";
		try(FileOutputStream out = new FileOutputStream(fileName, true); DataOutputStream dos = new DataOutputStream(out)) {
			dos.writeUTF(name);
			dos.writeInt(kor);
			dos.writeInt(eng);
			dos.writeInt(mat);
			dos.writeInt(tot);
			dos.writeDouble(avg);
			dos.writeBoolean(gender);
			dos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END");
		

	} // main

}
