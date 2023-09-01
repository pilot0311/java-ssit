package days18;
//시험?
import java.util.Scanner;

public class Ex09_04 {

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);	
		//int n = sc.nextInt();
		System.out.println(solution(5));
	} // main
	
	//[1]
//	private static String solution(int n) {
//		StringBuilder sb = new StringBuilder("");
//		for (int i = 0; i < n; i++) {
//			if(i%2==0) sb.append("수");
//			else sb.append("박");
//		} // for
//		return sb.toString();
//	}
	//[2]
//	private static String solution(int n) {
//		StringBuilder sb = new StringBuilder("");
//		boolean sw = true;
//		for (int i = 0; i < n; i++) {
//			if(sw) sb.append("수");
//			else sb.append("박");
//			
//			sw=!sw;
//		} // for
//		return sb.toString();
//	}
	//[3]
	private static String solution(int n) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < n/2; i++) {
			sb.append("수박");
		} // for
		
		if(n%2==1) sb.append("수");
		return sb.toString();
	}
}


/*
문제 설명
길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.

제한 조건
n은 길이 10,000이하인 자연수입니다.
입출력 예
n   return
3   "수박수"
4   "수박수박"
*/