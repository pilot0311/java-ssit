package days19;
import java.util.Objects;
import java.util.Random;

public class Ex08 {

	public static void main(String[] args) {
		//	Arrays 클래스 배열 기능이 구현된 클래스
		//	Objects 클래스	객체를 다루는 기능이 구현된 클래스
		Ex08 obj = null;
		
		//if(obj != null) 
		
		//Objects.isNull(obj); 		//obj 객체가 null일때 true 반환 isNull()
		//Objects.nonNull(obj);		//obj 객체가 null이 아닐때 true 반환 nonNull
		
//		if(obj == null) {
//			new ~~~Exception("예외 메세지;)
//		}
//		this.name = name;
		// 위와 아래는 같은 코딩
//		this.name = Objects.requireNonNull(name, "예외메세지");
		
		//if(a != null && a.equals(b)){}
		//if(Objects.equals(a,b)){} 위와 같은 코딩
		
		//java.util.Random 클래스
		Random rnd = new Random();
		rnd.nextBoolean(); 	//랜덤으로 true/false 값 반환
	//	rnd.nextInt(bound);	// 0<= 사이의 랜덤한 정수 < bound
		
	} // main
	
}
