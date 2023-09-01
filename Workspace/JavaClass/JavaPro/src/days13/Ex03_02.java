package days13;

public class Ex03_02 {

	public static void main(String[] args) {
		
		//배열에러
		//int[] m = new int[2];
		//ArrayIndexOutOfBoundsException 배열범위 초과
		//m[2]=3;
		//System.out.println(m[2]);
		int[] m =null;
		//NullPointerException //널 값 참조 못함
		m[2]=100;
		System.out.println(m[2]);
	} // main
}
