package days09;

public class Extest_02 {
	
	public static void main(String[] args) {
		int n=10;
		
		System.out.printf("%d",factorial(n));
	} // main

	private static int factorial(int n) {
		if(n>0)
			return n*factorial(n-1); 
		else if(n==1||n==0) return 1;
		else  return -1;
	}
}
