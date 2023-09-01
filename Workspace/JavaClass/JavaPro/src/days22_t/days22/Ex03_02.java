package days22_t.days22;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex03_02 {
	
	public static void main(String[] args) { 
		 
		ArrayList list = new ArrayList(10);
		list.add("이경서");
		list.add("신종혁");
		list.add("이재영");
		list.add("송해영");
		list.add("신기범");
		list.add("이준희");
		list.add("김성준"); 
		
		dispList( list );
		
		System.out.println( list.size() ); // 요소의 갯수 7
		// list.trimToSize(); // [][][][][][][][]
		
		// Object -> String  다운캐스팅
		String name = (String) list.get(1);
		System.out.println( name );
		
		/*
		list.remove(1); // 신종혁 삭제
		list.add(1, "홍길동");
		*/
		list.set(1, "홍길동"); // 교체	
		
		// list.replaceAll(null);
		
		System.out.println( list );
		
        // boolean list.contains("홍길동");
		int index = list.indexOf("홍길동"); // -1   index
		list.remove(index); // 삭제된 요소(홍길동)를 반환
		
		// list.remove("홍길동");
		
		/*
		String regex = "김.+";
		name.charAt(0) == '김';
		name.startsWith("김");
		*/
	} // main

	private static void dispList(ArrayList list) {
		 // 반복자 사용
		Iterator ir = list.iterator();
		while (ir.hasNext()) {
			String name = (String) ir.next();
			System.out.println(name);
		} // while
		
	}

} // class
