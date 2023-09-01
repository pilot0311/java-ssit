package days10;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Ex08 {

	public static void main(String[] args) {
		//최고값 위치 출력
		int[] score = new int[20];
		int max = 0, min = 101;
		Random rnd = new Random();
		for (int i = 0; i < score.length; i++) {
			score[i] = rnd.nextInt(101);
			if (max < score[i])
				max = score[i];
			else if (min > score[i])
				min = score[i];
		} // for
		System.out.println(Arrays.toString(score));
		
		
		//람다식과 스트림
		max = IntStream.of(score).max().getAsInt();
		min = IntStream.of(score).min().getAsInt();
		int sum = IntStream.of(score).sum();
		double avg = IntStream.of(score).average().getAsDouble();
		System.out.printf("max= %d, min= %d, total= %d, avg= %f", max, min,sum,avg);
	} // main
}
