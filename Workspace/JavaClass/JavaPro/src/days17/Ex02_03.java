package days17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author pilot
 * @date 2023. 8. 4. - 오후 5:02:57
 * @subject 파일 읽어서 출력 + try ~ catch ~ finaly
 * @content 한 문자 <- int fr.read() 한 라인 <- BufferdeReader
 */
public class Ex02_03 {

	public static void main(String[] args) {
		String fileName = "C:\\Setup.log";
		try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr);) {
			String line = null;
			int lineNumber = 1;
			while ((line = br.readLine()) != null) {
				System.out.printf("%d: %s\n", lineNumber++, line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main
}
