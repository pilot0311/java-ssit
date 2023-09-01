package days07;

public class Ex11 {

	public static void main(String[] args) {

		int[] x = {10,20};
		System.out.printf(">x=%d, y=%d\n", x[0], x[1]);
		swap(x);
		//두기억공간 값 바꾸는 함수 swap 만들기
		System.out.printf(">x=%d, y=%d\n", x[0], x[1]);
		inc(x);
		System.out.println(x.length);
	} // main
	private static void inc(int[] x) {
		int []c= {1,2,3,4,5};
		x=c;
	}

	public static void swap(int[] x) {
		int temp =x[0];
		x[0]=x[1];
		x[1]=temp;
	
	}
	
} // class
