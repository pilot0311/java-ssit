package days20;

import java.text.MessageFormat;

/**
 * @author pilot
 * @date 2023. 8. 9. - 오후 3:16:24
 * @subject		MessageFormat
 * @content		특정 형식 <- 데이터(값) 출력
 * 									->	 데이터(값) 읽기	
 */	
public class Ex10 {

	public static void main(String[] args) {
		String name = "김철수";
		int age = 20;
		boolean gender = true;
		
		/*
		//	위의 데이터 들을 특정 형식으로 출력
		 * [1]
		String output =  String.format("이름: %s, 나이: %d, 성별: %s", name,age,gender);
		System.out.println(output);
		*/
		// [2]MessageFormat
		//이름: 김철수, 나이: 20살, 성별: true
		String pattern = "이름: {0}, 나이: {1}살, 성별: {2}";
		String output = MessageFormat.format(pattern, name, age, gender);
		System.out.println(output);
		
		//SQL
		//"Insert INTO (no, title, writer, content, redgate) Values ({0}, '{1}', '{2}', '{3}', {4})"
	} // main
	
}
