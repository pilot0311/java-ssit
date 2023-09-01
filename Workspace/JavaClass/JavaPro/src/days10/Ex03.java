package days10;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pilot
 * @date 2023. 7. 26. - 오후 12:06:19
 * @subject 배열 단점 -> 컬렉션 클래스
 * @content 1) 배열크기 자동 증가 /감소 하지 않음
 * 					2) 요소 삽입
 */
public class Ex03 {
	static int index = 0; // 전역변수
	static Scanner sc = new Scanner(System.in);
	static char con = 'Y';
	
	public static void main(String[] args) throws IOException {
		
		int[] m = new int[3];

		String[] menus = { "추가", "수정", "삭제", "검색", "조회", "종료" };
		int selectedNumber;
		while (true) {
			dispMenus(menus);
			selectedNumber = selectMenus(sc);
			m = processMenus(selectedNumber,m );
		} // while
	} // main

	private static int[] processMenus(int selectedNumber,int[]m) throws IOException {
		
		switch (selectedNumber) {
		case 1: // main.m 배열에 값을 입력받아 요소 추가
			m=add(m);
			
			break;
		case 2:
			System.out.println("배열 수정");
			break;
		case 5: // 배열의 모든 요소 조회
			list(m);
			break;
		case 6:
			exit();
			break;
		default:
			break;
		} // switch
		일시정지();
		return m;
	}

	public static void 일시정지() {
		System.out.print(">아무키나 누르면 계속합니다");
		// 예외처리 2가지 방법 : try~catch, throws
		try {
			System.in.read();
			System.in.skip(System.in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void list(int[] m) {
		System.out.println("[5. 조회]");
		if (index == 0) {
			System.out.println("저장된 요소가 없음");
			return; // 함수를 빠져나감
		}
		for (int i = 0; i < index; i++) {
			System.out.printf("m[%d]=%d\n", i, m[i]);
		} // for
		System.out.println();
	}

	// 배열 m에 요소를 추가하는 함수(메서드)
	private static int[] add(int[] m) throws IOException {

		System.out.println("[1. 추가]");
		do {
			if(index==m.length) {
				int []temp = new int [m.length+3];
				for (int i = 0; i < m.length; i++) {
					temp[i]=m[i];
				} // for
				m=temp;
			}
			System.out.printf("> 정수 입력 ? ");
			int n = sc.nextInt();
			m[index++] = n;

			System.out.print("\t 추가 작업 계속 할려면 y를 입력");
			con = (char) System.in.read();
			System.in.skip(System.in.available());
		//} while (Character.toUpperCase(con) == 'Y' && index <3);
		} while (Character.toUpperCase(con) == 'Y');

		System.out.println(Arrays.toString(m));
		return m;
	}

	private static void exit() {
		System.out.println("\n\n프로그램 종료합니다.~");
		System.exit(-1);
	}

	private static int selectMenus(Scanner sc) {
		System.out.print("메뉴를 선택하세요: ");
		return sc.nextInt();
	}

	private static void dispMenus(String[] menus) {
		System.out.println("[메뉴]");
		for (int i = 0; i < menus.length; i++) {
			System.out.printf("%d. %s\t", i + 1, menus[i]);
		} // for
		System.out.println();

	}
	
}
