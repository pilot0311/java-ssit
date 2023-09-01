package javaProject01;

import java.util.Scanner;

public class TennisGame {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println(">TennisGame<");
		int numberOfSets = 0;
		while (true) {
			try {
				
				
				System.out.println("> 세트 수 입력 : ");
				numberOfSets = Integer.parseInt(sc.nextLine());
				chcek(numberOfSets);
				break;
				
			} catch (Exception e) {
				System.out.println("세트 수는 3, 5만 가능합니다 다시 입력 하세요");
			}
		}
		int numberOfTeamMember = 0;
		while (true) {
			try {
				System.out.println("> 단식(1) / 복식(2) 입력 : ");
				numberOfTeamMember = Integer.parseInt(sc.nextLine());
				checkm(numberOfTeamMember);
				break;
			} catch (Exception e) {
				System.out.println("1, 2번 중에 고르세요");
			}
		}
				
		String name = null;
		String name2 = null;
		Team p1, p2;
		TennisCounter tennis = null;
		
		switch (numberOfTeamMember){
		case(1):
			System.out.println("1번 선수 이름: ");
		name = scanName(name);				//유효성 검사
			 p1 = new Team(name, 0, 0, 0);
			System.out.println(p1);

			System.out.println("2번 선수 이름: ");
			name = scanName(name);
			 p2 = new Team(name, p1.point, p1.numberOfWongames, p1.numberOfWonSets);
			System.out.println(p2);
			 tennis = new TennisCounter(numberOfSets, p1, p2);
			tennis.score(p1, p2, numberOfSets);
			//tennis.dispScoreBoard();
		break;

		case (2):
			System.out.println("1팀 1번 선수 이름: ");
			name = scanName(name);
			//name = sc.nextLine();
			
			System.out.println("1팀 2번 선수 이름: ");	
			name2 = scanName(name2);
			name = name + "/" + name2;
			 p1 = new Team(name, 0, 0, 0);
			System.out.println(p1);

			System.out.println("2팀 1번 선수 이름: ");
			name = scanName(name);
			//name = sc.nextLine();

			System.out.println("2팀 2번 선수 이름: ");
			name2 = scanName(name2);
			name = name + "/" + name2;
			 p2 = new Team(name, p1.point, p1.numberOfWongames, p1.numberOfWonSets);
			System.out.println(p2);
			 tennis = new TennisCounter(numberOfSets, p1, p2);
			tennis.score(p1, p2, numberOfSets);
			//tennis.dispScoreBoard();
		break;
		default:
		System.out.println("잘못 입력 하셨습니다");
		
	}
		
	}

	private static String scanName(String name) {
		while (true) {
			try {
				name = sc.nextLine();
				checkname(name);
				break;
			} catch (Exception e) {
				System.out.println("이름은 한글로 2글자에서 4글자 까지 가능 합니다 다시 입력하세요");
			}
		}
		return name;
	}

	private static void checkname(String name) throws Exception {
		String regex = "^[가-힣]{2,5}$";
		if (!name.matches(regex)) {
			Exception ex = new Exception();
	        throw ex;
		} //if
		
	}

	private static void checkm(int numberOfTeamMember) throws Exception {
		if (numberOfTeamMember != 1 && numberOfTeamMember != 2) {
			Exception ex = new Exception();
	        throw ex;
		} //if
		
	}

	private static void chcek(int numberOfSets) throws Exception {
		if (numberOfSets != 3 && numberOfSets != 5) {
			Exception ex = new Exception();
	        throw ex;
		} //if
		
	}

}
