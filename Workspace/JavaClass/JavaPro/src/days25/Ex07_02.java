package days25;

import java.io.File;
import java.io.FileWriter;

public class Ex07_02 {

	public static void main(String[] args) {
		// 		실행 후
		//	1.	저장할 파일명 입력	 test.txt
		//	2.	저장할 문자열(Data)입력 내일은 금요일
		//	3.	계속?
		
		// [파일 저장]
		String pathname = ".\\src\\days25\\sample.txt";
		File file = new File(pathname);
		// 파일의 존재 유무를 true, false 반환
		System.out.println(file.exists());
		
		//	파일 문자 출력용 스트림
		//														boolean append		== false면 파일 덮어쓰기, true면 이어 쓰기
		try(FileWriter fw = new FileWriter(file, false)) {
			/*
			fw.append('a')
			.append("append_string");
			
			fw.write(98);
			fw.write("writer_string");
			
			//쓰기 + 추가	fr 출력용 스트림에 쓰기 + 추가...
			//fw.flush();
			//fw.close();// 자동처리	파일스트림 close시 자동 flush
			 */
//			fw.write("\n");
			fw.write("새로 실행해서 텍스트 추가");
			
			System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
	
}
