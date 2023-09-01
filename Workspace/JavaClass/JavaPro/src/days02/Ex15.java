package days02;

/**
 * @author pilot
 * @date 2023. 7. 14. - 오후 4:03:36
 * @subject	형변환
 * @content
 */
public class Ex15 {

	public static void main(String[] args) {
		
		//String <-> byte 형변환
		//"20" -> 20으로 형변환
		//byte age = "20";
		int i = Integer.MAX_VALUE; // = 2147483647 int 자료형의 가장 큰 값을 대입
		//기본형(int)-> 물건(객체, Object, 클래스)	래퍼클래스(WrapperClass)
		//Integer
		int j = Integer.parseInt("20");
		
		//String -> byte 형변환
		byte age =Byte.parseByte("25");
//		Long.paseLong(null)
//		Short.parseShort(null)
	}

}
