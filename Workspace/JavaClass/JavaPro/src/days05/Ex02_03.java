package days05;

public class Ex02_03 {
	public static void main(String[] args) {
		
		
		String name ="pilot";
		String n;
		char nameArr[] = name.toCharArray();
		n = String.valueOf(nameArr);
		System.out.println(nameArr[3]);
		System.out.println(n);
		
		
		
		// 시험[1]
//		String name ="pilot";
//		// String -> char[] 변환 -> char 배열[0]
//		char nameArr[] = new char[name.length()];
//		for (int i = 0; i < nameArr.length; i++) {
//			nameArr[i] = name.charAt(i);
//		} // for
//		System.out.println(nameArr[3]);
	} // main
}
