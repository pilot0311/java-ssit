package days18;

public class Ex04 {

	public static void main(String[] args) {
		// Object.hashCode() 메서드
		//해시 -> 해시함수(해싱기법)
		//	ㄴ	데이터 관리 기법 중의 하나
		//			ㄴ	저장, 검색 등등
		//	ㄴ	객체 저장 -> 주소값 -> 해시코드로 변환 -> 반환하는 메서드
		//[참고] 동일한 객체 체크 = [equals() + hashCode()] 오버라이딩
		
		//String s1 = "qwda";
		//String s2 = "qwda";

		
		String s1 = new String("qwda");
		String s2 = new String("qwda");
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
	} // main
}
