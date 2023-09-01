package days07;

public class Ex07 {

	public static void main(String[] args) {
		
		//	1.	1/2+2/3+3/4+....9/10=
		System.out.println("첫번째 문제");
		double sum=0.0;
		for (int i = 1; i <=9 ; i++) {
			System.out.printf(i==9?"%f":"%f+",(double)i/(i+1));
			sum+=(double)i/(i+1);
		} // for
		System.out.printf("=%f\n",sum);
		
//		2.	1+2+4+7+11+16+..191=		규칙적인 수열
		//	1+0	1+1	2+2	4+3....	
		//		sum+i=1+1	i=2 sum+i=2+2	i=4 sum+i=4+3...
		System.out.println("두번째 문제");
	        int sum2 = 0;  
	        int term = 1;
	        for (int i = 1; i <= 20; i++) {
	            sum2 += term;      
	            System.out.printf(i==20?"%d":"%d+",term);
	            term += i;  
	        }

	        System.out.printf("=%d", sum2);
		
	} // main
}
