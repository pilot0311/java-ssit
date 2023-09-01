package days13;

/**
 * @author kenik
 * @date 2023. 7. 31. - 오후 2:17:39
 * @subject
 * @content
 */
public class Ex07_02 {

	public static void main(String[] args) {

		// Call By Reference
		// 매개변수 클래스 참조타입 사용.
		int x = 10, y = 20;
		int[] m = { x, y };

		System.out.printf("> x=%d, y=%d\n", m[0], m[1]);

		swap(m); // Call By Reference

		System.out.printf("> x=%d, y=%d\n", m[0], m[1]);

	} // main

	private static void swap(int[] m) {
		System.out.printf("> swap x=%d, y=%d\n", m[0], m[1]);
		int temp = m[0];
		m[0] = m[1];
		m[1] = temp;
		System.out.printf("> swap x=%d, y=%d\n", m[0], m[1]);
	}

} // class
