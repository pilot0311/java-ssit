package days23;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ex03 {

	public static void main(String[] args) {
		//	Set	:	LinkedHashSet 컬렉션 클래스
		//	ㄴ	중복허용x 순서 유지x		LinkedHashSet: 순서 유지o
		//List<Person> list = new ArrayList<Person>();
		// 주민등록 번호가 같은면 같은 객체 중복x
		Set<Person> s = new LinkedHashSet<Person>();
		s.add(new Person("111111-1111111", "김호영", 23));
		s.add(new Person("222222-2222222", "박민석", 25));
		s.add(new Person("333333-3333333", "박정호", 28));
		
		System.out.println(s.size());		//3
		
		s.add(new Person("222222-2222222", "박민석", 35));
		
		Iterator<Person> ir = s.iterator();
		while (ir.hasNext()) {
			Person p = ir.next();
			System.out.println(p);
		}
		
	} // main
	
}

class Person{
	
	String rrn;
	String name;
	int age;
		
	public Person() {
		super();
	}

	public Person(String rrn, String name, int age) {
		super();
		this.rrn = rrn;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [rrn=" + rrn + ", name=" + name + ", age=" + age + "]";
	}
	
	//hashcode() rrn   오버라이딩
	//equals()	 	 rrn	오버라이딩
	@Override
	public int hashCode() {		
		return this.rrn.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person)obj;
			return this.rrn.equals(p.rrn);
		} //if
		return false;
	}
		
}