package days24;

public class Ex09 {

	public static void main(String[] args) {
		//	[제네릭스의 제한]
		
		
		
	} // main
	
}

class Box02<T>{
	//Cannot make a static reference to the non-static type T	
	//static T item2;	//	1) 제네릭 클래스에서는 T타입 정적 필드 선언 X
	
	//Cannot make a static reference to the non-static type T
//	static int compare(T t1, T t2) {	//	2) static 메서드의 매개변수로 T타입 사용 X
//		return 0;
//	}
	
	//	3)	T타입의 배열은 선언할 수 있다
	T[] itemArr;
	
}