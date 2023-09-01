package days02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author pilot
 * @date 2023. 7. 14. - 오후 12:37:20
 * @subject 표준 입출력 (키보드)로 입력 후 출력
 * @content
 */
public class Ex09 {

	public static void main(String[] args) throws IOException {
		String name;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름을 입력하시오");
		name = br.readLine();
		System.out.printf("이름: %s", name);

	}

}
