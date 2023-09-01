package days10;

import java.util.Arrays;
import java.util.Random;

public class Ex06_03 {

	public static void main(String[] args) {
		
		int[] tots = new int[10];
		int[] ranks = new int[10];
		
		
		Random rnd = new Random();
		Arrays.fill(ranks, 1);
		for (int i = 0; i < tots.length; i++) {
			//0~300
			int tot =rnd.nextInt(301);
			tots[i]=tot;
		} // for
		System.out.println(Arrays.toString(tots));
		//등수 처리
		int m=0;
			
		
		for (int i = 0; i < tots.length; i++) {
			for (int j = 0; j < tots.length; j++) {
				//if(i==j)continue;
				if(tots[i]<tots[j]) ranks[i]++;
			} // for
		} // for
		System.out.println(Arrays.toString(ranks));
		
	} // main
}
