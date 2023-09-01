package days19;

import java.util.StringTokenizer;

public class Ex04 {

	public static void main(String[] args) {
		//StringTokenizer 클래스
		String str = "rwqa,dwsa,afad,gsxf";
		//str.split(",");
		StringTokenizer st = new StringTokenizer(str, ",");

		/*
		System.out.println(st.countTokens());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		*/
		/*
		int n = st.countTokens();
		for (int i = 0; i < n; i++) {
			System.out.println(st.nextToken());
		} // for
		*/
		
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
	} // main
}
