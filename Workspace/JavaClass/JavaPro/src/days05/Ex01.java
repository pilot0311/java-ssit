package days05;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01 {
	public static void main(String[] args) {
		
		//if(조건식) return; 조건식이면 함수를 빠져 나간다 함수(메서드) 빠져 나갈땐 return 리턴값;
		//10+9+8+...+1-55
//		int sum=0;
//		for (int i = 10; i > 0; i--) {
//			System.out.printf("%d+",i);
//			sum+=i;
//		} // for
//		System.out.printf("\b=%d",sum);
		
		//5-2번
//		for (int i = 1; i <= 10; i++) 
//			System.out.printf("%02d - 헬로우 월드\n",i);	
		
		
		//6번 
//		char c;
//		String s;
//		try(Scanner sc = new Scanner(System.in)) {
//			System.out.print("한문자입력:");
//			s = sc.next();
//			if(Pattern.matches("^[0-9]$", s)) {
//				System.out.println("숫자입니다");
//			}else if(Pattern.matches("^[a-zA-Z]$", s)) {
//				System.out.println("영어입니다");
//			}
//			else if(Pattern.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]$", s)) {
//					System.out.println("한글입니다");
//			}else 
//				System.out.println("특수 문자 입니다");
//			
//			
//			
//			
////			c = sc.next().charAt(0);
////			if('0'<=c&&c<='9') {
////				System.out.println("숫자 입니다");
////			}else if('A'<=c&&c<='z') {
////				System.out.println("영어 입니다");
////			}else if('가'<=c&&c<='힣' || 'ㄱ'<=c&&c<='ㅎ' || 'ㅏ'<=c&&c<='ㅣ') {
////				System.out.println("한글 입니다");
////			}else 
////				System.out.println("특수 문자 입니다");
////			
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		//7번 컴퓨터와 가위 바위 보
//		int com,user;
//		String game[]= {"가위","바위","보"};
//		
//		try(Scanner sc = new Scanner(System.in)) {
//			System.out.print("가위(1) 바위(2) 보(3) 입력:");
//			user = sc.nextInt();
//			com=(int)(Math.random()*3)+1;
//			System.out.printf("com:%s(%d)  user: %s(%d)",game[com-1],com,game[user-1],user);
//			
//			switch (user-com) {
//			case 1: case -2:
//				System.out.println("승리");
//				break;
//			case -1: case 2:
//				System.out.println("패배");
//				break;
//			default:
//				System.out.println("무승부");
//				break;
//			} // switch
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	} // main
}
