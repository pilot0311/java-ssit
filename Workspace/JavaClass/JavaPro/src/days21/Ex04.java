package days21;

import java.text.MessageFormat;
import java.text.ParseException;

public class Ex04 {

	public static void main(String[] args) throws ParseException {
		// [7]
		String source = "번호:1,이름:홍길동,주소:서울 양천구 목동";

		int no;
		String name;
		String addr;

		// MessageFormat xx
//		int index = source.indexOf("이름:");
//		int beginIndex = index + "이름:".length();
//		int endIndex = source.indexOf(",",index);
//		name = source.substring(beginIndex,endIndex);
//		System.out.println(name);

		// MassageFormat.format(pattern,args); format은 객체 생성 필요 없음
		String pattern = "번호:{0},이름:{1},주소:{2}";
		MessageFormat mf = new MessageFormat(pattern);
		Object[] objArr = mf.parse(source);
		//ClassCastException: 클래스 형변환 안됨
		//(	) cast 연산자, 강제 형변환
		
		//no = Integer.parseInt((String) objArr[0]);
		no = Integer.parseInt(objArr[0].toString());
		name = (String) objArr[1];
		addr = (String) objArr[2];
		
		System.out.printf("%d %s %s",no,name,addr);

	} // main
}
