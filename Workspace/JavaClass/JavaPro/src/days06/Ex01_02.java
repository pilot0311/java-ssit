package days06;

import java.util.Arrays;
import java.util.Random;

public class Ex01_02 {
	
	public static void main(String[] args) {
		//[문제] 10개 정수를 임의의 값으로 저장 -> 가장 큰값 찾기
		// (int) ((Math.random()*11)+5);
		Random rnd=new Random(); //Random(seed); seed없을 시 디폴트로 현재 날짜 시간이 들어감
		rnd.nextInt(16);  // 1<=rnd<16 사이의 랜덤값
		int[] m = new int[10];
		int max=0;
		int min=Integer.MAX_VALUE;		 //
		for (int i = 0; i < m.length; i++) {
			m[i]=rnd.nextInt(11)+5;
			if(max<m[i]) {
				max=m[i];
		}
			else if(min>m[i])
				min=m[i];
		} // for
		System.out.println(Arrays.toString(m));
		
		System.out.printf("가장 큰값=%d\n",max);
		System.out.printf("가장 작은값=%d\n",min);
		System.out.print("가장 작은값="+Arrays.stream(m).min().getAsInt()); //.stream		.getAsint
	} // main
}
