package days15;

//임시직 사원 클래스
public class Temp extends Employee {

	// 필드 - name, addr, tel, hiredate
	// 생성자 상속 x
	// 메서드 dispEmpInfo(), @toString()
	private int days; // 근무일수
	private int payOfDay; // 하루 일당

	public Temp() {
		super();
		System.out.println("Temp 디폴트 생성자 호출");
	}

	public Temp(String name, String addr, String tell, String hiredate, int days, int payOfDays) {
		super(name, addr, tell, hiredate);
		this.days = days;
		this.payOfDay = payOfDays;
		System.out.println("Temp 6 생성자 호출");
	}
	
	@Override
	public int getPay() {
		return this.days * this.payOfDay;
	}

	@Override
	public void dispEmpInfo() {
		System.out.printf("사원명: %s, 주소: %s, 연락처: %s, 입사일자: %s, 근무일수: %d, 하루일당: %d\n", this.getName(), this.getAddr(),
				this.getTell(), this.getHiredate(), this.days, this.payOfDay);
	}
}
