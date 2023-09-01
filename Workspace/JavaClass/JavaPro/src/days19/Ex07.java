package days19;

public class Ex07 {

	public static void main(String[] args) {
		//	[오토 박싱(boxing)과 오토 언박싱(unboxing)]
		int i = 100;	//	변수
		Integer j = i;		//	기본형(i) ->  객체(j) 기본형이 객체로 자동으로 바뀌는것 : 오토 박싱
		int k =j;		// 객체 -> 기본형 변환 : 객체가 기본형으로 자동으로 바뀌는것 : 오토 언박싱
		
		test(i);	//int	-> Integer 박싱 -> Object 업캐스팅			Object가 모든 자료형을 받아서 처리 가능한 이유
		test(j);	//Integer 클래스 (업캐스팅)
		test("qwe"); //String (업ㅋ스팅)
		//JDK 1.5 이전
		//Integer k = new Integer(i);
	} // main

//	private static void test(int i) {	//Integer -> int 형변환 (오토 언박싱)
//		System.out.println(i);
//	}
	
	private static void test(Object i) {	// Object: 모든 자료형을 매개변수로 받아서 처리
		System.out.println(i);
	}
}
