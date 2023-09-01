package days14;

public class Ex04 {

	public static void main(String[] args) {
		
		// [private 필드 선언]	[시험2]
		//	1.	왜	private를 사용해서 필드 선언 했는가
		//	2.	이유
		//		1)	private 필드 + 유효한 값만을 필드가 사용.
		//		2)	필드를 읽기전용, 쓰기 전용
		Person p1 = new Person(true); //생성자를 통해서 값 할당
		System.out.println(p1.isGender());
		//p1.age= -20; //잘못된 값 필드 할당 == 이러한 행동을 막기 위해
		//	3.	private 접근 방법: getter, setter 겟셋 추가
		p1.setAge(23);
		System.out.println(p1.getAge());
		
		// 접근지정자를 사용해서 필드 은닉화
		// The field Person.name is not visible 숨겨져 있음 == 은닉화
//		p1.name = "dwsa";
//		p1.age = 20;
//		p1.gender=true;
		

	} // main
}

//The public type Person must be defined in its own file 하나의 자바파일 안에 여러개의 클래스선언 가능 하지만 그중 자바파일과 이름이 똑같은 클래스만 public으로 선언 가능
//다른 패키지에서는 사용할 클래스 x
// class Person{
//	
//}