package days15;

//[시험]
public class Ex08 {

	public static void main(String[] args) {
//		[1]
//		Employee emp1 = new Employee("dwsa", "서울 강남구", "010-1234-1234", "2022.12.12");
//		emp1.dispEmpInfo();
//		//Object.toString() -> Overriding
//		//									object
//		System.out.println(emp1.toString());
//		System.out.println(emp1);	//toString() 생략

		// is - a 관계(상속)
		// 정규직은 사원이다 o

//		[2]
		//Regular emp2 = new Regular("qwe", "강원도", "010-1352-5235", "2020.12.22", 4000000);
//		//문제점 : 기본급 출력 안됨
//	emp2.dispEmpInfo();
//		System.out.println(emp2.toString());
//		System.out.println(emp2);

//		[3]
		// [상속] 관계여야 가능
		// Employee = Regular 클래스들간의 자동형변환
		// 부모클래스 emp2 = new 자식클래스 : 가능
		// 자식객체를 생성해 부모객체에 참조
		// 업캐스팅 (upcasting)
		// Employee 클래스의 dispEmpInfo()가 아닌 실제 생성된 Regular 객체의 dispEmpInfo() 메서드 호출
		// Employee emp2 = new Regular("qwe", "강원도", "010-1352-5235", "2020.12.22",
		// 4000000);
		// emp2.dispEmpInfo();
		// [업캐스팅 - 문제점]
		// emp2.getPay(); //getPay()호출 안됨

		// 다운 캐스팅(downcasting) 부모객체가 자식객체에 참조 강제형변환
		// Regular emp = (Regular) emp2;
		// 조건: 업캐스팅 한객체만 다운 캐스팅 가능
		// emp.dispEmpInfo();

		// Type mismatch: cannot convert from Employee to Regular
		// 캐스트 연산자 클래스간의 형변환 에도 사용
		// java.lang.ClassCastException 업캐스팅안한 객체 다운캐스팅 불가능
		// Regular emp3 = (Regular) new Employee("dwsa", "서울 강남구", "010-1234-1234",
		// "2022.12.12");

//		[4]	SalesMan, Regular, Employee
		//Employee emp3 = new SalesMan("임경재", "경기도 성남시", "010-6443-4554", "2021.03.12", 500000, 20, 70000);
		//emp3.dispEmpInfo();
		//System.out.println(emp3.getPay()); //호출 안됨
		
//		[5]
		Employee emp4 = new Temp("azcs", "seoul", "010-3562-5327", "2020.2.5", 20, 250000);
		emp4.dispEmpInfo();
		System.out.println(emp4.getPay()); //호출안됨

	} // main
}
