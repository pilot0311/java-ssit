package days25;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author pilot
 * @date 2023. 8. 17. - 오후 3:51:03
 * @subject 실행파일(exe, dll, mp4 등등) 복사
 * @content	바이트 스트림
 * 					FileInputStream
 * 					FileOutputStream
 * 					BufferedInputStream
 * 					BufferedOutputStream
 */
public class Ex07_05 {

	public static void main(String[] args) {
		// 파일 복사
		String pathname = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		String copyPathname = "C:\\Users\\user\\Documents\\chrome_copy.exe";
		//>복사 처리 시간 : 29914300(ns)
		//>복사 처리 시간 :     947900(ns)		
		//fileCopy_byteStream(pathname, copyPathname);
		//> 파일 복사 처리 시간 : 18724143900(ns)
		fileCopy_byteStream02(pathname, copyPathname);	//보조 스트림 사용
		//> 파일 복사 처리 시간 : 27718300(ns)
		
		
	} // main

	private static boolean fileCopy_byteStream02(String pathname, String copyPathname) {
		long start = System.nanoTime();
		final int BUFFER_SIZE = 1024;
		
			//버퍼 기능 + 보조 스트림 사용해서 파일 복사
		try(FileInputStream fis = new FileInputStream(pathname);
			 FileOutputStream fos = new FileOutputStream(copyPathname, true);
				//버퍼 기능이 있는 보조 스트림
			 BufferedInputStream bis = new BufferedInputStream(fis, BUFFER_SIZE);
			 BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER_SIZE)) {
			
			byte[] b = new byte[BUFFER_SIZE];
			int readByteNumber = -1;
			
			while ((readByteNumber=bis.read(b)) != -1) {
				bos.write(b, 0, readByteNumber);
			}
			bos.flush();
			
			System.out.println("파일 복사 완료");
			long end = System.nanoTime();
			System.out.printf(">복사 처리 시간 : %d(ns)\n",(end-start));	
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	private static boolean fileCopy_byteStream(String pathname, String copyPathname) {
		long start = System.nanoTime();
		
		//BufferedInputStream bis = new BufferedInputStream(fis);BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE)
			//버퍼 기능 + 보조 스트림 사용해서 파일 복사
		try(FileInputStream fis = new FileInputStream(pathname);FileOutputStream fos = new FileOutputStream(copyPathname, true);
				) {
			
			int b;
			while ((b = fis.read()) != -1) {
				fos.write(b);
			}
			
			
			
			
			System.out.println("파일 복사 완료");
			long end = System.nanoTime();
			System.out.printf(">복사 처리 시간 : %d(ns)\n",(end-start));	
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
}
