package days15;


//[사원 클래스]
// 모든 사원들이 공통적으로 가져야할 멤버(필드,메서드)를 구현한 클래스
//추상메서드가 한개라도 있으면 불완전한 그 클래스도 불완전한 클래스이고, 객체를 생성핳 수 없다 = 추상 클래스
public abstract class Employee {
	//필드
	private String name;	//사원명
	private String addr;		//사원 주소
	private String tell;		//연락처
	private String hiredate; //입사일자
	
	//생성자
	public Employee() {
		System.out.println("Employee 디폴트 생성자 호출");
	}
	public Employee(String name, String addr, String tell, String hiredate) {
		this.name = name;
		this.addr = addr;
		this.tell = tell;
		this.hiredate = hiredate;
		System.out.println("Employee 4 생성자 호출");
	}
	
	//getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	//	메서드
	//	사원들의 정보를 출력하는 메서드
	public void dispEmpInfo() {
		System.out.printf("사원명: %s, 주소: %s, 연락처: %s, 입사일자: %s\n",this.name,this.addr,this.tell,this.hiredate);
	}
	@Override
	public String toString() {
		
		return String.format("사원명: %s, 주소: %s, 연락처: %s, 입사일자: %s",this.name,this.addr,this.tell,this.hiredate);
	}
	
//	public int getPay() {
//		return 0;
//	}
	
	//This method requires a body instead of a semicolon  이 메서드는 몸체가 필요하다 
	//body{} 몸체가 구현이 안된 불완전한 메서드
	// 추상메서드
	// abstract 키워드 붙인다
	//추상메서드가 한개라도 있으면 불완전한 그 클래스도 불완전한 클래스이고, 객체를 생성핳 수 없다 = 추상 클래스
	public abstract int getPay();
	
}
