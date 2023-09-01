package days26;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.util.FileUtil;

/**
 * @author pilot
 * @date 2023. 8. 18. - 오후 4:09:34
 * @subject 하나의 파일을 분할
 * @content
 */
public class Ex06_08 {

	public static void main(String[] args) {
		String parent = ".\\src\\days26";
		String child = "시간표_(5강의실)(디지털컨버전스)AWS 클라우드와 Elasticsearch를 활용한 Java(자바) Full-Stack 개발자 양성과정(I).v1.hwp";
		
		File f = new File(parent, child);
		// >파일 크기 : 293376bytes
		System.out.println(">파일 크기 : " + f.length() + "bytes");

		// 10kb = 1024 * 10byte
		final int VOLUME = 10 * 1024; // 10kb
		// 시간표_1.hwp
		// 시간표_2.hwp
		// 시간표_3.hwp

		String baseName = FileUtil.getBaseName(child);
		String ext = FileUtil.getExtension(child);

		int code = 0;
		int i = 0; // 10kb 체크
		int index = 0;

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try (FileInputStream fis = new FileInputStream(f); BufferedInputStream bis = new BufferedInputStream(fis)) {
			while ((code = bis.read()) != -1) {
				// 10kb fos 객체 생성후 저장
				// i=0 ~10239 fos 객체생성
				// i=10240 fos 객체생성
				if (i % VOLUME == 0) {
					if (i != 0)
						bos.close(); // 저장

					child = String.format("%s_%d%s", baseName, ++index, ext);
					System.out.println(child);
					File temp = new File(parent, child);
					fos = new FileOutputStream(temp);
					bos = new BufferedOutputStream(fos);
				} // if
				
				bos.write(code);
				i++;
			}
			
			System.out.println("end");
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main

}
