package days13;

public class Ex04 {

	public static void main(String[] args) {
		// 패키지 내부
		// Tv클래스와 Ex04클래스는같은 패키지 안에 있다.
		Tv t1 = new Tv();
		System.out.println(t1.channel);//0
		
		//[패키지 외부] 상속, 참조 테스트
		
		//[접근지정자 설명]
		//	1.	클래스 앞에 접근지정자
		//		public					:	패키지 내부, 외부 어디서든 상속과 참고 가능
		//		default(==package)	:	접근지정자 따로 표기 안할경우, 패키지 내부 에서만 상속과 참조 가능
		//		독립적인 클래스로 선언할 때는 사용할 수 없는 접근 지정자이다
		//		중첩 클래스로 선언할 때 사용할 수 있다
		//		(내부 클래스 종류 4가지)
		//		private		비활성		:	같은 파일 내에서만 상속 참조 가능
		//		protected	비활성		:	default + 패키지 외부에서는 상속만 가능
		//	1-2.	클래스 앞에 기타제어자
		//		abstract		-	추상 클래스
		//		final			-	최종 클래스
		//		static			비활성	-	중첩클래스 선언할때만 사용
		
		//	2.	멤버(필드,메서드)앞에 접근지정자
		//		public
		//		default
		//		private
		//		protected
	} // main
}
