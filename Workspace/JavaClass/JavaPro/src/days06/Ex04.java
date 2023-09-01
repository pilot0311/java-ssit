package days06;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Ex04 {
	
	public static void main(String[] args) throws IOException {
		String name;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("이름 입력:");
			name = sc.nextLine();
			//System.out.println(name);
			//[1]
//			char[] nameArr = new char[name.length()];
//			for (int i = 0; i < nameArr.length; i++) {
//				nameArr[i]=name.charAt(i);
//
//			} // for
//			System.out.println(Arrays.toString(nameArr));
			//1) String => char[] 변환
			char[] nameArr=name.toCharArray();
			
			//2) char[] -> String 변환
			name=String.valueOf(nameArr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
}
