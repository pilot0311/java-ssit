package days24;

public class Ex04 {

	public static void main(String[] args) {
		/*
		// 중첩 클래스와 중첩 인터페이스
		//	1.	클래스와 클래스들 간의 관계
		//		has-a 관계
		//		is-a 관계(상속)
		//	2.	어떤 클래스가 특정클래스와 관계가 있다면
		//				A			B
		//		B라는 클래스 안(내부)에 A클래스 선언한다
		//	3.	중첩 클래스 (클래스 안에 클래스)(Nested Class)
		//	4.	장점
		//		1)	두 클래스의 멤버들을 서로 쉽게 접근 할 수 있다
		//		2)	불필요한 관계 클래스를 감춤으로써 코드의 복잡성을 줄 일 수 있다
		//	5.	예
		//		class A{
		//				필드
		//				메서드
		//				생성자
		//				getter, setter
		//				중첩클래스
		//			class B{
		//				}
		//				중첩 인터페이스
		//				interface IC{
		//						}
		//		}//class A
		
		//	6.	중첩 클래스의 종류 : 선언 위치에 따라 구분
		
		//		1)	클래스의 멤버 선언		접근지정자 가능
		//			(1)	인스턴스 멤버 클래스	-	A 객체를 생성해야지 B 중첩클래스를 사용 가능
		//			(2)	정적(static) 멤버 클래스	-	A클래스로 객체 생성 없이 바로 C 중첩클래스를 사용 가능
		 * 
		 * 			중첩클래스도 	A(외부)$B(내부).class파일 생성
		 * 
		//		2)	메서드의 내부에 선언		접근지정자 X
		 *			(3) 	로컬 클래스	-	메서드가 실행될 때에만 사용 할 수 있다
		 *					A(외부)$1B(로컬클래스명).class
		 *
		//		6-2)	예
		//		class A{
		//				
		//				메서드
						void disp(){
							int a; //지역(로컬)변수
						
							//로컬 클래스	접근지정자 X
							class D{
							
								static 필드, 메서드 선언 X
								
								D(){}
								int d1
								void test(){}
							}	// class D
							
							D.obj = new D();
							obj.d1;
							obj.test();
							
						} //disp
		 * 
		 * 			인스턴스 멤버 클래스		접근지정자 가능
		//			class B{		
		 * 				B(){}	생성자
		 * 				int b1; 인스턴스 필드
		 * 				void test(){}	인스턴스 메서드
		 * 
		 * 			//	static 필드 메서드 선언할 수 없다
		//				}
		//		
		 * 				예) A a = new A();			//	1. 외부 객체 먼저 생성
		 * 						A.B b = a.new B();	//	2. A.B b = a.new B();
		 * 						b.b1 =100;
		 * 						b.test();
		 * 
		 * 			정적(static) 멤버 클래스		접근지정자 가능
		//			static class c{
		 * 				//모든 필드, 메서드 선언할 수 있다
		 * 				int c1 //인스턴스 변수
		 * 				Static sc1; //static 변수
		 * 				void test1(){}	//인스턴스 메서드
		 * 				static void test2(){}	// static 인스턴스 메서드
		 * 				c(){}	//생성자
		 * 				}
		 * 
		 * 				예)	외부 객체를 생성할 필요가 없다
		 * 				A.C c = A.C();
		 * 				c.c1 = 100;
		 * 				c.test1();
		 * 				A.C.sc1 = 100;
		 * 				A.C.test2();
		 * 		}//class A	
		*/
		
	} // main
	
}
