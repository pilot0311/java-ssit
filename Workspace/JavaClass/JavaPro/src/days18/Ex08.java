package days18;

public class Ex08 {

	public static void main(String[] args) {
		//문자열 다루는 클래스
		//String					:	변경 불가능한 클래스	***
		//StringBuffer
		//StringBuilder
		//StringTokenizer	
		
		String name = "wqe";	//new String("wqe");
		name += "wq";			//한번 만들어진 문자열은 변경불가 +연산자로 새로운 문자열 추가시 새 객체 생성
		System.out.println(name);
		
		//	1.	
		System.out.println(name.length());	//5
		
		//	2.	name.length		필드	x
		//	2.	name.length()		메서드
		for (int i = 0; i < name.length(); i++) {
			System.out.printf("name[%d]= '%c' \n",i,name.charAt(i));
		} // for
		
		//	3.
		String rrn = "123456-1234567";
		System.out.println(rrn.substring(rrn.length()-1));	//"7"
		System.out.println(rrn.substring(7));	//"1234567"
		//beginIndex<=		<endIndex
		System.out.println(rrn.substring(0,2));	//"12"
		
		//	4.	정규식 패턴 일치 여부 체크 : String.matches
		String regex = "\\d{6}-\\d{7}";
		System.out.println(rrn.matches(regex));
		
		//	5.	concat()
		String a = "ㅁㅁㅁ" + "ㅠㅠㅠ";
		String b = "ㅁㅁㅁ".concat("ㅠㅠㅠ").concat("ㅁㅁㅁ");
		
		//	6.
		//tream rrn.chars();
		
		//	7.	0이면 동일한 문자열
		//	-32	다른 문자열
		//	 32	다른 문자열
		//	"A" 65  "a" 97	== -32
		//	"a" 97  "A" 65	== 32
		
		System.out.println("kEnik".compareTo("kenik"));		//0이면 같은 문자
		System.out.println("kEnik".compareToIgnoreCase("kenik"));		//대소문자 상관없이 비교 , A와a는 같은걸로 취금
		
		//	8.	같으면 true, 다르면 false 반환
		System.out.println("kEnik".equals("kenik"));	
		System.out.println("kEnik".equalsIgnoreCase("kenik"));	//대소문자 상관없이 비교 , A와a는 같은걸로 취금
		
		//	9. 특정 문자열 포함하고 있는지 있으면 true, 없으면 false
		System.out.println("안녕하세요. dwsa".contains("안녕"));
		
		//	10. endsWith: 특정 문자열로 끝나면 true 아니면 false
		//	10. startsWith: 특정 문자열로 시작하면 true 아니면 false
		String url = "http://www.naver.com/test.jsp";
		String sufix = ".html"; //접미사
		String prefix = ".html"; //접미사
		System.out.println(url.endsWith(sufix));
		System.out.println(url.startsWith(prefix));
		
		//	11.
		
		//int [] m = {3,5,2,4,1};
		//System.out.println(m.length);	//m.length 필드
	} // main
}
