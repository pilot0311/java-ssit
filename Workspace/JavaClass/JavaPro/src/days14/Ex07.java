package days14;

import java.util.Iterator;

/**
 * @author pilot
 * @date 2023. 8. 1. - 오후 2:11:34
 * @subject static 키워드
 * @content 필드 앞에 메서드 앞에 클래스 앞에
 */
public class Ex07 {

	public static void main(String[] args) {
		// 우리반 -> 기업은행 -> 보통예금
		// 클래스 선언 : 저축
		//인스턴스 변수 - 객체명.필드, 객체명.메서드 
		//클래스 변수 - 클래스명.static변수
		
		//rate 이자율 왜 static 필드로 선언 했는가?
		//==Static 필드는 언제 사용하는가? 
		//==모든 인스턴스가 공유해서 사용할 필요가 있을때
		
		//	2.	정적(static)메서드 언제 사용하는가?
		//		1) static필드에 접근하기 위해서
		//		2)	
		
		//The field Save.rate is not visible  = private로 선언 하여 Save 클래스 외에 사용 불가
		//System.out.println(Save.rate);
		
		System.out.println(Save.getRate());
		
		System.out.println();
		
		Save s1 = new Save("dwsa",1000,0.04);
		Save s2 = new Save("afad",1500,0.04);
		Save s3 = new Save("qwer",1200,0.04);
		Save s4 = new Save("zasd",15000,0.04);
		Save s5 = new Save("gsqs",3500,0.04);
		
		//Save.setRate(0.08);
		s1.setRate(0.06);
		s1.dispSave();
		s2.dispSave();
		s3.dispSave();
		s4.dispSave();
		s5.dispSave();

		// 클래스 배열
//		Save[] ss = new Save[5];
//		ss[0] = new Save("dwsa",1000,0.04);
//		ss[1] = new Save("afad",1500,0.04);
//		ss[2] = new Save("qwer",1200,0.04);
//		ss[3] = new Save("zasd",15000,0.04);
//		ss[4] = new Save("gsqs",3500,0.04);

//		Save[] ss = { new Save("dwsa", 1000, 0.04), new Save("afad", 1500, 0.04), new Save("qwer", 1200, 0.04),
//				new Save("zasd", 15000, 0.04), new Save("gsqs", 3500, 0.04) };
		
//		for (int i = 0; i < ss.length; i++) {
//			ss[i].dispSave();
//		} // for
		
		//[파악] 모든 사람의 이자율은 동일
		//Save 객체가 생성될 때 마다 rate(8byte) 필드는 필요 없음
		//Save 클래스 당 1개만 rate 필드 생성 해서 모든 인스턴스(객체)가 공유해서 사용할 필드를 선언
	} // main
}
