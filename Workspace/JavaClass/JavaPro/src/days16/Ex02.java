package days16;

import days15.Employee;
import days15.Regular;
import days15.SalesMan;
import days15.Temp;

public class Ex02 {

	public static void main(String[] args) {
		
		Regular emp1 = new Regular();
		dispGetPay(emp1);
		//SalesMan emp2 = new SalesMan();
		//dispGetPay(emp2);
		//Temp emp3 = new Temp();
		//dispGetPay(emp3);
	} // main
	
	//인스턴스 메서드 - 클래스 메서드
	// if ~ else 구문 확인
	// 자식 클래스 먼저 체크
	public static void dispGetPay(Employee emp) {
		// 인스턴스 확인할 수 있는 연산자 : instanceof
		if (emp instanceof SalesMan) {
			System.out.println("> 현재 emp객체는 SalesMan타입이다");
			SalesMan s1 =(SalesMan)emp;
		} //if
		else if (emp instanceof Regular) {
			System.out.println("> 현재 emp객체는 Regular타입이다");
		} //if
		else if (emp instanceof Temp) {
			System.out.println("> 현재 emp객체는 Temp타입이다");
		} //if
	}
}
