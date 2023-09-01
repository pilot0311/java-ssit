package days18;

public class Ex03 {

	public static void main(String[] args) {
		// [Object 클래스] + 메서드
		// 모든 클래스의 최상위 부모클래스
		// 필드 X
		//메서드 11개 존재
		Item item1 = new Item(10);
		Item item2 = new Item(10);
		
		item1.equals(item2);
		System.out.println(item1.equals(item2));
		
		Item item3 = item1;
		System.out.println(item1.equals(item3));
		
		// Object.equals() Boolean형 동일한 객체 즉 동일한 인스턴스 참조하는 지 true/false로 반환
	} // main
}
//모든 클래스는 extends 안해도 기본적으로 object클래스 상속받음
class Item extends Object{
	int value;
	
	 Item(int value) {
		this.value = value;
	}
	
}