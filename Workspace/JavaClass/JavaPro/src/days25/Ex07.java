package days25;

import java.io.File;
import java.io.FileReader;

public class Ex07 {

	public static void main(String[] args) {
		// 상대경로
		// String parent = ".\\src\\25\\Ex01.java";
		// String child = "Ex01.java";
		// File f = new File(parent, child);

		String pathname = ".\\src\\days25\\Ex01.java";
		// File 클래스 : 파일, 폴더(디렉토리)를 다루는 클래스
		// 다루다? : 생성,이름변경, 삭제, 정보 얻어오기 등등
		File file = new File(pathname);
		
		//파일 크기
		System.out.println(file.isDirectory());	//false	폴더면 true
		System.out.println(file.isFile());			//true	파일이면 true
		
		//System.out.println(f.length());		
		long fileLength = file.length();		//3296 파일크기 단위= 바이트		반환타입 = long
		System.out.printf(">파일 크기 : %d(bytes)\n",fileLength);
		
		try(FileReader fr = new FileReader(file)) {
			/*
			fr.read();
			fr.read(char[] cbuf);
			fr.read(CharBuffer target);
			fr.read(char[] cbuf, int offset, int length);
			*/
			int code; 
			//	라인 단위로 처리하는 보조 스트림 사용하면 라인번호 앞에 붙일때 코딩이 더 편해진다
			while ((code = fr.read()) != -1) {
				System.out.printf("%c",(char)code);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main

}
