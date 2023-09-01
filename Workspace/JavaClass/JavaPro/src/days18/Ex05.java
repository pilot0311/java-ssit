package days18;

public class Ex05 {

	public static void main(String[] args) {
		//Object.equals()
		//Object.hashCode()
		//Object.toString()
		//Object.GetClass() - 객체의 클래스 정보를 담고 있는 Class 인스턴스 반환하는 메서드
		Person p1 = new Person("111", "qwe");
		Class cls =  p1.getClass();
		
		System.out.println(cls.getName());	//days18.Person
		System.out.println(cls.getSimpleName());	//Person
	} // main
}
