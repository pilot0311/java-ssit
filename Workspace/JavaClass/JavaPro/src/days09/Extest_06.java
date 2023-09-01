package days09;

import java.util.Arrays;
import java.util.Scanner;

public class Extest_06 {

	public static void main(String[] args) {
		// [3]제어문 활용
		int n = 10;
		String s = "";
		int[] binaryArr = new int[32];
		int index = binaryArr.length-1;
		int share, reminder;

		while (n != 0) {
			share = n / 2;
			reminder = n % 2;
			System.out.println(reminder);
			binaryArr[index--]=reminder;
			s += reminder;
			n = share;
		}
		System.out.println(Arrays.toString(binaryArr).replace(", ", ""));
		
		
//		int n =10;
//		String b ="";
//		while(n>0) {
//			b = n%2+b;
//			n/=2;
//		}
//		n = Integer.parseInt(b);
//		String f = String.format("%032d", n);
//		System.out.printf(f);

		// [2]
//		int n =10;
//		String s = "00000000000000000000000000000000";
//		String b = Integer.toBinaryString(n);
//		s+=b;
//		System.out.printf("%s\n",s.substring(b.length()));

		// [1]
//		try (Scanner sc = new Scanner(System.in)) {
//		System.out.print("정수를 입력하세요:");	
//		int n = Integer.parseInt(Integer.toBinaryString(sc.nextInt()));
//		System.out.printf("%032d",n);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	} // main
}// class
