package days18;

import java.io.File;

public class Ex08_02 {

	public static void main(String[] args) {
		//암기
		String dir = System.getProperty("user.dir");	//	프로젝트 위치
		System.out.println(dir);
		String sep =  System.getProperty("file.separator");		//	"\\" = 문자열 구분하는 구분자
		String sep2 =  File.separator;
		System.out.println("구분자" + sep2);
		String directory = "C:\\temp\\days01\\";
		String fileName = "Ex01.java";
		String ww =  directory.endsWith(sep)?"":sep;
		
		String path= directory + ww + fileName;
		System.out.println(path); 	//C:\\temp\\days09\\Ex01.java
	} // main
}
