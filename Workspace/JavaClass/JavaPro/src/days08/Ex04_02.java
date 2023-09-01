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
public class Ex04_02 {

	public static void main(String[] args) {
		//main 함수의 지역변수 x,y
		int x =10, y=20;
		System.out.printf("x= %d, y= %d\n",x,y);
		//Call By Value
		swap(x,y);//함수 호출 swap(10,20)
		
		System.out.printf("x= %d, y= %d\n",x,y);
	} // main

	//함수선언						swap함수의 지역변수
	private static void swap(int x, int y) {
		System.out.printf("swap x= %d, y= %d\n",x,y);
		int temp = x;
		x=y;
		y=temp;
		System.out.printf("swap x= %d, y= %d\n",x,y);
	}
}
