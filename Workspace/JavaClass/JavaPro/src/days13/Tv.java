package days13;

//클래스 이름의 첫글자는 대문자
//Tv 클래스 선언
public class Tv {
	//중첩 클래스
	
	
	
//llegal modifier for the class Tv; only public, abstract & final are permitted
//private class Tv {
	//	멤버
	//	멤버변수(필드)
	//	초기화 하지 않으면 각 자료형의 기본값으로 초기화 되어져 있다
	//선언 형식:	[접근지정자][기타제어자]자료형 필드명[=초기화];
	//초기화 안해도 기본값으로 되있음
	//public String color = null;
	//public boolean power = false;
	//public int channel = 0;
	
	public String color;
	public boolean power;
	public int channel;
	
	//	멤버함수(메서드)
	public void power() {
		power = !power;
	}
	public void channelUp() {
		channel++;
	}
	public void channelDown() {
		channel--;
	}
}
