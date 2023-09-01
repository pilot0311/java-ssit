package days18;

public class Ex06 {

	public static void main(String[] args) {
		// Object.clone() 복제

		Person p1 = new Person("111", "qwe");
		// p1.clone(); //사용X

		Person p1Clone;
		p1Clone = p1.clone();
		System.out.println(p1Clone);
		// Unhandled exception type CloneNotSupportedException == checked 예외 반드시 예외 처리
		// 필요
//		try {
//			//clone 오버라이딩 불편한점 : clone이 Object탑입 반환 (Person)으로 다운캐스팅
//			p1Clone = (Person) p1.clone();
//		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//		} 
		
//		p1.notify();	//스레드 수업
//		p1.notifyAll();		//스레드수업
//		p1.wait();		//스레드 수업
//		p1.wait(0);		//스레드 수업
//		p1.wait(0, 0);	//스레드 수업
		
		//p1.finalize(); X	 소멸자 
		
		
	} // main
}
