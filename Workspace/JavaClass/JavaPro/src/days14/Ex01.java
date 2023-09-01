package days14;

public class Ex01 {
	//필드
	String message;
	//디폴트 생성자 선언
//	 public  Ex01(){
//		 System.out.println("Ex01 디폴트 생성자");
//		 message = "hi";	//생성자로 필드 초기화
//	}
	
	
	public Ex01(String msg) {
		message = msg;
		System.out.println("Ex01 1 생성자");
	}
	


	public static void main(String[] args)  {
		//객체명. 필드명
		//[객체 생성 + 디폴트 생성 호출]
		//The constructor Ex01() is undefined -> 이미 선언된 생성자가 있어서 디폴트 생성자 자동 선언 안함
//		Ex01 obj = new Ex01();
//		obj.message="dwsa";
//		System.out.println(obj.message);
	
		//The constructor Ex01(String) is undefined
		//[객체생성 + 메게변수 +1]
//		Ex01 obj = new Ex01("Hello World");
//		System.out.println(obj.message);
		
		//[시험1] - 생성자(Constructor)
		//	1.	일종의 메서드 이다 (생성자메서드)
		//	2.	메서드명 == 클래스명
		//	3.	리턴자료형을 사용하지 않음(아예 안씀)
		//	4.	매개변수가 없는 생성자를 디폴트 생성자라고 한다
		//	5.	접근지정자 public, protected, default, private 사용 가능 , 기타제어자는 사용하지 않음
		//	6.	생성자는 인위적으로 호출할 수 없다
		//			객체명.생성자메서드()호출 할수 없다
		//		호출 시기: 객체 생성할 떄 자동으로 호출된다
		//	예)	new Ex01(); ->  ()의 의미: 내부적으로 생성자 호출
		//	7.	생성자 역활: 객체 생성할 때 -> 생성자 호출 -> 필드 초기화
		//	8.	생성자는 오버로딩 가능(중복 선언)
		//	9.	클래스 선언 시 생성자를 1개라도 선언하지 않으면 컴파일러가 자동으로 디폴트 생성자를 추가 후 컴파일
		//	10.	디폴트 생성자를 선언하지 않고 생성자를 오버로딩할때 주의
		//	11.	생성자는 상속되지 않는다
	} // main
}
