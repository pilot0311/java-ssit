package days22;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex03_02 {
	//[3-2]
	public static void main(String[] args) {
		String t1 = "이경서, 신종혁, 이재영, 송해영 , 신기범, 이준희, 김성준 ";
		String[] t = t1.split("\\s*,\\s*");
		ArrayList team = new ArrayList();
		for (int i = 0; i < t.length; i++) {
			team.add(t[i]);
		} // for
		
		disp(team);

		System.out.println();
		System.out.println(team.size());	//요소의 갯수 	7
		//team.trimToSize();		//	크기를 요소의 갯수에 맞게 바꿈  
		
		System.out.println(team.get(1));
		team.set(1, "홍길동");
		System.out.println(team);
		
		if (team.contains("홍길동")) {
			team.remove( team.indexOf("홍길동"));		//요소 삭제후 삭제된 요소를 반환함
			System.out.println(team);
		} //if
		
		String regex = "김.+";

		
		
		String s;	
		for (int i = 0; i < team.size(); i++) {
			s = (String) team.get(i);
			if (s.startsWith("김")) {
				team.remove(i);
			} //if
		} // for
		System.out.println(team);
	} // main

	private static void disp(ArrayList team) {
		Iterator ir = team.iterator();
		while (ir.hasNext()) {
			String s = (String) ir.next();
			System.out.printf("%s ",s);
		}
		
	}
	
}
//ArrayList 에 대해서 설명하세요 .
//3-2. ArrayList 컬렉션 클래스를 사용해서
//  1) 팀원들의 이름을 요소로 추가  
//  2) 반복자를 사용해서 모든 요소(팀원들) 출력 
//  3) 팀원들의 인원수를 출력
//  4) 두 번째 팀원이 누구인지 확인 후 "홍길동" 팀원으로 수정
//  5) "홍길동" 팀원의 존재 유무를 확인 후 삭제
//  6) "김"씨 팀원들만 삭제 후 확인.