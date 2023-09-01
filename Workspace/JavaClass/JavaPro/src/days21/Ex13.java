package days21;
//[시험]
import java.util.ArrayList;
import java.util.Iterator;

public class Ex13 {

	public static void main(String[] args) {
		//	1.	컬렉션 클래스	-	ArrayList
		//			ㄴ	가장 많이 사용되는 컬렉션 클래스
		//			ㄴ	List 인터페이스를 구현한 클래스
		//				(순서 유지, 중복 허용)
		//			ㄴ	배열의 요소(Element)
		//			ㄴ	배열	단점(days10.Ex03.java) -> ArrayList
		String[] names = new String[3];
		names[0] ="qwe";
		names[1] ="dwsa";
		names[2] ="afad";
//		System.out.println(names.length);	//3
//		//검색 후 조회
//		for (int i = 0; i < names.length; i++) {
//			if(names[i]=="dwsa")System.out.println(names[1]);
//		} // for
//		Arrays.fill(names, null);
		
		//ArrayIndexOutOfBoundsException	배열 크기 벗어남
		//names[3] = "zxc";
		//ArrayList list = new ArrayList();	// 아무값도 입력 안할시 초기용량 10
		ArrayList list = new ArrayList(3);	// 초기 크기 3
		
		list.add("qwe");		//list의 끝에 추가
		list.add("dwsa");		//list의 끝에 추가
		list.add("afad");		//list의 끝에 추가
		System.out.println(list.size());	//3
		list.add("zxc");		//초기 크기 3이지만 문제없이 추가됨
		System.out.println(list.contains("dwsa"));	//true
		int index = list.indexOf("dwsa");	//특정값이 들어있는 배열 위치 찾음
		if(index != -1)System.out.println(list.get(index));
		list.remove(index);	//index위치 요소 삭제
		list.add(index, "홍길동");	//삽입
		System.out.println(list);
		//list.clear();	//모든 요소 삭제
		System.out.println(list);
		System.out.println(list.isEmpty());		//true	배열이 비었다면 true
		//***iterator()***
		//	요소를 순차적으로 처리할 수 있는 반복자(Iterator)를 반환하는 메서드
		Iterator ir = list.iterator();
		//hasNext() 다음요소가 있으면 true 없으면 false
		while (ir.hasNext()) {
			//										다음 요소를 얻어오는 메서드 next()
			String name = (String) ir.next();
			System.out.println(name);
			
		}
		//list.lastIndexOf("dwsa"); //뒤에서 부터 찾음
		System.out.println(list.size());	// 요소 추가/삭제에 따라 크기 자동 변경
	} // main
}
