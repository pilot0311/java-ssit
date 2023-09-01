package days22_t.days22;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @author kenik
 * @date 2023. 8. 11. - 오전 11:54:10
 * @subject
 * @content
 */
public class Ex07 {

	public static void main(String[] args) {
		// 12:05 수업 시작~
		// Vector 컬렉션 클래스
		//   ㄴ List 인터페이스를 구현한 클래스
		//   ㄴ 순서 유지 O, 중복 허용 O
		//   ㄴ ArrayList 동일( 차이점 )
		//         ㄴ 멀티스레드에 안전( 동기화 처리 )
		
		Vector v = new Vector();
		
		// StringBuilder : 멀티 스레드 X, 동기화 처리 X
		// StringBuffer : 멀티 스레드 O, 동기화 처리 O
		
		v.addElement("김호영"); // add() 동일
		v.add("김성준");
		v.add("이지현");
//		v.add(null);
// 		v.add(null);
		
		System.out.println( v.size() ); // 요소의 갯수
		System.out.println( v.capacity() ); // 10
		
		v.trimToSize();
		System.out.println( v.capacity() );  // 용량
		
		v.setSize(5); // [a][b][c][null][null]
		
		System.out.println( v.size() );
		System.out.println( v );
		
		v.get(0); // "김호영"
		v.elementAt(0);
		
		// [반복자]와  [열거자]의 차이점
		Iterator ir = v.iterator();
		// The returned iterator is [fail-fast.]
		// 열거자
		Enumeration  en = v.elements();
		
		// hasMoreElements() 요소 더 있니 ? [true]/false
		while (en.hasMoreElements()) {
			//  다음 요소를 얻어오는 메서드   nextElement()
			String name = (String) en.nextElement();
			System.out.println( name );
		} // while
		
		/*
		String 제거한이름 = (String) v.remove(0);
		v.removeElementAt(0);
		 */
		
		// v(벡터)  null 요소제거한 나머지 요소를 출력.
		v.removeIf( n -> n==null );		
		System.out.println( v );
		//             메서드 참조
		// v.forEach( System.out::println );
	    v.forEach( n -> System.out.println( n ) );
	    
	    // v.clear();
	    // v.clone();
	    
	    // v.firstElement();	    v.get(0);
	    // v.lastElement();         v.get(  v.size()-1 )
		
		// v.insertElementAt("임경재", 1);	v.add(1,"임경재");
	    
	    // ArrayList - v.listIterator()
	    
	    List subList =   v.subList(0, 2);
	    System.out.println( subList );
	    
	   
		

	} // main

} // class
