package days26;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author pilot
 * @date 2023. 8. 18. - 오전 10:37:25
 * @subject		Piped[Reader] / Piped[Writer]
 * @content		- 스레드 간에 데이터를 입/출력 할때 사용하는 스트림
 * 						[ Random Aceess File ]
 * 						  랜덤하게 + 접근	+ 파일 스트림
 * 						- 파일의 어느 위치에나 [읽기/쓰기]가 가능한 장점이 있는 스트림
 *							DataOutput, DataInput
 *							출력스트림	   입력스트림
 *							- seek(위치)
 *							- getFilePointer() 파일포인트 //내가 현재 있는 위치
 *							- readXXX()
 *							- writeXXX()
 */
public class Ex05 {

	public static void main(String[] args) throws IOException {

		String s = "I Love normal Java";
		String q = "javabook";

		String name = ".\\src\\days26\\random.txt";
		String mode = "rw"; // read, write
		
		try (RandomAccessFile raf = new RandomAccessFile(name, mode);) {
			long cp = raf.getFilePointer();
			raf.writeBytes(s);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 일시 정지 + 엔터 계속
		System.out.println(">엔터치면 진행");
		System.in.read();
		System.in.skip(System.in.available());

		try (RandomAccessFile raf = new RandomAccessFile(name, mode);) {
			// 임위의 위치로 이동 - 읽기/쓰기
			raf.seek(7);
			raf.writeBytes(q);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 일시 정지 + 엔터 계속
		System.out.println(">엔터치면 진행");
		System.in.read();
		System.in.skip(System.in.available());

		try (RandomAccessFile raf = new RandomAccessFile(name, mode);) {
			// 임위의 위치로 이동 - 읽기/쓰기
			raf.seek(2);
			String line = raf.readLine();
			System.out.println(line);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	} // main

}
