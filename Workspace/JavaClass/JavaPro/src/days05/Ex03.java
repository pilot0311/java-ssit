package days05;

import java.io.IOException;
import java.util.Scanner;

public class Ex03 {
	
	public static void main(String[] args) throws IOException {
		
		//[문제]한라인에 10 개 씩 출력
		//[문제]라인앞에  라인번호 출력
		//ASCII 256가지
		// 개행 '\n' = LineFeed(LF) 새줄이동
		// 개행 '\r' = CarrageReturn(CR)
		// 엔터 = 개행 = '\n\r'
		//for문으로 소문자 대문자 만 출력
		for (int i = 0, lineNumber = 1; i < 256; i++) {
			//System.out.printf("%d - %c\n",i,(char)i);
			if(i%10==0) {
				System.out.printf("%d:",lineNumber++);
			}
			System.out.printf("[%c]",(char)i);
			if(i%10==9) {
				System.out.println();
			//	System.out.printf("%d",(i+1)/10);
			//	System.in.read();
			String stop;
			Scanner sc = new Scanner(System.in);
			stop = sc.nextLine();
			}
		} // for
		
	} // main
}
