package days19;

import java.io.FileReader;
import java.util.Arrays;

public class Ex09 {
	
	public static void main(String[] args) {
		//days19.Ex01.java 파일을 읽어 와서 
		// 알파벳 대수문자 구분 x a-z 갯수
		//배열에 저장 후 ### 막대 그래프 작성
		//상대 경로 . (현재디렉토리)== 프로젝트명 == ~~\javapro
		//			  ..(상위디렉토리)
		String path = ".\\src\\days19\\Ex01.java";		// . 현재 디렉토리 = javapro  상대경로
		int[] counts = new int[26];
		//counts[0]= 'a','A'
		try(FileReader fr = new FileReader(path)) {
			int code;
			char one;
			while ((code = fr.read()) != -1) {
				//System.out.println(code);
				
				one = (char)code;
				one = Character.toUpperCase(one);
				if(Character.isUpperCase(one))
				counts[one-'A']++;
			}
			
			//막대 그래프
			for (int i = 0; i < counts.length; i++) {
				System.out.printf("%c(%d): %s\n",i+'A',counts[i],"#".repeat(counts[i]));
			} // for
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	} // main

}
