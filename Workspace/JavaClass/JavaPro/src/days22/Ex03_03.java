package days22;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex03_03 {
	//[3-2]
	public static void main(String[] args) {
		String t1 = "이경서, 신종혁, 이재영, 송해영 , 신기범, 이준희, 김성준 ";
		String[] t = t1.split("\\s*,\\s*");
		ArrayList team = new ArrayList();
		for (int i = 0; i < t.length; i++) {
			team.add(t[i]);
		} // for
		// "이"씨만 삭제
		team.removeIf(n->((String) n).charAt(0)=='이');
		
		System.out.println(team);
		//.removeIf( -> a%2 == 1);
		//[출처] [Java/자바] - ArrayList.removeIf(predicate<? super E> filter)|작성자 주현


		
	} // main

	
}