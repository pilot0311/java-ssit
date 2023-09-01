package days24;

/**
 * @author pilot
 * @date 2023. 8. 16. - 오후 3:06:25
 * @subject		제네릭 타입
 * @content			1) 제네릭 클래스
 * 							2)	제네릭 메서드
 */
public class Ex08 {

	public static void main(String[] args) {
		//	[ 제네릭 클래스 ]
		//Box box1 = new Box();
		//box1.setItem(100);
		//box1.setItem("홍길동");
		//box1.setItem(3.14);
		
		
		//형변환 사용
		//System.out.println((int)box1.getItem());
		//System.out.println((String)box1.getItem());
		
		//			String 대입된 타입
		//Box<String> box = new Box<>();
		
		// 자동 호환
		//Box box = new Box();
		//box.item = "XXXX";
		
	} // main
	
}

//	다양한 타입을 사용하기 위해 컴파일 시에 타입을 결정하는 기능 : 제네릭
//	[제네릭 클래스 선언]
//	<Type> T,K,V,E 등등
//	용어
//		1)	Box - 원시타입 (raw type)
//		2)	<T>	- 타입 변수 또는 타입 매개변수
//		3)	Box<T> - 제네릭 클래스, 'T의 Box'
class Box<T>{
	T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}

/*
class Box{
	Object item;

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}
}
*/

/*
class Box{
	double item;

	public double getItem() {
		return item;
	}

	public void setItem(double item) {
		this.item = item;
	}
}
*/

/*
class Box{
	String item;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
}
*/

/*
class Box{
	int item;

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}
}
*/