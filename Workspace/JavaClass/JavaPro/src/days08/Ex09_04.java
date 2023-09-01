package days08;

import java.util.Random;

public class Ex09_04 {

	public static void main(String[] args) {
		//람다식 과 스트림
		
		new Random().ints(1,46).distinct().limit(6).sorted()
		.forEach(System.out::println); 	//메서드 참조
		//.forEach(n->System.out.println(n));	//-> 람다 연산자
	} // main
}
