package days24;

import java.util.ArrayList;

public class Ex12 {

	public static void main(String[] args) {
		// [와일드 카드]

		FruitBox<Fruit> fruitBox = new FruitBox<>();
		FruitBox<Apple> AppleBox = new FruitBox<>();
		FruitBox<Grape> GrapeBox = new FruitBox<>();
		
		/*
		Juice juice = Juicer.makeJuice(fruitBox);
		juice = Juicer.makeJuice(AppleBox);
		juice = Juicer.makeJuice(GrapeBox);
		*/
		
		//makeJuice 메서드를 제네릭 메서드로 선언(수정)
		//호출방법 다르다
		Juice juice = Juicer.<Apple>makeJuice(AppleBox);
		//	<Apple> 생략 가능
		//Juice juice = Juicer.makeJuice(AppleBox);
		
		//	[제네릭 메서드]			//제네릭 클래스의 제네릭과는 별개
		//	- 메서드의 선언부에 제네릭 타입이 선언된 메서드    // 메서드 선언부 함수 프로토타입(원형)	(함수 몸체 전)
		//	형식			함수 반환 타입 앞에 <>가 오는 경우
		//	public static <T> Juice makeJuice(FruitBox<T> box)
		
	} // main

}

class Fruit {
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

//Box05 제네릭 클래스 선언
class Box05<T> {
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
class FruitBox<T extends Fruit> extends Box05<T> {
	// 구현
}

//	클래스 선언, 		제네릭 클래스X
//	매개변수를 과일박스를 주면 쥬스를 만들어서 반환하는 기능이 있는 쥬스 클래스
class Juice{}
class Juicer {
	//												?== 와일드 카드
	//static Juice makeJuice(FruitBox<? super Fruit> box)	:	Fruit 부모들만 가능
	//static Juice makeJuice(FruitBox<?> box)	:	제한 없음 모든 타입 가능
	
//	static Juice makeJuice(FruitBox<? extends Fruit> box) {	//	Fruit을 상속받은 클래스만 매개변수로 사용
//		return new Juice();
//	}
	// 위의 일반 메서드를 제네릭 메서드로 변경
	static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {	//	Fruit을 상속받은 클래스만 매개변수로 사용
		return new Juice();
	}
	
	//제네릭 타입의 매개변수는 오버로딩이 성립되지 않는다
	/*
	static Juice makeJuice(FruitBox<Fruit> box) {
		return new Juice();
	}
	
	static Juice makeJuice(FruitBox<Apple> box) {
		return new Juice();	
	}
	
	static Juice makeJuice(FruitBox<Grape> box) {
		return new Juice();
	}
	*/
}