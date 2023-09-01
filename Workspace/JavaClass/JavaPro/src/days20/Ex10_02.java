package days20;

import java.text.MessageFormat;
import java.text.ParseException;

/**
 * @author pilot
 * @date 2023. 8. 9. - 오후 3:16:24
 * @subject MessageFormat
 * @content 특정 형식 <- 데이터(값) 출력 -> 데이터(값) 읽기
 */
public class Ex10_02 {

	public static void main(String[] args) {
		// 특정 형식 -> 데이터(값) 읽기
		String source = "이름: 김철수, 나이: 20살, 성별: true";
		String pattern = "이름: {0}, 나이: {1}살, 성별: {2}";
		MessageFormat mf = new MessageFormat(pattern);
		try {
			Object[]objs = mf.parse(source);
			for (Object obj : objs) {
				System.out.println(obj);
			} //foreach
		} catch (ParseException e) {
			e.printStackTrace();
		}

	} // main

}
