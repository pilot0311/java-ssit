package days03;

/**
 * @author pilot
 * @date 2023. 7. 17. - 오후 2:01:50
 * @subject	논리 연산자
 * @content	참/거짓 boolean
 * 					1)	일반 논리 연산자
 * 						ㄱ.	&&	일반 논리 AND 연산자
 * 							(둘다 참이면 참)
 * 							참 && 참 => 참
 * 							참 && 거짓 => 거짓
 * 							거짓 && 참 => 거짓
 * 							거짓 && 거짓 => 거짓
 * 
 * 						ㄴ.	||		일반 논리 OR 연산자
 * 							(둘다 거짓이면 거짓)
 * 							참 || 참 => 참
 * 							참 || 거짓 => 참
 * 							거짓 || 참 => 참
 * 							거짓 || 거짓 => 거짓
 * 
 * 						ㄷ.	!		부정(NOT) 연산자
 * 							!참 => 거짓
 * 							!거짓 => 참
 * 
 * 					2)비트 논리 연산자:	&	^	|	~
 */
public class Ex05_04 {
	public static void main(String[] args) {
		//연산자 우선 순위 예) x > +
		//산술 > 비교 > 논리 > 대입
		//System.out.println(3<=5	&& 10>1); //true
		//System.out.println(3<=5	&& 10<1); //false
		//경고: Dead code
		//							거짓	&&	참/거짓  = 앞쪽이 거짓이기 때문에 뒤에 아무 값이 오든 상관이 없음
		//System.out.println(3>=5	&& 10>1); //false
		//System.out.println(3>=5	&& 10<1); //false		
		
		
//		System.out.println(3<=5	|| 10>1); //true
//		System.out.println(3<=5	|| 10<1); //true
//		System.out.println(3>=5	|| 10>1); //true
//		System.out.println(3>=5	|| 10<1); //false	
		
		//The operator ! is undefined for the argument type(s) int =	!는 int형 피연산자에 사용 할 수 없음
		//!boolean
		// 비교 > 논리			<=			!
		//!부정 연산자는 단항 연산자로 어떤 연산자보다 우선 순위가 높다
		System.out.println(!(3<=5)); // = !(true) = false
		
		
	}
}
