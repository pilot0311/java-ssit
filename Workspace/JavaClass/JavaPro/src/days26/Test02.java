package days26;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test02 {
	//days26 폴더 안에 있는 모든 파일 찾아서 keyword = "fileName" 검색후 파일명 라인번호 출력
			//[주말]
			//javaPro 폴더 및 모든 하위 폴더 안에 있는 파일에서 찾기	
	
	public static void main(String[] args) {
		String pathname = ".\\src";
		String keyword = "fileName";
		File file = new File(pathname);
		findKeyword(file,keyword);
		
		
	} // main

	private static void findKeyword(File file, String keyword) {
		File[] list = file.listFiles();
		File f = null;
		String line = null;
		int lineNumber = 1;
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				findKeyword(list[i],keyword);
			} else {
				lineNumber = 1;
				f = list[i];
				String fileName = f.getName();
				String filepath = f.getPath();
				//System.out.printf("--------%s----------\n",filepath);
				try(FileReader in = new FileReader(f); BufferedReader br = new BufferedReader(in)) {
					while ((line = br.readLine()) != null) {
						if (line.contains(keyword)) {
							System.out.printf("--------%s----------\n",filepath);
							line = line.replaceAll(keyword, "["+keyword+"]");
							System.out.printf("%d : %s\n",lineNumber,line);
						} //if
						lineNumber++;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // for
	}
}
