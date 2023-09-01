package days26;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * @author pilot
 * @date 2023. 8. 18. - 오전 10:29:56
 * @subject		PrintStream 클래스
 * @content		- 데이터를 기반 출력용 바이트 스트림
 * 						- 다양한 형태로 출력할 수 있는 메서드가 오버로딩 되어져있는 스트림 클래스
 * 						
 */
public class Ex04 {

	public static void main(String[] args) {
		
		InputStream is = System.in;
		PrintStream ps = System.out; //표준 출력 스트림
		
		//ps.printXXX();
		
		System.out.println("A");
		System.out.println("B");
		System.out.println("C");
		System.out.println("D");
		System.out.println("E");
		
		System.err.println("F");
		
		
		
	} // main
	
}
