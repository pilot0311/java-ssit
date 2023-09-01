package days13;

/**
 * @author kenik
 * @date 2023. 7. 31. - 오후 2:17:39
 * @subject
 * @content
 */
public class Ex07 {

	public static void main(String[] args) {

		// Call By Reference
		// 매개변수 클래스 참조타입 사용.
		int x = 10, y = 20;
		System.out.printf("> x=%d, y=%d\n", x, y);

		swap(x, y); // Call By Value

		System.out.printf("> x=%d, y=%d\n", x, y);

	} // main

	private static void swap(int x, int y) {
		System.out.printf("> swap x=%d, y=%d\n", x, y);
		int temp = x;
		x = y;
		y = temp;
		System.out.printf("> swap x=%d, y=%d\n", x, y);
	}

} // class
