package days22_t.days22;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex03_03 {
	
	public static void main(String[] args) { 
		 
		ArrayList list = new ArrayList(10);
		
		list.add("이경서");
		list.add("신종혁");
		list.add("이재영");
		list.add("송해영");
		list.add("신기범");
		list.add("이준희");
		list.add("김성준"); 
		
		// 팀에서  "이"씨 팀원만 삭제
//		subtractOddList.removeIf(a -> a%2 == 1);   // 홀수 제거
//		[출처] [Java/자바] - ArrayList.removeIf(predicate<? super E> filter)|작성자 주현
		list.removeIf( n -> ((String) n).charAt(0)=='이');
		
		System.out.println( list );
		 
	} // main
 

} // class
