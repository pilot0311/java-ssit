package days02;

/**
 * @author pilot
 * @date 2023. 7. 14. - 오전 10:35:54
 * @subject 두 기억공가간읙= 박ㅁ
 * @content
 */
public class Ex04 {

	public static void main(String[] args) {
		//두 정수를 저장할 X,Y변수를 선언하고
		//각각 10, 20 으로 초기화 하고
		//출력 형식: ㅌ=10 ,Y=20
		//동일한 자료형일 경우 ,연산자를 사용해 나열할 수 있다
		int x = 10, y = 20;
		
		System.out.printf("교환 전 x= %d, y= %d\n", x, y);
		{
		int temp;
		temp=x;
		x=y;
		y=temp;
		}
		System.out.printf("교환 후 x= %d, y= %d", x, y);
		//프로그램 상에서 두 기억 공간의 값을 교환하려면 반드시 동일한 자료형의 임시기억 공간이 필요하다
		
		
	}//main
}//class
