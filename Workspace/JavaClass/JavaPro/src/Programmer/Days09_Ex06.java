package Programmer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Days09_Ex06 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] m = new int[3];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		String[] menus = { "추가", "수정", "삭제", "검색", "조회", "종료" };
		int selectedNumber;
		while (true) {
			dispMenus(menus);
			selectedNumber = selectMenus(sc);
			processMenus(selectedNumber,list);
		} // while
	} // main

	private static void processMenus(int selectedNumber,ArrayList<Integer> list) {
		switch (selectedNumber) {
		case 1:
			System.out.println("배열에 요소 추가");
			addList(list);
			break;
		case 2:
			System.out.println("배열 수정");
			modList(list);
			break;
		case 3:
			delList(list);
			break;
		case 4:
			searchList(list);
			break;
		case 5:
			printList(list);
			break;
		case 6:
			exit();
			break;
		default:
			break;
		} // switch
		stop();
	}

	

	private static void searchList(ArrayList<Integer> list) {
		int i =0;
		int []c=new int[list.size()];
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 정수를 입력 하세요: ");
		int n = sc.nextInt();
		while (i<list.size()) {
			if(list.get(i)==n) {
				//System.out.printf("%d는 list의 %d번째에 저장되어 있습니다\n",n,i+1);
				c[i]=i+1;
				
			}else if(list.get(i)!=n && i==list.size()-1) {
				System.out.printf("%d는 list에 없습니다\n",n);
				break;
			}
			i++;
		}
		System.out.printf("%d는 list의 %s번째에 저장되어 있습니다\n",n,Arrays.toString(c));
	}

	private static void delList(ArrayList<Integer> list) {
		System.err.println("저장된 요소: "+list);
		System.out.print("삭제할 요소의 번호를 선택 하세요: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		list.remove(n-1);
		System.err.println("삭제 후 요소: "+list);
		
	}

	private static void modList(ArrayList<Integer> list) {
		Scanner sc = new Scanner(System.in);
		System.err.println("저장된 요소: "+list);
		System.out.print("수정할 요소의 번호를 선택 하세요: ");
		int n = sc.nextInt();
		System.out.print(" 수정 할 정수를 입력하세요: ");
		int c = sc.nextInt();
		list.set(n-1, c);
		System.err.println("변경 후 요소: "+list);
	}

	private static void printList(ArrayList<Integer> list) {
		System.err.println(list);
	}

	private static void addList(ArrayList<Integer> list) {
		Scanner sc = new Scanner(System.in);
		System.out.print("추가할 정수를 입력하세요");
		int add = sc.nextInt();
		list.add(add);
		System.out.println("정수가 추가 되었습니다");
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
			System.out.printf("%d. %s\n", i + 1, menus[i]);
		} // for

	}
	public static void stop() {
		System.out.print(">아무키나 누르면 계속합니다");
		// 예외처리 2가지 방법 : try~catch, throws
		try {
			System.in.read();
			System.in.skip(System.in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
