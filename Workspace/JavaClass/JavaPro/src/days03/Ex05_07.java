package days03;

/**
 * @author pilot
 * @date 2023. 7. 17. - 오후 3:04:22
 * @subject	전위형, 후위형 증감연산자
 * @content
 */
public class Ex05_07 {
	
	public static void main(String[] args) {
		
		int x = 10;
		//int y = ++x;	//전위형> ++x 실행후 =대입연산 실행
		int y = x--;	//후위형> =대입 연산후 --연산자 실행
		System.out.printf(">x=%d, y=%d\n",x,y);
		
		//단독(홀로) 사용될 때는 전/후위형은 같은 결과이고
		//ex) x++;와 ++x는 같은 결과
	}
}
