package days08;

/**
 * @author pilot
 * @date 2023. 7. 24. - 오전 11:15:44
 * @subject 지역변수 개념
 * @content
 * 
 * 					함수 호출 + 매개 변수 가지고
 * 					1) Call By Name			drawLine();
 * 					2) Call By Value			swap(x,y);
 * 					3) Call By Reference
 * 					4) Call By Point
 */
public class Ex04 {

	public static void main(String[] args) {
		//main 함수의 지역변수 x,y
		//int x =10, y=20;
		int[] m= {10,20};  //xy[0]=10,xy[1]=20
		System.out.printf("x= %d, y= %d\n",m[0],m[1]);
		
		//Call By Value: X
		//Call By Reference: main함수의 x,y참조
		//매개변수를 참조타입을 사용하겠다-배열,클래스,인터페이스
		swap(m);
		
		System.out.printf("x= %d, y= %d\n",m[0],m[1]);
	} // main

	//함수선언						swap함수의 지역변수 int[]m = 지역변수의 주소 참조
	private static void swap(int[] m) {
		int temp = m[0];
		m[0]=m[1];
		m[1]=temp;
		
	}
}
