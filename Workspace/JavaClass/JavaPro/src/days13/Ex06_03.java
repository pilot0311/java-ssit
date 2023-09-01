package days13;

/**
 * @author pilot
 * @date 2023. 7. 31. - 오후 2:08:57
 * @subject
 * @content	Point 클래스 선언
 * 						필드	x, y
 * 						메서드		좌표출력
 */
public class Ex06_03 {

	public static void main(String[] args) {
		//클래스 배열
		Point[] points = new Point[5];
		for (int i = 0; i < points.length; i++) {
			points[i]=new Point();
		} // for
		
		points[0].x=10;	points[0].y=20;
		
		points[1].x=11;	points[1].y=21;
		
		points[2].x=12;	points[2].y=22;
		
		points[3].x=13;	points[3].y=23;
		
		points[4].x=14;	points[4].y=24;
		
		for (int i = 0; i < points.length; i++) {
			points[i].dispXY();
		} // for
	} // main
}
