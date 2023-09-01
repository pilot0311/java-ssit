package days14;

/**
 * @author pilot
 * @date 2023. 8. 1. - 오후 3:45:07
 * @subject 초기화 블럭
 * @content 인스턴스 초기화 블럭 클래스 초기화 블럭
 */
public class Ex10_03 {

	public static void main(String[] args) {
//		System.out.println(Member.rate);
//		Member m1 = new Member();
//		System.out.println(m1.name);
//		System.out.println(m1.count);
//		
//		Member m2 = new Member();
		
		//	초기화 되는 순서
		//	1)명시적 초기화
		//	2)클래스 초기화(객체 생성될 때 1번 초기화) 
		//	3)인스턴스 초기화(객체 생성될 때 마다 초기화)
		//		ㄴ생성자 중복 초기화 블럭
		//	4)생성자 초기화(객체 생성될 때 마다 초기화)
		//System.out.println(Member.rate);
		System.out.println(Member.number);
	} // main
}

class Member {	//호출해야 메모리에 올라감
	// 필드
	// 1. 인스턴스 변수
	String name = "asq"; // 명시적 초기화
	int age = 20; // 명시적 초기화
	int count; // 명시적 초기화 x
	int serialNo; // 명시적 초기화 x
	// 2. 클래스 변수
	static double rate = 0.05; // 명시적 초기화
	static final int number = 10;
	// 클래스 초기화 블럭
	// 프로그램 시잘할 때 1번 호출
	static {
		// 일괄적으로 static 변수가 있다면 초기화 하는 데 사용
		rate = 0.08;
		System.out.println(">static 초기화 블럭 호출됨");
	}
	//인스턴스 초기화 블럭  오버로딩된 생성자 중에 반복되는 코딩이 있다면 사용
	{
		count++;
		serialNo = count;
		System.out.println(">인스턴스 초기화 블럭 호출됨");
	}

	public Member() {
//		count++;
//		serialNo = count;
		
		name ="무명";
		System.out.println("Member 디폴트 생성자 호출됨");
	}

	public Member(String name) {
//		count++;
//		serialNo = count;
		
		this.name = name;
		System.out.println("Member 1 생성자 호출됨");
	}
}
