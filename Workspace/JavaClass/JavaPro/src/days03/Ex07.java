package days03;

/**
 * @author pilot
 * @date 2023. 7. 17. - 오후 3:18:44
 * @subject	대문자 -> 소문자
 * @content	소문자 ->	 대문자
 */
public class Ex07 {

	public static void main(String[] args) {
		
		char lowerCase, upperCase;
		
		lowerCase = 'x';
		
		//uperCase 변수에는 lowerCase의 대문자 를 저장해서 출력
		upperCase = (char) (lowerCase-32);
		System.out.printf("%c\n",upperCase);
		
		lowerCase = (char)(upperCase+32);
		System.out.printf("%c\n",lowerCase);
		
		//'0' 48
		//'2' 50
		//'4' 52
		//							52 - 50
		System.out.println('4' - '2');	//2

	}//main

}//class
