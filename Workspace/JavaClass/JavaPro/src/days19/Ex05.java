package days19;

public class Ex05 {

	public static void main(String[] args) {
		//	[Math 클래스]
		//	수학 관련된 static 메서드
		//	static 필드 2개
		System.out.println(Math.PI);
		System.out.println(Math.E);
		
		System.out.println(Math.random());
		System.out.println(Math.max(2,4));
		System.out.println(Math.min(2,4));
		System.out.println(Math.pow(2,3));
		System.out.println(Math.abs(-100));
		System.out.println(Math.sqrt(4));	//2.0
		
		//올림(절상), 내림(절삭), 반올림
		//Math.ceil 소수점 첫 번째 자리에서 올림 (double 반환)
		System.out.println(Math.ceil(2.0));		//2.0 double
		System.out.println(Math.ceil(2.479));	//3.0 double
		System.out.println(Math.ceil(2.979));
		
		//Math.floor 내림
		System.out.println(Math.floor(2.0));		//2.0 double
		System.out.println(Math.floor(2.479));	//2.0 double
		System.out.println(Math.floor(2.979));
		
		//Math.round 반올림 (int 반환)
		System.out.println(Math.round(2.0));		//2 
		System.out.println(Math.round(2.479));	//2
		System.out.println(Math.round(2.979));	//3
		
		
		//Math 클래스 :	최대 성능을 얻기 위해서 JVM이 설치된 OS의 메서드를 호출해서 처리(문제점:	OS가 다르면 결과는 다르게나올 수 있다)					
		//StrictMath 클래스 :	성능은 포기하더라도 OS마다 동일한 결과값을 나오게 하기 위해 StrictMath클래스 사용
	} // main
}
