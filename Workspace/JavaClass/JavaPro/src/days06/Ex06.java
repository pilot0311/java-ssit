package days06;

public class Ex06 {

	public static void main(String[] args) {
//		for (int i = 2; i <=9; i++) {
//			System.out.println();
//			System.out.printf("[%d]단\n",i);
//			for (int j = 1; j <= 9; j++) {
//				System.out.printf("%d*%d=%d\n",i,j,i*j);
//				
//			} // for
//		} // for
		//구구단 while 문으로
		int dan =2;
		int i=1;
		while (dan<=9) {
			System.out.printf("[%d단]\n",dan);
			i=1;
			while (i<=9) { //dan=3 i=10 이기에 코드 실행 안함
				System.out.printf("%d*%d=%d\n",dan,i,dan*i);
				i++;
			}
			dan++;
		}
	} // main
}
