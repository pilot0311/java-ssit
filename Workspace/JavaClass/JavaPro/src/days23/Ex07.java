package days23;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Ex07 {

	public static void main(String[] args)  {
		//days20.Ex01.java 파일 읽어서 HashMap에 저장
		//	key	:	value
		//	'a'		:	10
		//	'b'		:	15
		
		String fileName = ".\\src\\days20\\Ex01test.java";
		int code = -1;
		char one ='\u0000';
		String s;
		HashMap<Character, Integer> hmap = new HashMap<>();
		
		try(FileReader fr = new FileReader(fileName)) {
			
			while ((code = fr.read()) != -1) {
				one = (char)code;
				//System.out.println(one);
				//읽어온 한 문자(key)가 hmap에 존재 한다면 value값을 1증가 시키고 없다면 새로 entry추가
				/*
				if (hmap.containsKey(one)) {
					int value = hmap.get(one);
					hmap.put(one, value+1);
				} else {
					hmap.put(one, 1);
				}//if
				*/
//				if ((s=String.valueOf(one)).matches("[a-zA-Z]")) {	//영어만
					hmap.put(one, hmap.getOrDefault(one, 0)+1);
//				} //if
				
				
			}//while
			//정렬
			List<Character> set = new ArrayList<Character>(hmap.keySet());
			Collections.sort(set);
			// set을기준으로 출력
			
			Iterator<Character> ir2 = set.iterator();
			while (ir2.hasNext()) {
				Character c =  ir2.next();
				System.out.printf("'%c'",c);
				System.out.printf("(%d)\n",hmap.get(c));
			}
			
			
			//ket	value
			//'A' (20)	###########
//			Set<Entry<Character, Integer>> eset = hmap.entrySet();
//			Iterator<Entry<Character, Integer>> ir = eset.iterator();
//			while (ir.hasNext()) {
//				Entry<Character, Integer> entry = ir.next();
//				char key = entry.getKey();		//	Character -> 언박싱 char
//				int value = entry.getValue();		//	Integer	->	언박싱	 int
//				System.out.printf("'%c'(%d) %s\n",key,value,"#".repeat(value));
//			}
//		//0~9 A~Z a~z	가~힣
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
	
}
