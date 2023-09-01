package days14;

public class Point {

	// 필드
	private int x;
	private int y;

	// 디폴트 생성자
	public Point() {
		this(1);
		System.out.println("> Point 디폴트 생성자 호출됨...");
	}

	// 12:03 수업시작~
	public Point(int x, int y) {
		System.out.println("> Point 2 생성자 호출됨...");
		// The assignment to variable x has no effect
		this.x = x;
		this.y = y;
	}

	public Point(int i) {
		this(i, i); // Point(x,y)
		System.out.println("> Point 1 생성자 호출됨...");
		// this.x = i;
		// this.y = i;
	}

	// 호출한 객체 p1
	// p1.printPoint()
	// 호출한 객체 p2
	// p2.printPoint()
	// 객체명.필드
	// 객체명.메서드
	public void printPoint() {
		System.out.printf("> x=%d, y=%d\n", this.x, this.y);
	}

	// Point p1.offsetPoint(10)
	// this
	/*
	 * public void offsetPoint(int n) { this.x += n; this.y += n; // return this; }
	 */
	public Point offsetPoint(int n) {
		this.x += n;
		this.y += n;
		return this;
	}

}
