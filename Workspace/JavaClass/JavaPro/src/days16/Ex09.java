package days16;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
import java.util.Vector;

public class Ex09 {
	
	public static void main(String[] args) {
		//	인터페이스의 장점
		//	1.	개발 시간을 단축시킬 수 있다
		//		인터페이스 작성 + 사용하는 곳 => 개발 진행
		//		인터페이스를 구현한 클래스 x =>=> 개발 진행
		//		예) has - a관계 Car, Engine
		// Car클래스 코딩~~
		//		ㄴ Engine 클래스 구현 xx
		//	Engine 인터페이스 구현 클래스 - H_Engine, k_Engine
		
		//인터페이스 매개변수 다형성
		//Engine engine = new H_Engine();
		//Engine engine = new K_Engine2();
		//Car mycar = new Car(engine);
		
		//	2.	표준화가 가능하다
		//		Engine 인터페이스 구현해서 클래스를 만들었다면 표준화 되어져 있을 것
		
		//	3.	서로 상속관계 관련이 없는 클래스들에게 인터페이스로 관계를 맺어 줄 수 있다
		//		상속관계X (부모,자식 관계x)
		
		//public class ArrayList<E> extends AbstractList<E>
        //implements List<E>, RandomAccess, Cloneable, java.io.Serializable
		//List l = new ArrayList();
		
		//public class Vector<E> extends xxxx<E>
	    //implements List<E>, RandomAccess, Cloneable, java.io.Serializable
		//List v = new Vector();
		// ArryList와 Vector의 부모가 서로 다르지만 둘다 같은 List인터페이스를 구현 했다
		//test03(l);
		//test03(v);
		
		//	4.	독립적인 프로그래밍이 가능하다.
		//		선언 + 구현
		
	} // main
	
	public static void test03(List l) {
		
	}
}
