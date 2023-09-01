package days19;
// 대, 소 + 0~9
import java.io.FileReader;
import java.util.Arrays;

public class Ex09_02 {
	
	public static void main(String[] args) {
		
		String path = ".\\src\\days19\\Ex01.java";		
		int[][] counts = new int[3][];		//가변배열 선언
		counts[0] = new int [26];
		counts[1] = new int [26];
		counts[2] = new int [10];
		
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
				else if(Character.isDigit(one))
					counts[2][one-'0']++;
			}
			
			//막대 그래프
			for (int i = 0; i < counts.length; i++) {
				
				System.out.printf("[%s]문자\n",i==0?"대":i==1?"소":"숫자");
				
				for (int j = 0; j < counts[i].length; j++) {
					if(i==2)System.out.printf("%d(%d): %s\n",j,counts[i][j],"#".repeat(counts[i][j]));
					else
					System.out.printf("%c(%d): %s\n",i==0?j+'A':j+'a',counts[i][j],"#".repeat(counts[i][j]));
					
				} // for
			} // for
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	} // main

}
