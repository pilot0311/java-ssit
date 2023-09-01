package days18;

public class Ex08_04 {

	public static void main(String[] args) {
		String s = "안녕하세요. 홍길동입니다. 홍길둥이고, 홍길도입니다. 홍길.입니다.";
		//"홍길동" -> hong.gildong
		//s = s.replaceFirst("홍길동", "hong.gildong"); 첫번쨰 홍길동만 바뀜
		//s = s.replaceAll("홍길동", "hong.gildong");	//모든 홍길동이 바뀜
		//s = s.replaceAll("홍길.", "hong.gildong");	//정규표현식 . : 임의의 한 문자
		//s = s.replaceAll("홍길[가-힣]", "hong.gildong");	//정규표현식 [가-힣] : 가~힣 사이의 한 문자
		//s = s.replace('홍', '강');		//char: '홍' 한문자를 '강'으로 바꿈
		//s = s.replace("홍길도", "XYZ");
		
		
		//CharSequence 에 String 문자열 == 업캐스팅
		//CharSequence target = "홍길도";
		CharSequence target = new StringBuffer("홍길도");
		s = s.replace(target, "XYZ");		//CharSequence 에 String 문자열 == 업캐스팅
		System.out.println(s);
	} // main
}
