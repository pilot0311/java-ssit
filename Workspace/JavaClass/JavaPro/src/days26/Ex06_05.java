package days26;

import java.io.File;

public class Ex06_05 {

	public static void main(String[] args) {
		
		//days26 폴더 안에 upload 폴더 유무 확인후 없으면 폴더 생성...
		String pathname = ".\\src\\days26";
		File dir = new File(pathname, "upload");
		// 1.	boolean  	createNewFile(); : 파일 새로생성
		//												이미 생성할 파일 존재하면 false
		
		//	2.	File	createTempFile("파일명", "확장자명");	:	임시 파일 생성
		//				c:\\windows\\TEMP 파일 생성
		
		//	3.	boolean		delete();	:	파일삭제
		//	3-2.				delelteOnExit();		:	응용 프로그램이 종료 할 때 파일 삭제
		//																	임시파일 삭제 할때 주로 사용
		
		//	4.	boolean		renameTo(File);		:	파일명을 변경
		//	5.	boolean		mkdir();	:	폴더 생성
		//		boolean		mkdirs();	:	폴더들 생성		부모폴더 먼저 생성
		
		if ( !dir.exists()) {
			System.out.println(dir.mkdir());
			//dir.mkdirs();
		} else {
			dir.delete();
		}
	} // main
	
}
