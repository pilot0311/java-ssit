package days03;

public class Ex04 {
	public static void main(String[] args) {
		int n =10;
		
		System.out.printf("2진 %s\n",Integer.toBinaryString(n));
		System.out.printf("2진 %s\n",Integer.toString(n,2));
		
		//전공자 00000000	00000000	00000000	00001010
		System.out.printf("2진 %032d\n",Integer.parseInt(Integer.toBinaryString(n)));
	}
}
