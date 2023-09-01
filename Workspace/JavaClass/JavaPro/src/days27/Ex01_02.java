package days27;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author pilot
 * @date 2023. 8. 18. - 오후 4:42:12
 * @subject		직렬화 		객체를 스트림으로 만드는 것
 * @content		역직렬화		스트림 -> 객체로 만드는 것
 * 						- 객체를 직렬화해서 읽기 / 쓰기 할 수 있는 바이트 스트림
 * 						Object[InputStream]		//보조 스트림
 * 						Object[OutputStream]
 * 						- 직렬화가 가능한 클래스로 만들기 위해서 단지
 * 							ㄴ Serializable 인터페이스를 구현만 하면 된다.
 * 
 */
public class Ex01_02 {

	public static void main(String[] args) {
		//student 클래스 -> 객체 -> 파일저장
		
		
		String pathname = ".\\src\\days27\\Child.ser";
		
		try(FileInputStream in = new FileInputStream(pathname);ObjectInputStream ois = new ObjectInputStream(in)) {
			
			//ois 스트림 -> Child c 객체 (역직렬화)
			Child c = (Child) ois.readObject();
			
			System.out.println(c.name);
			System.out.println(c.age);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
	
}
