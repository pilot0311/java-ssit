package days05;

public class Ex07_03 {

	public static void main(String[] args) {
		//조건문	if
		//분기문	switch
		//반복문	for,			foreach = 배열, 컬렉션 반복처리
		//조건반복문	while,	do~while
		//기타	break,	continue
		
		//정수 10개 저장 할 배열 m선언
		int m[]=new int[10];
		//임의의 정수 (1~100)를 각 배열의 요소에 저장
		for (int i = 0; i < m.length; i++) {
		m[i]=(int)(Math.random()*100)+1;
	} // for
		//for문 사용해서 각 요소를 출력
//		for (int i = 0; i < m.length; i++) {
//			System.out.printf("m[%d]=%d\n",i,m[i]);
//		} // for
		
		//foreach
		for (int n : m) {
			System.out.println(n);
		} //foreach
		
		
		
		
		
		
		
	} // main
}
