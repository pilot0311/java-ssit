package days04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01 {

	public static void main(String[] args) throws IOException {
		String name;
		int kor, eng, math, total;
		double avg;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("이름,국어,영어,수학 입력:");
		String inputData = br.readLine();
		//구분자 : 콤마(,) 공백( )
		//String regex="\\\\s*,\\\\s*";
		String regex="[, ]";
		String[] data = inputData.split(regex);
		name = data[0];
		// java.lang.NumberFormatException: For input string: "  23   "
		kor = Integer.parseInt(data[1]); // "  23   " 앞뒤 공백 제거
		eng = Integer.parseInt(data[2]);
		math = Integer.parseInt(data[3]);
		total = kor + eng + math;
		avg = (double) total / 3;
		System.out.printf("이름=\"%s\",국어=%d,영어=%d,수학=%d,총점=%d,평균=%.2f", name, kor, eng, math, total, avg);

	}

}