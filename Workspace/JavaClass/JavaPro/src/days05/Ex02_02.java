package days05;

public class Ex02_02 {
	public static void main(String[] args) {
		
		//char -> String 변환
		// 1) 'a' + "";
		// 2) String.valueOf('a');
		// 3) Character.toString('a');
		
		//String -> char 변환
		String name = "pilot";
		//내가 원하는 위치의 한 문자를 얻어 오고 싶다
		// 문자열.charAt(index); 리턴값:char
		System.out.println(name.length()); //- .length() 크기 
		int len = name.length();
		for (int i = 0; i < len; i++)
			System.out.print(name.charAt(i));	
		
		
		//문자열 다루는 메서드(함수)
		// 1. split()
		// 2. length()
		// 3. charAt();
		// 4. valueOf()
		// 5. toString()
		// 6. toCharArray() -> char nameArr[] = new char[name.length()];
//										for (int i = 0; i < nameArr.length; i++) {
//										nameArr[i] = name.charAt(i);
//	} // for
		
	} // main
}
