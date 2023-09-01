package days16;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		int a = 0, b=0;
		//double c=0;	
		//예외처리
		InputStream source = System.in;
		Scanner scanner = new Scanner(source);
		//JVM의 예외처리기에 의해서 InputMismatchException 예외 객체 생성 -> 개발자 파악 예외 처리
		try {
			//예외가 발생할 소지가 있는 코드 작성
			System.out.print("a, b 두정수 입력");
			//예외 발생 순간 그 아래 코딩 실행 하지 않고 catch문으로 넘어감
			a = scanner.nextInt();
			b = scanner.nextInt();
			double c = a/b;	
			System.out.printf("%d / %d = %.2f\n",a,b,c);
			System.out.println("정상 종료");
			
			//다중 catch문
			//JDK 1.7 ~ 멀티 catch 문
		} catch (InputMismatchException e) {
			
			System.err.println(">[알림]정수만 입력 하세요");
			//System.exit(-1);	//프로그램 종료
		}catch (ArithmeticException e) {
			System.err.println("0으로 나눌 수 없습니다");
			//System.exit(-1);	//프로그램 종료
		}catch (Exception e) {	//모든 예외의 최상위 부모 Exception	catch문 여러개 쓸경우 부모에 해당하는 예외 클래스는 맨 밑에 작성
			e.printStackTrace();//예외를 추적해 출력
			//System.exit(-1);	//프로그램 종료
		} finally {
			//예외 발생 유무에 상관 없이 처리할 구문
			System.exit(-1);	//프로그램 종료
		}
		
		
		//c cannot be resolved to a variable 변수 인식 불가
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
