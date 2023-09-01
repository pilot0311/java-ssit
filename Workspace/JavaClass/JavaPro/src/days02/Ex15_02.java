package days02;

public class Ex15_02 {
	
	public static void main(String[] args) {
		
		int i = 10;
		
		//int -> String
		//10-> "10"형변환
		//1
		String si = i+"";
		//2
		si = Integer.toString(i);
		//3
		si = String.valueOf(i);
		
		//"1010"
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toString(i, 2));
		//"12"
		System.out.println(Integer.toOctalString(i));
		System.out.println(Integer.toString(i, 8));
		//"a"
		System.out.println(Integer.toHexString(i));
		System.out.println(Integer.toString(i, 16));
		
	}// main
}// class
