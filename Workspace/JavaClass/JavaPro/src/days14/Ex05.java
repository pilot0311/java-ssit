package days14;

/**
 * @author kenik
 * @date 2023. 8. 1. - 오전 11:38:31
 * @subject [시험3]
 * @content [this 키워드] 설명 1. 정의 : 객체 자기 자신의 주소값을 가지는 참조변수 2. this 3가지 용도 
 * 			1) 멤버를
 *          가리킬 때의 this 예) this.필드명 this.메서드명 this.name Point(int x, int y)
 *          this.x = x; this.y = y;
 * 
 *          2) 생성자에서 또 다른 생성자를 호출할 때의 this 3) 단독으로 사용될 때의 this : 리턴값, 매개변수
 */
public class Ex05 {

	public static void main(String[] args) {

		// Person p = new Person();
		// p 변수, [참조변수], 객체명
		// [name][age][gender][getter].. -> [0x100]
		// 0x100 											p

		// The assignment to variable x has no effect
//		Point p1 = new Point(1, 2);
//		p1.printPoint();
//		
//		Point p2 = new Point(100, 200);
//		p2.printPoint();

		// The constructor Point(int) is undefined
//		Point p3 = new Point();
//		p3.printPoint();

		Point p4 = new Point(10, 20);
//		p4.offsetPoint(100);
//		p4.printPoint();

		p4.offsetPoint(100).printPoint();

	} // main

} // class
