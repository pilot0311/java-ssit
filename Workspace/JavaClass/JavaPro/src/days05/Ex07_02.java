package days05;

public class Ex07_02 {

	public static void main(String[] args) {
		int i =10;
		while (i<2) {
			//거짓이기에 한번도 실행하지 않음
			System.out.println("b");
		}
		
		do {
			System.out.println("b");
		} while (i<2);	// 무조건 1번 실행후 조건식 참/거짓에 따라 반복 실행
	} // main
}
