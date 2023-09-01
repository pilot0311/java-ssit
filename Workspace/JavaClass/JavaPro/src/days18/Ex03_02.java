package days18;
//[시험] 어떤기능 이유 
public class Ex03_02 {

	public static void main(String[] args) {
		//주민등록 번호가 같으면 동일한 사람(객체)이다
		Person p1 = new Person("111", "dwsa");
		Person p2 = new Person("111", "dasw");
		//주민번호 만같으면 equals 사용시 true반환
		//Object -> equals() 메서드를 오버라이딩
		//System.out.println(p1.equals(p2));
		
		//Object.toString();
		//days18.Person@be11
		//패키지명.클래스명@hashCode의 16진수
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println(p1.hashCode());	//1521118594
		System.out.println(p2.hashCode());	//1940030785
	} // main
}

//Person 클래스의 객체가 복제(clone)되도록 코딩
class Person implements Cloneable{
	String rrn;
	String name;
	
	public Person(String rrn, String name) {
		super();
		this.rrn = rrn;
		this.name = name;
	}

	//							p1.equals(p2)		업캐스팅, 다형성
	@Override	//@어노테이션 설명
	public boolean equals(Object obj) {	//오버라이딩 의미 조건
		if (obj != null && obj instanceof Person) {	//이유 기능
			Person p = (Person)obj;	//다운캐스팅		
			return this.rrn.equals(p.rrn);
		} //if
		return false;
	}

	@Override
	public int hashCode() {
		
		return this.rrn.hashCode();
	}

	@Override
	public String toString() {
		//return "Person [rrn=" + rrn + ", name=" + name + "]";
		return String.format("Person [rrn= %s, name= %s]", this.rrn,this.name);
	
	}
/*
	@Override
	protected Object clone() throws CloneNotSupportedException {
		//return super.clone();
		
		Object obj = null;
		obj =  super.clone();
		return obj;
	}
*/	
	
	//오버라이딩 조건(주의사항)
	//JDK1.5	공변반환타입(convariant return type) 추가
	// - 오버라이딩 할 때 조상 메서드의 반환타입을 자식 클래스 타입으로 변경이 가능하다
	@Override
	protected Person clone()  {
		
		Person p = null;
		try {
			p = (Person) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
			
}