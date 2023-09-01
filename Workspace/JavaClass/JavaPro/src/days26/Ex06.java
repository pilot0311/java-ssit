package days26;

import java.io.File;
import java.io.IOException;

import com.util.FileUtil;

public class Ex06 {

	public static void main(String[] args) throws IOException {
		// [File 클래스]
		//	1.	가장 많이 사용 되는 입출력의 대상 - 파일(중요)
		//	2.	파일 + 디렉토리(폴더) 
		String pathname = ".\\src\\days26\\Ex01.java";
		//String pathname = "E:\\Class\\Workspace\\JavaClass\\JavaPro\\src\\days26\\Ex01.java";
		File file = new File(pathname); 
		//file.isDirectory();
		//file.isFile();
		//file.length();
		//file.exists();
		
		//운영체제 에서 사용하는 경로 구분자  ;
		System.out.println(file.pathSeparator);		//;
		//OS에서 사용하는 이름 구분자 	\
		System.out.println(file.separator);				//	\
		
		//파일 이름
		String fileName = file.getName();
		System.out.println(fileName);	//Ex01.java
		
		//확장자 		.java
		//확장자를 제외한 파일명  Ex01
		int pos = fileName.indexOf(".");		
		System.out.println(fileName.substring(pos));	 //확장자	
		System.out.println(fileName.substring(0, pos));		//확장자 제외한 파일명
		
		System.out.println("-".repeat(50));
		System.out.println(file.getPath());		//파일의 경로 반환   .\src\days26\Ex01.java
		System.out.println(file.getAbsolutePath());	//파일의 절대 경로   E:\Class\Workspace\JavaClass\JavaPro\.\src\days26\Ex01.java
		System.out.println(file.getCanonicalPath());	//표준 경로	E:\Class\Workspace\JavaClass\JavaPro\src\days26\Ex01.java
		
		//										파일의 부모 디렉토리
		System.out.println(file.getParent());			//".\src\days26"
		System.out.println(file.getParentFile());		//	File객체 반환
		
		//com.util.FileUtil.java
		System.out.println(FileUtil.getExtension(fileName));
		System.out.println(FileUtil.getBaseName(fileName));
		
	} // main
	
}
