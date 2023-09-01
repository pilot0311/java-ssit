package days02;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main() 시작");
		otherMethod();
		System.out.println("main() 종료");

	}
	
	private static void otherMethod() {
		System.out.println("otherMethod() 시작");
		for(int i =1; i<=10; i++) {
			if(i==5) {
				return;
			}
		}
		System.out.println("otherMethod() 종료");
		
	}

}
