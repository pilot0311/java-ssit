package days22_t.days22;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Ex05_02 {

	public static void main(String[] args) {
		
		ArrayList<Person2> list = new ArrayList();
		
		list.add(new Person2("박정호", 23));
		list.add(new Person2("김성준", 21));
		list.add(new Person2("주강민", 29));
		list.add(new Person2("이경서", 20));
		list.add(new Person2("신기범", 30));
		
		System.out.println( list );
		
		list.sort( (p1,p2)-> p1.getName().compareTo(p2.getName()) );
		
		// 반복자 출력
		Iterator ir = list.iterator();
		while (ir.hasNext()) {
			Person2 p = (Person2) ir.next();
			System.out.println( p );
		} // while

	} //  main

} // class

class Person2{
	
	private String name;
	private int age;
	
	public Person2() {
		super(); 
	}

	public Person2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	} 
	
} // class



