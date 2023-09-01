package days08;

import java.util.Random;

public class Ex09 {

	public static void main(String[] args) {
		//로또 6/45
		//1~45정수를 6개출력
		//(int) (Math.random()*45)+1
		Random rnd = new Random();
//		rnd.nextInt(45)+1
		
		for (int i = 1; i <= 6; i++) {
			int lottoNumber = rnd.nextInt(45)+1;
			System.out.println(lottoNumber);
			
		} // for
		
	} // main
}
