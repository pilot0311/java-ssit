package days11;

public class Ex07 {

	public static void main(String[] args) {

		int[] m = new int[8];
		// 1. 1차원 배열의 크기 : 배열명.length
		System.out.println(m.length);
		// 2. 윗첨자값( UppderBound ) : 배열명.length -1
		System.out.println(m.length - 1);
		// 3. 배열은 초기화하지 않아도 기본값으로 초기화
		// ( int 배열 int의 기본값 : 0 으로 초기화 )
		for (int i = 0; i < m.length; i++) {
			System.out.printf("m[%d]=%d\n", i, m[i]);
		} // for
		
		// 4. 배열 초기화
		// int []m = new int[3];
		//	m[0]=1;
		//	m[1]=1;
		//	m[2]=2;
		//int []m = new int[]{1,2,3};
		//int []m = {1,2,3};
	} // main
}
