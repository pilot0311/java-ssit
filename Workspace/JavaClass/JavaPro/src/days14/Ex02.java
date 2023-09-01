package days14;

import days13.Point;

public class Ex02 {

	public static void main(String[] args) {
		Point p1 = new Point(1,2);	//객체 생성할 때 필드 초기화
//		p1.x=1;
//		p1.y=2;

		Point p2 = p1.plusPoint(p1);
		p2.dispXY();
		
		p2 = p1.plusPoint();
		p2.dispXY();
		
		
	} // main
}
