package days22;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import days21.Student;

public class Ex05 {
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		Person p;
		String name;
		int age;
		
		list.add(new Person("이상문", 23));
		list.add(new Person("임경재", 24));
		list.add(new Person("신기범", 21));
		list.add(new Person("김우태", 23));
		list.add(new Person("홍길동", 25));
		//[1]
		list.sort(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		
		
		
		
		Iterator ir = list.iterator();
		while (ir.hasNext()) {
			Person a = (Person) ir.next();
			System.out.println(a);
		}
		
		
		
	} // main
	
}

class Person{
	private String name;
	 private int age;
	 
	public Person() {
		super();
	}
	
	public Person(String name, int age) {
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
		return " [name=" + name + ", age=" + age + "]";
	}
	
	 
}


/*
 * 이름, 나이 필드를 가진 Person 클래스를 선언하고 ArrayList 컬렉션 클래스에 Person 객체를 요소로 추가하고 이름으로
 * 오름차순 정렬해서 출력하는 코딩을 하세요 ..
 */