package days15;

//[정규직]
public class Regular extends Employee {
	// Object 멤버들도 상속
	// [Employee]
	// 필드 - 상속 name, addr, tel, hiredate
	private int basePay; // 기본금
	// 생성자 x 상속 안됨

	public Regular() {
		//super();
		System.out.println("Regular 디폴트 생성자 호출");
	}

	public Regular(String name, String addr, String tell, String hiredate, int basePay) {
		// The field Employee.name is not visible = 접근 지정자 private
		// this.name = name; x
		// this.setName(name); o
		super(name, addr, tell, hiredate); // 부모의 생성자 호출
		this.basePay = basePay;
		System.out.println("Regular 5 생성자 호출");
	}

	

	// getter, setter
	public int getBasePay() {
		return basePay;
	}

	public void setBasePay(int basePay) {
		this.basePay = basePay;
	}
	
	// 메서드 - 상속 dispEmpInfo, @오버라이드toString()
	@Override
	public void dispEmpInfo() {
//		super.dispEmpInfo();		//보모의 멤버들을 가리킬때
//		System.out.printf(", 기본급: %d\n", this.basePay);
		System.out.printf("사원명: %s, 주소: %s, 연락처: %s, 입사일자: %s, 기본급: %d\n",this.getName(),this.getAddr(),this.getTell(),this.getHiredate(),this.basePay);
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", 기본급: %d", this.basePay);
	}
	
	public int getPay() {
		return this.basePay;
	}
	
}// class
