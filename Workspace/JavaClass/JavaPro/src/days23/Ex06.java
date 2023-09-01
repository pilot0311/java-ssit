package days23;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Ex06 {

	public static void main(String[] args) {
		/*
		 * 	Map 인터페이스를 구현한 컬렉션 클래스
		 * 	1.	key + value 한 쌍으로 관리
		 * 	2.	Entry(엔트리) = key + value 한쌍
		 * 	3.	key 중복 허용 X
		 * 		value 중복 허용 O
		 * 	4.	[Hash]Map	(신)
		 * 		[Hash]Table	(구)
		 * 	5.	HashMap을 사용 하도록 권장
		 * 	6.	해싱(Hashing)?
		 * 		-	해시함수(Hash function)를 이용해서 데이터를 해시테이블(Hash Table)에 저장하고 검색하는 기법
		 * 		-	해시함수	?	데이터가 저장되어 있는 곳을 알려주는 함수
		 * 			데이터를 빠르게 찾을 수 있다
		 * 		-	데이터 저장(key + value) 키를 해시 함수에 넣으면 배열의 한 요소를 얻어오고 다시 그 곳에 연결된 링크드 리스트에 데이터를 저장
		 * 
		 * 		-	예)
		 * 				[1990]		[][][][][][][]
		 *					: 
		 * 					:
		 * 				[2000]		[][][][]
		 */
		//					id			name
		//	HashMap과 Hashtable 사용법 동일
		//HashMap<String, String> hm = new HashMap<>();	// 동기화 처리 X	ArrayList
		Hashtable<String, String> hm = new Hashtable<>();	//	동기화 처리O	Vector
		hm.put("admin", "관리자");
		hm.put("hong", "홍길동");
		
		System.out.println(hm);		//{admin=관리자, hong=홍길동}
		hm.put("hong", "홍중복");
		System.out.println(hm);		//{admin=관리자, hong=홍중복} 키가 중복될때 에러발생X 새로운 value로 저장
		
		hm.put("root", "관리자");
		System.out.println(hm);		//{admin=관리자, root=관리자, hong=홍중복} value는 중복이어도 상관 없음
		System.out.println("-".repeat(50));
		
		//모든 key 조회
		Set<String> kSet = hm.keySet();
		Iterator<String> ir = kSet.iterator();
		while (ir.hasNext()) {
			String key = ir.next();
			System.out.println(key);
			
		}
		System.out.println("-".repeat(50));
		
		//hm.containsKey("hong");	//key가 포함되어 있는지		true, false
		//hm.containsValue("홍중복");	//value가 포함되어 있는지true, false
		
		String value = hm.get("root");
		value = hm.getOrDefault("kim", "익명");		//kim이라는 키가 있으면 kim의 밸류 반환 없으면 default(익명)반환
		
		hm.replace("root", "관리자", "루트");
		
		//모든 value 조회
		Collection<String> vSet =hm.values();
		Iterator<String> ir2 = vSet.iterator();
		while (ir2.hasNext()) {
			 value = ir2.next();
			System.out.println(value);
		}
		System.out.println("-".repeat(50));
		
		//root 키를 알때 value 조회
		 value = hm.get("root");
		System.out.println(value);
		System.out.println("-".repeat(50));
		
		
		dispHm(hm);
		
	} // main
	//[1]
//	private static void dispHm(Hashtable<String, String> hm) {
//		//ket		:	value 형식으로 출력
//		Set<String> kSet = hm.keySet();
//		Iterator<String> ir = kSet.iterator();
//		while (ir.hasNext()) {
//			String key = ir.next();
//			String value = hm.get(key);
//			System.out.printf("%s : %s\n",key,value);
//			
//		}
//	}
	
	//[2]
	private static void dispHm(Hashtable<String, String> hm) {
	//ket		:	value 형식으로 출력
		/*
		 * admin : 관리자
			root : 관리자
			hong : 홍중복
		 */
		Set<Entry<String, String>> eset = hm.entrySet();
		Iterator<Entry<String, String>> ir = eset.iterator();
		while (ir.hasNext()) {
			Entry<String, String> entry =  ir.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.printf("e %s\t :\t %s\n",key,value);
		}
	}
	
	
}
