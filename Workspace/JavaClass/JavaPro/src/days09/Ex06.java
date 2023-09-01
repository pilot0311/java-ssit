package days09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.plugins.tiff.ExifGPSTagSet;

public class Ex06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] m = new int[3]	;
		String []	 menus = {"추가","수정","삭제","검색","조회","종료"};
		int selectedNumber;
		while (true) {
			dispMenus(menus);
			selectedNumber = selectMenus(sc);
			processMenus(selectedNumber);
		}//while
	} // main

	private static void processMenus(int selectedNumber) {
		switch (selectedNumber) {
		case 1:
			System.out.println("배열에 요소 추가");
			break;
		case 2:
			System.out.println("배열 수정");
			break;
		case 6 :
			exit();
			break;
		default:
			break;
		} // switch
		
	}

	

	private static void exit() {
		System.out.println("\n\n프로그램 종료합니다.~");
		System.exit(-1);
	}

	private static int selectMenus(Scanner sc) {
		System.out.println("메뉴를 선택하세요");
		return sc.nextInt();
	}

	private static void dispMenus(String[] menus) {
		System.out.println("[메뉴]");
		for (int i = 0; i < menus.length; i++) {
			System.out.printf("%d. %s\n",i+1,menus[i]);
		} // for
		
	}
}
