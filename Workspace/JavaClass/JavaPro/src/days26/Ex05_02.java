package days26;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ex05_02 {

	public static void main(String[] args) throws IOException {
		int[] score = {
				// 번호 국 영 수
				1, 100, 90, 90, 2, 70, 90, 100, 3, 100, 100, 100, 4, 70, 60, 80, 5, 70, 90, 100 };
		// 성적 정보
		String name = ".\\src\\days26\\score.dat";
		String mode = "rw";

		try (RandomAccessFile raf = new RandomAccessFile(name, mode);) {
			for (int i = 0; i < score.length; i++) {
				long fp = raf.getFilePointer();
				System.out.printf(">현재 파일 포인터 위치 : %d - [%d]\n", fp, score[i]);
				raf.writeInt(score[i]);
			} // for

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 일시 정지 + 엔터 계속
		System.out.println(">엔터치면 진행");
		System.in.read();
		System.in.skip(System.in.available());

		// 문제
		// 모든 학생의 번호 국 영 수 성적 정보 출력
		// System.out.printf("번호:%d, 국어:%d, 영어:%d, 수학:%d ,총점:%d, 평균:%.2f");
		int no, kor, eng, mat;
		int tot;
		double avg;
		try (RandomAccessFile raf = new RandomAccessFile(name, mode);) {
			// 현재 파일 포인터 0
//			no = raf.readInt(); // 4바이트 읽음
//			// 현재 FP : 4
//			kor = raf.readInt();
//			eng = raf.readInt();
//			mat = raf.readInt();	

			int sCount = score.length / 4; // ==5
			for (int i = 0; i < sCount; i++) {
				no = raf.readInt();
				kor = raf.readInt();
				eng = raf.readInt();
				mat = raf.readInt();
				tot = kor + eng + mat;
				avg = (double) tot / 3;
				System.out.printf("번호:%d, 국어:%d, 영어:%d, 수학:%d ,총점:%d, 평균:%.2f\n", no, kor, eng, mat, tot, avg);
			} // for

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 일시 정지 + 엔터 계속
		System.out.println(">엔터치면 진행");
		System.in.read();
		System.in.skip(System.in.available());

		// 문제 3반 학생의 수학 점수(100)를 20점으로 수정 하는 코딩
		try (RandomAccessFile raf = new RandomAccessFile(name, mode);) {
			long pos = (4 * 4) * 2 + 4 * 3;
			raf.seek(pos);
			raf.writeInt(20);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3번학생의 성적만 출력
		try (RandomAccessFile raf = new RandomAccessFile(name, mode);) {
			long pos = (4 * 4) * 2;
			raf.seek(pos);
			no = raf.readInt();
			kor = raf.readInt();
			eng = raf.readInt();
			mat = raf.readInt();
			tot = kor + eng + mat;
			avg = (double) tot / 3;
			System.out.printf("번호:%d, 국어:%d, 영어:%d, 수학:%d ,총점:%d, 평균:%.2f\n", no, kor, eng, mat, tot, avg);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("end");

	} // main

}
