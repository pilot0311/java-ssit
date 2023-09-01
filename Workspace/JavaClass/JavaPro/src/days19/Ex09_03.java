package days19;

import java.io.FileReader;
import java.util.Arrays;

public class Ex09_03 {
	
	public static void main(String[] args) {
		
		String path = ".\\src\\days19\\Ex01.java";		
		int[][] counts = new int[2][26];
		//0행 대문자 1행 소문자
		try(FileReader fr = new FileReader(path)) {
			int code;
			char one;
			while ((code = fr.read()) != -1) {
				//System.out.println(code);
				one = (char)code;
				if(Character.isUpperCase(one))
				counts[0][one-'A']++;
				else if(Character.isLowerCase(one))
					counts[1][one-'a']++;
			}
			
			//막대 그래프
			for (int i = 0; i < counts.length; i++) {
				System.out.printf("[%c]문자\n",i==0?'대':'소');
				for (int j = 0; j < counts[i].length; j++) {
					System.out.printf("%c(%d): %s\n",i==0?j+'A':j+'a',counts[i][j],"#".repeat(counts[i][j]));
				} // for
			} // for
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	} // main

}
