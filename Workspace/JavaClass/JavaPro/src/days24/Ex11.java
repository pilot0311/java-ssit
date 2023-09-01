package days24;
/*
import java.util.ArrayList;

public class Ex11 {

	public static void main(String[] args) {
		// [ 제한된 제네릭 클래스 ]
		// T 모든 타입이 아니라 과일 타입만 제한해서 제네릭 클래스를 사용

		FruitBox<Fruit> box1 = new FruitBox<>();
		FruitBox<Apple> box2 = new FruitBox<>();
		FruitBox<Grape> box3 = new FruitBox<>();
		
		//과일만 가능 Toy는안되게
		//Bound mismatch: The type Toy is not a valid substitute for the bounded parameter <T extends Fruit> of the type FruitBox<T>
		//FruitBox<Toy> box4 = new FruitBox<>();	//에외 발생
		
	} // main

}

interface Eatable {
}

class Fruit implements Eatable {
	public String toString() {
		return "Fruit";
	}
}

class Apple extends Fruit {
	public String toString() {
		return "Apple";
	}
}

class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
}

class Toy {
	public String toString() {
		return "Toy";
	}
}

//Box04 제네릭 클래스 선언
class Box04<T> {
	ArrayList<T> list = new ArrayList<T>(); // {1,2,3}

	void add(T item) {
		this.list.add(item);
	}

	int size() {
		return this.list.size();
	}

	T get(int i) {
		return this.get(i);
	}

	public String toString() {
		return this.list.toString();
	}
}
//과일만을 담을 수 있는 제네릭 클래스로 제한해서 선언
//class FruitBox<T extends Fruit> extends Box04<T>{
//Fruit클래스의 자식클래스이고 Eatable 인터페이스도 구현한 클래스만을 타입변수로 사용
//	& 기호 연결
class FruitBox<T extends Fruit & Eatable> extends Box04<T>{	
	//	필드
	//	재정의 함수
}
*/