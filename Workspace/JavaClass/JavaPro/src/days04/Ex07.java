package days04;


public class Ex07 {

	public static void main(String[] args) {
		/*
		int sum=0, i=1;
		for (		;		;		) { //무한루프
			if(i>10)break; //break; 반복문을 빠져나간다
			System.out.printf("%d+",i);
			sum+=i;
			i++;
		} // for
		//Unreachable code 사용할일 없는 코드
		System.out.printf("\b=%d\n",sum);
		System.out.printf("%d\n",i);
	*/
		/*
		int sum = 0;
		for (int i = 1, j = 1, k = 1; i <= 10 && k <= 10 || j > -100; i++, j--, k += 2) {

			System.out.printf("%d+", i);
			sum += i;

		} // for

		System.out.printf("\b=%d\n", sum);
		// System.out.printf("%d\n",i);
*/
		//[문제]1~10까지의 합 출력 i =10
		int sum = 0;
		for (int i = 10; i >= 1; i--) {

			System.out.printf("%d+", i);
			sum += i;

		} // for

		System.out.printf("\b=%d\n", sum);
		// System.out.printf("%d\n",i);
		
	}//main
	
}
