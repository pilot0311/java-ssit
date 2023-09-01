package days27.project.merge;

import java.util.Scanner;

public class TennisGame {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// 세트수 입력
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

		// 단식/복식 여부 입력
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
		// 
		Team p1 = new Team(name, 0, 0, 0);
		Team p2 = new Team(name, 0, 0, 0);

		switch (numberOfTeamMember) {
		case (1):
			System.out.println("1번 선수 이름: ");
			name = scanName(name); // 유효성 검사
			p1 = new Team(name, 0, 0, 0);

			System.out.println("2번 선수 이름: ");
			name = scanName(name);
			p2 = new Team(name, p1.point, p1.numberOfWonGames, p1.numberOfWonSets);

			break;

		case (2):
			System.out.println("1팀 1번 선수 이름: ");
			name = scanName(name);

			System.out.println("1팀 2번 선수 이름: ");
			name2 = scanName(name2);
			name = name + "/" + name2;
			p1 = new Team(name, 0, 0, 0);

			System.out.println("2팀 1번 선수 이름: ");
			name = scanName(name);

			System.out.println("2팀 2번 선수 이름: ");
			name2 = scanName(name2);
			name = name + "/" + name2;
			p2 = new Team(name, 0, 0, 0);

			break;
		default:
			System.out.println("잘못 입력 하셨습니다");
		}
		
		// TennisCounter 객체 생성
		TennisCounter tennis = new TennisCounter(numberOfSets, numberOfTeamMember, p1, p2);
		int p;
		//t
		while (tennis.winner.equals("")) {
			p = (int) (Math.random() * 2 + 1);
			tennis.pointWinner(p);
			tennis.calcPoint();
			tennis.calcGame();
			tennis.calcSet();
			tennis.dispScoreBoard();
			
			
		}
		tennis.exportMatchResult();
	}

	private static String scanName(String name) {
		while (true) {
			try {
				name = sc.nextLine();
				checkname(name);
				break;
			} catch (Exception e) {
				System.out.println("잘못 입력했습니다 다시 입력하세요");
			}
		}
		return name;
	}

	private static void checkname(String name) throws Exception {
		String regex = "^[가-힣]{2,5}$";
		if (!name.matches(regex)) {
			Exception ex = new Exception();
			throw ex;
		} // if

	}

	private static void checkm(int numberOfTeamMember) throws Exception {
		if (numberOfTeamMember != 1 && numberOfTeamMember != 2) {
			Exception ex = new Exception();
			throw ex;
		} // if

	}

	private static void chcek(int numberOfSets) throws Exception {
		if (numberOfSets != 3 && numberOfSets != 5) {
			Exception ex = new Exception();
			throw ex;
		} // if

	}

	
	// 미구현
//		tennis.printMatchWinner(); // 승자와 최종 스코어보드 출력 후 파일 저장

}
