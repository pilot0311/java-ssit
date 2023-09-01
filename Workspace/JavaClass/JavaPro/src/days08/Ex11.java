package days08;

public class Ex11 {

	public static void main(String[] args) {
		// [정보처리 기사 실기]
		int money = 125760;

		// 화페단위:5만원, 1만원, 5천원, 1천원, 5백원, 100원, 50원, 10원, 5원 ,1원
		// 5만원 2개, 1만원 2개, 5천원 1개, 1000원 0개, 500원 1개, 100원 2개, 50원 1개, 10원 1개, 5원 0개, 1원
		// 0개
//		int m = money/50000;
//		int o = money%50000/10000;
//		int n = money%10000/5000;
//		int e = money%5000/1000;
//		int y = money%1000/500;
//		int oh = money%500/100;
//		int ft = money%100/50;
//		int ot = money%50/10;
//		int f = money%10/5;
//		int one = money%5;
//		System.out.printf("5만원 %d개, 1만원 %d개, 5천원 %d개, 1000원 %d개, 500원 %d개, 100원 %d개, 50원 %d개, 10원 %d개, 5원 %d개, 1원 %d개",m,o,n,e,y,oh,ft,ot,f,one);

		int[] don = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		for (int i = 0; i < don.length; i++) {
			System.out.printf("%d원: %d개\n", don[i], (money / don[i]));
			money %= don[i];
		}

	} // main
}
