package days18;

import java.util.Arrays;

public class Ex08_03 {

	public static void main(String[] args) {
		//	11.
		String s = "안녕하세요. 입니다. 입니다. 입니다.";
		String name = "홍길동";
//		// 첫 번째 "입니다" 앞에 "홍길동"		"안녕하세요. 홍길동입니다. 입니다. 입니다."
//		int index = s.indexOf("입니다");	//int형이 와야하지만 char형을써도 자동 형변환이 되기에 쓸수있다
//		s= s.subSequence(0, index) + name + s.substring(index);
//		System.out.println(s);
		
		//(문제)
		//마지막 "입니다"에 + "홍길동"
//		int index =  s.lastIndexOf("입니다");
//		System.out.println(index);
//		s= s.subSequence(0, index) + name + s.substring(index);
//		System.out.println(s);
//		
//		int formIndex = 0;
//		int index = s.indexOf("입니다",formIndex);
//		formIndex = index + "입니다".length();
//		int secondIndex = s.indexOf("입니다", formIndex);
//		System.out.println(secondIndex);
		
		int fromIndex = 0;
		int index = -1;
		while ((index = s.indexOf("입니다", fromIndex)) != -1) {
			System.out.println(index);
			fromIndex = index + "입니다".length();
		}
		//메서드	: indexOf		메서드명 insert 만들어보기 **
		//매개변수	:	String target,	String sw,	int no
		//리턴값	:	int index
		
		"abc".toUpperCase();	//	"ABC"
		"Abc".toLowerCase();	//	"abc"
		
		//String [] "홍길덩, 김길동, 이길동, 박길동".split(regex)
		
		String [] nameArr =  "홍길덩,김길동,이길동,박길동".split(",", 2);
				for (int i = 0; i < nameArr.length; i++) {
					System.out.println(nameArr[i]);
				} // for
	} // main
	
	public static int insert(String s, String name) {
		
		
		
		return 0;
	}
}
