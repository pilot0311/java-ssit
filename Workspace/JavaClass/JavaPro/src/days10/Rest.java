package days10;

public class Rest {
	public static void main(String[] args) {
		int [] m =new int[3];
	m=add(m);
		list(m);
		System.out.println(m.length);
	} // main

	private static void list(int[] m) {
		System.out.println(m.length);
		
	}

	private static int[] add(int[] m) {
		int [] t = new int [5];
		m = t;
		return m;
		
	}
}
