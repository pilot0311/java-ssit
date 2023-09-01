package days22;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import days21.Student;

public class Ex05_03 {
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		Person3 p;
		String name;
		int age;
		
		list.add(new Person3("이상문", 23));
		list.add(new Person3("임경재", 24));
		list.add(new Person3("신기범", 21));
		list.add(new Person3("김우태", 23));
		list.add(new Person3("홍길동", 25));
		
		
		//[3]
		list.sort(null);
		
		
		Iterator ir = list.iterator();
		while (ir.hasNext()) {
			Person3 a = (Person3) ir.next();
			System.out.println(a);
		}
		
		
		
	} // main
	
}

//비교 기능이 있는 클래스
class Person3 implements Comparable{
	private String name;
	 private int age;
	 
	public Person3() {
		super();
	}
	
	public Person3(String name, int age) {
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
	//이름을 기준으로 Person객체는 기본정렬
	@Override
	public int compareTo(Object o) {
		Person3 p = (Person3)o;
		return this.getName().compareTo(p.getName());
	}
	
	 
}


/*
 * 이름, 나이 필드를 가진 Person 클래스를 선언하고 ArrayList 컬렉션 클래스에 Person 객체를 요소로 추가하고 이름으로
 * 오름차순 정렬해서 출력하는 코딩을 하세요 ..
 */