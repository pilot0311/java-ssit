package days16;

public class Ex01 {

	public static void main(String[] args) {
		
		
		//추상클래스에도 업캐스팅 가능
//		Parent p1 = new Child();
//		Child c1 = new Descendant();
		Parent p1 = new Descendant();
	} // main

}

//상속 계층도
//자식 클래스
//공통적인 멤버 가진 부모 클래스
//일종의 클래스
abstract class Parent{
	//필드
	//메서드
	//추상메서드
	abstract void dispA();
	abstract void dispB();
}

abstract class Child extends Parent{

	@Override
	void dispA() {
		
	}

}

class Descendant extends Child{

	@Override
	void dispB() {
	
	}
	
}

//class Child extends Parent{
//
//	@Override
//	void dispA() {
//		
//	}
//
//	@Override
//	void dispB() {
//	
//	}
//부모의 필드, 메서드 물려받음
//추상 메서드도 물려받음
//}
//The type Child must implement the inherited abstract method Parent.dispA() 물려받은 추상메서드 구현하거나 abstract클래스 하던지
//class Child extends Parent{
//	//부모의 필드, 메서드 물려받음
//	//추상 메서드도 물려받음
//	
//}