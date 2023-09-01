package days14;

public class Test {

	public static void main(String[] args) {
		System.out.println(Member1.NUMBER);
		System.out.println(Member1.age);
		
	} // main
}
final class Member1 {	//호출해야 메모리에 올라감
	static int age = 10;
	static double rate = 0.05; 
	static final int NUMBER = 10;
	
	static {	
		rate = 0.08;
		System.out.println(">static 초기화 블럭 호출됨");
		
		
			
		
	}
}