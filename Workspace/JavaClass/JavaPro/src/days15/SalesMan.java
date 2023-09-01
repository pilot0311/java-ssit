package days15;

//영업직 사원(마지막) 클래스
// final class : 자식 클래스를 가질 수 없는 최종 클래스
public final class SalesMan extends Regular {

	// 필드 - Employee필드(name,addr,tel,hiredate) + Regular 필드(basePay)
	private int sales; // 판매량
	private int comm; // 커미션

	// 생성자 상속x
	public SalesMan() {
		super();
		System.out.println("SalesMan 디폴트 생성자 호출됨");
	}

	public SalesMan(String name, String addr, String tell, String hiredate, int basePay, int sales, int comm) {
		super(name, addr, tell, hiredate, basePay);
		this.sales = sales;
		this.comm = comm;
		System.out.println("SalesMan 7 생성자 호출됨");

	}

	// 메서드 Employee메서드 + Regular 메서드: @dispEmpInfo(), @toString(), getPay()
	@Override
	public void dispEmpInfo() {
		System.out.printf("사원명: %s, 주소: %s, 연락처: %s, 입사일자: %s, 기본급: %d, 판매량: %d, 커미션: %d\n", this.getName(),
				this.getAddr(), this.getTell(), this.getHiredate(), this.getBasePay(), this.sales, this.comm);
	}

	@Override
	public int getPay() {
		return super.getPay()+this.sales*this.comm;
	}
}

//The type Child cannot subclass the final class SalesMan : final로 선언한 SalesMan은 자식클래스를 가질 수 없다
//class Child extends SalesMan{
//	
//}