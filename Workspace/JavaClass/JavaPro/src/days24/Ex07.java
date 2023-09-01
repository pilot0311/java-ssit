package days24;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author pilot
 * @date 2023. 8. 16. - 오후 2:35:34
 * @subject		제네릭스,	어노테이션,	열거형,	자바IO
 * @content		스레드 + 네트워크	X
 * 						람다식과 스트림		X
 */
public class Ex07 {

	public static void main(String[] args) {
		
		/*
		 * 	[ 제네릭(Generics) ]
		 * 	1.	jdk 1.5	- 제네릭
		 * 		jdk 1.8 - 람다식
		 * 	2.	제네릭이란?
		 * 		다양한 타입의 객체를 다루는 메서드, 컬렉션 클래스에서 
		 * 		컴파일시 타입을 체크해 주는 기능
		 * 
		 * 	3.	왜? : 객체의 타입을 컴파일 시에 체크하기 때문에 (1)객체의 타입 안전성을 높이고, 
		 * 				(2)형 변환의 번거로움이 줄어든다	->	코드가 간결해 진다
		 * 				(제네릭의 장점)
		 * */
		/*
		//제네릭 안쓸경우
		ArrayList list = new ArrayList();	//이름만 입력
		list.add("홍길동");
		
		//String <- Object.get() 다운 캐스팅 (형변환)		(2)번 형 변환의 번거로움
		String name = (String) list.get(0);
		System.out.println(name);
		
		list.add(20);		//(1) 안전성 
		//int <- Integer <- Object
		int age = (int) list.get(1);
		System.out.println(age);
		
		list.add(true);
		list.add('A');
		*/
		
		//제네릭 클래스	<E>	== 클래스 탑입만 가능 ex) int안됨 Integer 가능
		ArrayList<String> list = new ArrayList<>();
		list.add("홍길동");	
		list.add("김정주");	
		list.add("이지현");	
		list.add("김호영");	
		//list.add(20);		//String만 입력 받음 int형 오류
		//String name = list.get(0);	//제네릭 쓸경우 다운캐스팅 필요 X
		//System.out.println(name);
		
		
//		Iterator ir = list.iterator();
//		while (ir.hasNext()) {
//			String name = (String) ir.next();	//Iterator도 제네릭 타입 명시 안할시 다운캐스팅 해야함
//			System.out.println(name);
//		}
		
		
		Iterator<String> ir = list.iterator();
				while (ir.hasNext()) {
					String name =  ir.next();	//Iterator도 제네릭 타입 명시시 다운캐스팅 안해도됨
					System.out.println(name);
				}
		
	} // main
	
}
