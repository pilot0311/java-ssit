package days14;

public class Ex09 {
	
	//static main()메서드 = 객체생성 안하고 바로 실행 하기 위해서
	public static void main(String[] args) {
		//Ex09 obj = new Ex09();
		//obj.sum(1, 2);
		
		//static을 붙였다면
		//클래스명.static메서드명();
		//Ex09.sum(1, 2);
		//같은 클래스 내에 있기에 클래스명 생략가능
		sum(1, 2);
		
		
	} // main
	
	public static int sum(int a, int b) {
		return a+b;
	}
}
