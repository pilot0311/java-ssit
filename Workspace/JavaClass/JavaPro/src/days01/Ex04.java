package days01;

public class Ex04 {

	
	//본인의 이름을 name이라는 변수를 선언하고 본인의 나이를 age라는 변수를 선언하고 저장한 후  출력하는 코딩
	public static void main(String[] args) {

		String name;
		name = "신기범";  //지역변수 name에 값 초기화(할당)
		//The local variable name may not have been initialized == 지역변수 name 초기화 안되있음
		System.out.println(name);
		int age = 25;
		System.out.println(age);
	}//main

}//class
