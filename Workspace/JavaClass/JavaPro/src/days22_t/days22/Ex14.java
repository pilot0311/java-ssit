package days22_t.days22;

import java.util.HashSet;

/**
 * @author kenik
 * @date 2023. 8. 11. - 오후 4:23:16
 * @subject
 * @content
 */
public class Ex14 {
	
	public static void main(String[] args) {
		
		//     Collection 인터페이스
		// [     ㄴ Set 인터페이스 구현한 컬렉션 클래스 ]
		//  - 특징 :  순서 유지 X,  중복 허용 X
		//  - HashSet 컬렉션 클래스
		// (참고)  Set + 순서 유지 O ==> LinkedHashSet 
		
		
		HashSet hs = new HashSet();
		hs.add(9);
		hs.add(1);
		hs.add(15);
		hs.add(10);
		// 1) [1, 9, 10, 15]  저장 순서 유지 X
		System.out.println( hs );
		
		hs.add(1);
		// 2) [1, 9, 10, 15]  중복 허용 X
		System.out.println( hs );
		
		System.out.println( hs.size() );
		
		
		
	} // main

} // class







