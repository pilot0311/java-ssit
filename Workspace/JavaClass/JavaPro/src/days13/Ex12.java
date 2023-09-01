package days13;

public class Ex12 {

	public static void main(String[] args) {
		// Ex12 클래스, Time 클래스 같은 패키지
		Time t = new Time();
		t.hour = 2;			//public
		t.minute = 20;	//default
		t.second = 59;	//protected
		
		
		// 1. 클래스 앞에 붙는 접근지정자 설명
		// 2. 멤버(필드,메서드, 생성자constructor)앞에 붙는 접근 지정자
		// public 패기지 내외부 어디서나 접근(참조) 가능
		// default 같은 패키지 내부에서만 접근(참조) 가능
		// protected == default + 상속(패키지 외부라도 상속 관계 이면 참조 가능)
		// private 같은 클래스 내에서만 접근(참조 가능)

		// 3. 범위: public > protected > default > private

		// 참고) 지역 변수는 접근지정자를 사용할 수 없다

	} // main

}
