package days22;

import java.util.HashSet;

public class Ex14 {

	public static void main(String[] args) {
		
		//	Collection 인터페이스
		//		ㄴ	Set 인터페이스 구현한 컬렉션 클래스
		//	-	특징	:	순서 유지X,	중복허용X
		//	-	HashSet 컬렉션 클래스
		//(참고)	Set	+	순서유지O	=>	LinkedHashSet
		
		HashSet hs = new HashSet();
		hs.add(9);
		hs.add(1);
		hs.add(15);
		hs.add(10);
		//[1]
		System.out.println(hs);		//[1, 9, 10, 15] 저장 순서 유지 X
		//[2]
		hs.add(1);						//	1또 추가
		System.out.println(hs);		//[1, 9, 10, 15]	중복 허용X
		System.out.println(hs.size());
		
		
		
	} // main
}
