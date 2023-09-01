package days08;

public class Ex02 {

	public static void main(String[] args) {
//		System.out.println(sum(1,2,3));
//		System.out.println(sum(1,2,3,4,5,6));
//		System.out.println(sum(new int[] {1,2}) );

		char one = 'x';
		char upperOne = myUpperCase(one);
		System.out.println(upperOne);

	} // main

	private static char myUpperCase(char one) {
//		
//		if (Character.isLowerCase(one)) {
//			one = Character.toUpperCase(one);
//		} 

		if ('a' <= one && one <= 'z') {
			one = (char) (one - 32);
		}
		return one;
	}

	private static int sum(int... args) {
		int result = 0;
//		for (int i = 0; i < args.length; i++) {
//			result += args[i];
//		} // for
		for (int i : args) {
			result += i;
		} // foreach
		return result;

	}
}
