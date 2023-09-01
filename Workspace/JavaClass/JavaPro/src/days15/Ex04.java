package days15;

public class Ex04 {

	public static void main(String[] args) {
		
		Point center = new Point(50, 50);
		int r = 10;
		Circle c = new Circle(center, r);

		c.color = "red";
		// shape 부모 클래스로 부터 물려받은 draw()메서드 수정
		// 재정의 함수 == 오버라이딩(OverRiding)
		// 중복 함수 == 오버로딩(OverLoading
		c.draw(); // 원점출력+색출력
		
		System.out.println("-".repeat(30));
		//클래스 배열 초기화
		Point[] p = {
						new Point(1,1),
						new Point(20,40),
						new Point(10,5)
						};
		Triangle t = new Triangle(p);
		t.draw();
		
		System.out.println("-".repeat(30));

	} // main
}

//class Circle {
//	// 원점
//	int x;
//	int y;
//	// 반지름
//	int r;
//
//	Circle() {
//	}
//
//	Circle(int x, int y, int r) {
//		this.x = x;
//		this.y = y;
//		this.r = r;
//	}
//	
//	void draw() {
//		//도형 그리기 코딩
//	}
//}

//상속
//삼각형
class Triangle extends Shape {
	Point[] p = null;

	public Triangle(Point[] p) { // 생성자를 사용한 (DI 의존성주입)
		this.p = p;
	}

	@Override
	void draw() {
		System.out.printf("[p1=%s, p2=%s, p3=%s]\n", this.p[0].getXY(), this.p[1].getXY(), this.p[2].getXY());
	}
}

//원
class Circle extends Shape {
	// 원점
	Point center; // has - a 관계
	int r;

	Circle() {
		this(new Point(0, 0), 0);
	}

	Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}

	// 그리기 작업
	// @애노테이션(annotation)
	@Override
	void draw() {
		// System.out.printf("[color=%s, center= (%d, %d)]\n",
		// this.color,this.center.x,this.center.y);
		System.out.printf("[color=%s, center= %s]\n", this.color, this.center.getXY());
	}

}

class Shape {
	String color = "black";

	// 메서드 - 면적메서드, 둘레메서드
	void draw() {
		System.out.printf("[color=%s]\n", this.color);
	}
}

class Point { // extends java.lang.Object: 자바는 컴파일러가 자동으로 Object 클래스 상속받음
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Point() {
		this(0, 0);
	}

	String getXY() {
		return String.format("(%d, %d)", this.x, this.y);
	}
}