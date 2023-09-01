package days17;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author pilot
 * @date 2023. 8. 4. - 오후 5:02:57
 * @subject 파일 읽어서 출력 + try ~ catch ~ finaly
 * @content
 */
public class Ex02 {

	public static void main(String[] args) {
		String fileName = "C:\\Setup.log";
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
			int one;
			while ((one = fr.read()) != -1) {
				System.out.printf("%c", (char)one);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} // if
		}

	} // main
}
