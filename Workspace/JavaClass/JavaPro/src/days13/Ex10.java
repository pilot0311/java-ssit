package days13;

public class Ex10 {

	public static void main(String[] args) {
		//	[리턴자료형이 참조타입]
		//	Point 클래스 안에 plusPoint메서드 추가
		//		ㄴPoint 객체를 매개변수로 받아서
		//			x,y좌표를 10씩 증가 시킨 후 증가시킨 좌표 반환하는 메서드 추가
		
		Point p1 = new Point();
		p1.x=1;
		p1.y=2;
		Point p3 = new Point();
		p3.x=2;
		p3.y=3;
		//객체명.매서드명
		//객체명.필드명
		Point p2 = p1.plusPoint(p3);
		p2.dispXY();
		
		p2 = p1.plusPoint();
		p2.dispXY();
	} // main
}
