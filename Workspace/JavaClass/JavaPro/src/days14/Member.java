//package days14;
//
////회원(멤버)클래스
//public class Member {	//호출해야 메모리에 올라감
//	// 필드
//	// 1. 인스턴스 변수
//	String name = "asq"; // 명시적 초기화
//	int age = 20; // 명시적 초기화
//	int count; // 명시적 초기화 x
//	int serialNo; // 명시적 초기화 x
//	// 2. 클래스 변수
//	static double rate = 0.05; // 명시적 초기화
//	static final int NUMBER = 10;
//	// 클래스 초기화 블럭
//	// 프로그램 시잘할 때 1번 호출
//	static {
//		// 일괄적으로 static 변수가 있다면 초기화 하는 데 사용
//		rate = 0.08;
//		System.out.println(">static 초기화 블럭 호출됨");
//	}
//	//인스턴스 초기화 블럭  오버로딩된 생성자 중에 반복되는 코딩이 있다면 사용
//	{
//		count++;
//		serialNo = count;
//		System.out.println(">인스턴스 초기화 블럭 호출됨");
//	}
//
//	public Member() {
////		count++;
////		serialNo = count;
//		
//		name ="무명";
//		System.out.println("Member 디폴트 생성자 호출됨");
//	}
//
//	public Member(String name) {
////		count++;
////		serialNo = count;
//		
//		this.name = name;
//		System.out.println("Member 1 생성자 호출됨");
//	}
//}
