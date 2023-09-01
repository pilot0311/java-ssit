package days15;

public class Ex09 {

	public static void main(String[] args) {

		// 1) 문제점
		// E e1 = new R(); 업캐스팅
		// E e1 = new S(); 업캐스팅
		// E e1 = new T(); 업캐스팅
		// e1.getPay(); 안됨 Employee안에 getPay함수 없기 때문
		// 왜? Employee 클래스안에 getPay() 메서드 선언 안했는가
		// => E + getPay()

		// 추상 클래스, 메서드
		// 학생 관리 : 초, 중, 고, 대
		// 추상클래스 학생클래스 : 공통적으로 있는 멤버

		// [다형성] - 여러 가지 형태를 가질 수 있는 능력
		// E e1 = new R();
		// E e1 = new S();
		// E e1 = new T

		// Cannot instantiate the type Employee == Employee타입 인스턴스화 불가
		// 불완전한 클래스이기 때문 == 추상클래
		// Employee emp1 = new Employee("dwsa", "서울 강남구", "010-1234-1234",
		// "2022.12.12");();

//		Regular emp1 = new Regular("qwe", "강원도", "010-1352-5235", "2020.12.22", 4000000);
//		SalesMan emp2 = new SalesMan("임경재", "경기도 성남시", "010-6443-4554", "2021.03.12", 500000, 20, 70000);
//		Temp emp3 = new Temp("azcs", "seoul", "010-3562-5327", "2020.2.5", 20, 250000);
//		emp1.getPay();
//		emp2.getPay();
//		emp3.getPay();

//		Employee[] emps = new Employee[3];
//		emps[0] = new Regular("qwe", "강원도", "010-1352-5235", "2020.12.22", 4000000);	//업캐스팅 (자동형변환)
//		emps[1]=new SalesMan("임경재", "경기도 성남시", "010-6443-4554", "2021.03.12", 500000, 20, 70000);	//업캐스팅 (자동형변환)
//		emps[2]=new Temp("azcs", "seoul", "010-3562-5327", "2020.2.5", 20, 250000);	//업캐스팅 (자동형변환)
		
		Employee[] emps = {
										new Regular("qwe", "강원도", "010-1352-5235", "2020.12.22", 4000000),
										new SalesMan("임경재", "경기도 성남시", "010-6443-4554", "2021.03.12", 500000, 20, 70000),
										new Temp("azcs", "seoul", "010-3562-5327", "2020.2.5", 20, 250000)
									};
	
		dispGetPay(emps);
	} // main
	
	//사원 급여 출력메서드
	public static void dispGetPay(Employee[] emps) {
		for (int i = 0; i < emps.length; i++) {
			System.out.println(emps[i].getPay());
		} // for
	}
}
