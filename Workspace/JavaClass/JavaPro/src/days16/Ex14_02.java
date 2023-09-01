package days16;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author pilot
 * @date 2023. 8. 3. - 오후 4:29:07
 * @subject 멀티 catch문 설명
 * @content
 */
public class Ex14_02 {

	public static void main(String[] args) {
		int a = 0, b = 0;

		InputStream source = System.in;
		Scanner scanner = new Scanner(source);

		try {

			System.out.print("a, b 두정수 입력");

			a = scanner.nextInt();
			b = scanner.nextInt();
			double c = a / b;
			System.out.printf("%d / %d = %.2f\n", a, b, c);
			System.out.println("정상 종료");

		} catch (InputMismatchException | ArithmeticException e) {
			System.err.println("[1]\n" + e.toString());
			System.err.println("[2]\n" + e.getMessage());
		}  catch (Exception e) { 
			e.printStackTrace();
		} finally {
			System.exit(-1); // 프로그램 종료
		}

		// c cannot be resolved to a variable 변수 인식 불가
//		System.out.printf("%d / %d = %.2f\n",a,b,c);
//		System.out.println("정상 종료");

//		String input = "1 fish 2 fish red fish blue fish";
//	     Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
//	     System.out.println(s.nextInt());
//	     System.out.println(s.nextInt());
//	     System.out.println(s.next());
//	     System.out.println(s.next());
//	     s.close();

	} // main
}
