package days05;

public class Ex05 {
	public static void main(String[] args) {
		// 조건문: if
		// 분기문: switch
		// 반복문: for, foreach(확장for문)
		// 기타: break; continue;
		// 조건반복문: while, do~while

		// 컬렉션(collection) [열거자] 반목해서 처리
//		while (en.hasMoreElements()) {
//			type type = (type) en.nextElement();
//			
//		}

		// [반복자] 반복해서 처리
//		while (it.hasNext()) {
//			type type = (type) it.next();
//			
//		}

//		while (condition) {
//			//조건식이 참일 동안 반복해서 {}블럭 실행 
//		}

		// for 반복문과 while조건 반복문의 차이점
		// 반복횟수가 정해져 있으면 for 반복조건이 정해져있으면 while

		// [1]1~10까지의 합 while
//		int i=1,sum=0;
//		while (i<=10) {
//			System.out.printf("%d+",i);
//			sum+=i;
//			i++;
//		}

		// [2]
//		int i=0,sum=0;
//		while (i<10) {
//			i++;
//			System.out.printf("%d+",i);
//			sum+=i;
//			
//		}
//		System.out.printf("=%d",sum);
		
		// [3]
		int i = 0, sum = 0;
		while (++i <= 10) {

			System.out.printf("%d+", i);
			sum += i;

		}
		System.out.printf("=%d", sum);

	} // main
}
