package days25;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author pilot
 * @date 2023. 8. 17. - 오전 11:44:19
 * @subject	스레드 + 네트워크 X
 * @content	*람다식과 스트림*
 * 					[자바 입출력(IO)]
 */
public class Ex05 {

	public static void main(String[] args) throws IOException {
		/*
		 * 	1.	IO = Input + Output
		 * 				 입력	 +	  출력 = 입출력
		 * 	2.		[컴퓨터(프로그램)]		-->송신	[외부 장치(프로그램)]
		 * 			[컴퓨터(프로그램)]		<--수신	[외부 장치(프로그램)]
		 * 			프로그램 간에 데이터를 주고 받는 것
		 * 	3.	두 장치를 연결해 주는 객체가 필요 : 스트림(stream)
		 * 	4.	스트림 : 데이터를 운반하는 통로. (빨대)
		 * 		1)	흐르는 물
		 * 		2)	단방향
		 * 			ㄱ.	읽기(입력용) 스트림
		 * 			ㄴ.	쓰기(출력용) 스트림
		 * 	5.	연속적인 데이터의 흐름
		 * 	6.	자바의 모든 입출력은 스트림(stream)이라는 개념으로 이루어진다
		 * 	7.	예)
		 * 			키보드장치 -> 수신 -> [프로그램처리] -> 송신 -> 모니터
		 * 		(표준입력장치)						기준						(표준출력장치)
		 * 			system.in										systeom.out(스트림)	
		 * 	8.	자바의 스트림 2가지 종류 구분
		 * 		1)	문자(텍스트)스트림
		 * 				최상위 부모 클래스 : Reader	(입력용 스트림)
		 * 				최상위 부모 클래스 : Writer		(출력용 스트림)
		 * 
		 * 				1문자 == 유니코드 2바이트 = char
		 * 				한 문자, 문자열, 문자 배열
		 * 
		 * 				xxxReader
		 * 				xxxWriter
		 * 				FileReader		문자 단위로 처리하는 입력용 스트림
		 * 				FileWriter		문자 단위로 처리하는 출력용 스트림
		 *				BufferedReader		문자 단위로 처리하는 입력용 스트림(라인 단위 처리)
		 *				BufferedWriter		문자 단위로 처리하는 출력용 스트림(라인 단위 처리)
		 * 		2)	바이트(이진)스트림
		 * 				최상위 부모 클래스 : InputStream	(입력용 스트림)
		 * 				최상위 부모 클래스 : OutputStream		(출력용 스트림)
		 * 	
		 * 				1바이트(8비트)
		 * 				바이트, 바이트 배열, 정수(int)	
		 * 				InputStream is = System.in;	//	바이트 스트림
						int nextByte = System.in.read();	// 	0~255  -1		byte: -128~127
						
		 * 				XXXInputStream
		 * 				XXXOutputStream
		 * 
		 * 	9.	보조스트림 - 어떤 스트림의 IO를 더 쉽도록 보조 역활을 하는 스트림
		 */
		
		
		//FileReader;	파일 읽기(입력용) 문자 스트림
		//FileWriter;		파일 쓰기(출력용)  문자 스트림
			
		//FileInputStream;	파일 읽기(입력용) 바이트 스트림
		//FileOutputStream;	파일 쓰기(출력용) 바이트 스트림
		
		//BufferedReader;
		//BufferedWriter;
		//BufferedInputStream;
		//BufferedOutputStream;
		
	} // main
	
}
