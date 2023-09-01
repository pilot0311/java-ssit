package days18;

public class Ex09_02 {

	public static void main(String[] args) {
		
		//StringBuffer sb = new StringBuffer("SELECT ");
		//sb.append("a.ano ");
		//sb.append("e.code_name as cancelYn ");
		
		String s = "안녕하세요. 홍길동입니다. 홍길동입니다. 홍길동입니다.";
		//두번째 "홍길동" 문자열 찾아서 "XYZ" 로 변경
		//int index = 15;
		//s = s.substring(0, index) + "XYZ" + s.substring(18);
		//System.out.println(s);
		
		//StringBuffer, StringBuilder는 새로운 객체 생성 x
//		StringBuffer sb = new StringBuffer(s);
//		int index = sb.indexOf("홍길동",0);
//		index = sb.indexOf("홍길동", index+3);
//		sb.delete(index, index+3);
//		sb.insert(index, "XYZ");	//특정 위치에 문자 삽입
//		System.out.println(sb);
		
		// 사용법은 둘다  거의 동일함
		StringBuilder sb = new StringBuilder(s);
		int index = sb.indexOf("홍길동",0);
		index = sb.indexOf("홍길동", index+3);
		sb.delete(index, index+3);
		sb.insert(index, "XYZ");	//특정 위치에 문자 삽입
		System.out.println(sb);
	} // main
}
