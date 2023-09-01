package days19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex10 {

	public static void main(String[] args) {

		// 정규표현식(Regular Expression) == 정규식 (regex)
		// - 문자열 속에 원하는 조건(패턴)과 일치하는 문자열을 찾아내기 위해서 사용
		// - 미리 정의된 기호
		// - 자바 정규표현식고 관련 클래스 2개 밖에 없다.
		// string.matches(regex) == String 클래스의 것
		// 1) Pattern 클래스
		// 2) Macher 클래스

		String[] data = { "bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date", "disc", "fx" };
		//	1)	data 배열에 들어있는 단어들 중에 c로 시작하는 단어를 모드 찾아서 출력
		
//		String regex = "c.*";					//c다음에 아무 문자 1개이상 오거나 없거나
//		String regex = "c[a-zA-Z]*";		//c다음에 영어가 한개 이상 오거나 아무문자도 없거나
//		String regex = "c[a-z]";			//c다음에 소문자가 한개 와야함	(2문자)
//		String regex = "c\\w";				//	\\w == [a-zA-Z0-9]		
//		String regex = ".*";					// 모든 문자 0개 이상
//		String regex = "c.*t";				// c로 시작하고 t로 끝나고 그사이에 아무문자나 0개이상 있다
//		String regex = "c\\d";				// \\d = [0-9] 0~9		
//		String regex = "c\\D";				//  \\D = [^0-9]  숫자가 아니여야한다
//														//	\\s 공백	\\S	(!공백)공백이 아니여야한다
//		String regex = "(b|c).*";				//	b가 오던지 c가 오던지 == [bc].*
//		String regex = "[bcd].*";				//	b가 오던지 c가 오던지 d가 오던지 == [b-d].*
//		String regex = "[a-zA-Z && [^b-d]].*";	//알파벳 대소문자 중에 b c d문자 제외 + 모든 문자 0개 이상
//		String regex = "[bcd].{2}";			// b가 오던지 c가 오던지 d가 오고 + 아무 문자나 2개이상 
//		String regex = "[bcd].{2,3}";		// b가 오던지 c가 오던지 d가 오고 + 아무 문자나 2개이상 3개이하
//		String regex = "[bcd].+";		// b가 오던지 c가 오던지 d가 오고 + 1개 이상
		String regex = "[bcd].?";		// b가 오던지 c가 오던지 d가 오고 + 아무 문자 0개 또는 1개
		
		Pattern p = Pattern.compile(regex);
		for (int i = 0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())System.out.println(data[i]);
		} // for
		
		
		//[1] for문 사용
//		for (int i = 0; i < data.length; i++) {
//			if(data[i].matches(regex)) {
//				System.out.println(data[i]);
//			}
//		} // for
	} // main

}
