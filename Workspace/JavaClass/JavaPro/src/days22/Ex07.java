package days22;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex07 {

	public static void main(String[] args) {
//		vector 컬렉션 클래스
		//		ㄴ	List 인터페이스를 구현한 클래스
		//		ㄴ	순서유지O 중복 O
		//		ㄴ	ArrayList 동일(차이점: Vector는 멀티 쓰레드 안전(동기화 처리) )	
		
		Vector v = new Vector();
		
		v.addElement("김호영");	//add와 동일
		v.add("김성준");
		v.add("이지현");
		
		System.out.println(v.size());		//요소의 갯수
		System.out.println(v.capacity());	//10 	용량
		v.trimToSize();	//남는 용량 제거
		System.out.println(v.capacity());	//3
		v.setSize(5);		//요소를 5개로 늘림 (null2개추가)		
		System.out.println(v.size());
		System.out.println(v);
		
		v.get(0);	//0번쨰 위치의 값가져옴 ("김호영")
		v.elementAt(0);	//0번쨰 위치의 값가져옴 ("김호영")
		
		//	반복자 와 열거자의 차이점
		//반복자
		Iterator ir = v.iterator();
		//The returned iterator is fail-fast.		//배열 추가 수정 등이 되면 그 즉시 바로 예외발생
		
		//	열거자
		//hasMoreElements() 요소가 더있다면 true
		Enumeration en= v.elements();
		while (en.hasMoreElements()) {
			//											nexrElement(): 다음 요소를 얻어오는 메서드
			String name = (String) en.nextElement();
			System.out.println(name);
		}
		
		//String delname = (String) v.remove(0);	//제거된 객체 반환
		//v.removeElementAt(0);//void
		
		//v(벡터) null요소 제거한 나머지 요소 출력
		v.removeIf(n -> n==null);
		System.out.println(v);
		
		//메서드 참조
		//v.forEach(System.out::println);
		//		ㄴ	v.forEach(n->System.out.println(n));
		//	v.clear();
		//v.clone();
		//v.firstElement();	== v.get(0);
		//v.lastElement(); == v.get(v.size()-1);
		//v.insertElementAt("임경재", 1);	== v.add(1, "임경재");
		//v.listIterator() ArrayList	
		List subList = v.subList(1, 2);
		System.out.println(subList);
		
		
		
	} // main
	
	
	
	
	
}
