package days05;

/**
 * @author pilot
 * @date 2023. 7. 19. - 오후 3:46:20
 * @subject while 조건 반복문
 * @content
 */
public class Ex06 {

	public static void main(String[] args) {

		//[1]
		int i = 10, sum = 0;
		while (i >= 1) {

			System.out.printf("%d+", i);
			sum += i;
			i--;
		}
		System.out.printf("=%d", sum);
		//[2]
		
		
		
	} // main
}
