package javaProject01;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Random;

public class TennisCounter {

	Random rnd = new Random();
	int numberOfSet;
	Team team1, team2;
	static String[] pointFormat = { "0", "15", "30", "40", "WIN", "Game" };

	public TennisCounter(int numberOfSet, Team p1, Team p2) {
		super();
		this.numberOfSet = numberOfSet;
		this.team1 = p1;
		this.team2 = p2;
	}

	public void pointWinner(int p) {

		if (p == 1) {

			team1.point += 1;
			if (team1.point > 2 && team2.point > 2) {
				if (team2.point == team1.point) {
					team2.pointStr = "40";
					team1.pointStr = "40";
				} else if(team1.point > team2.point){
					team1.pointStr = "AD";
					team2.pointStr = "00";
					 if(team1.point - team2.point == 2)
							team1.pointStr = "WIN";
				}
			} else
				team1.pointStr = pointFormat[team1.point];

		} else if (p == 2) {

			team2.point += 1;
			if (team2.point > 2 && team1.point > 2) {
				if (team2.point == team1.point) {
					team2.pointStr = "40";
					team1.pointStr = "40";
				} else if (team2.point > team1.point) {
					team2.pointStr = "AD";
					team1.pointStr = "00";
					 if(team2.point - team1.point == 2)
							team2.pointStr = "WIN";
				} 
			} else
				team2.pointStr = pointFormat[team2.point];

		}
		// 특정 팀의 포인트 1 증가.
		// 팀을 선택하는 매개변수 p는 1 또는 2의 값을 가진다.
		dispScoreBoard();
	}

	public void score(Team team1, Team team2, int numberOfSets) {
		int p = 0;
		int t1 = 0;
		int t2 = 0;
		int i = 1;
		boolean flag = true;
		while (team1.numberOfWonSets != (numberOfSets / 2) + 1 && team2.numberOfWonSets != (numberOfSets / 2) + 1) {
			p = rnd.nextInt(2) + 1;
			pointWinner(p);
			fileWrite(team1, team2, numberOfSets, flag, i++);
			flag = false;
			if (team1.point >= 4 && team1.point - team2.point >= 2) {
				team1.numberOfWongames++;
				team1.point = 0;
				team2.point = 0;
				team2.pointStr = "0";
				team1.pointStr = "0";
				System.out.println(team1.name + "가 승리 했습니다");
			} else if (team2.point >= 4 && team2.point - team1.point >= 2) {
				team2.numberOfWongames++;
				team1.point = 0;
				team2.point = 0;
				team2.pointStr = "0";
				team1.pointStr = "0";
				System.out.println(team2.name + "가 승리 했습니다");
			}

			if (team1.numberOfWongames >= 6 && team1.numberOfWongames - team2.numberOfWongames >= 2) {
				team1.numberOfWonSets++;
				t1 = team1.numberOfWongames;
				t2 = team2.numberOfWongames;
				if (team1.numberOfWonSets == numberOfSets/2+1)
					break;
				team1.point = 0;
				team2.point = 0;
				team1.numberOfWongames = 0;
				team2.numberOfWongames = 0;
				team2.pointStr = "0";
				team1.pointStr = "0";
			} else if (team2.numberOfWongames >= 6 && team2.numberOfWongames - team1.numberOfWongames >= 2) {
				team2.numberOfWonSets++;
				t1 = team1.numberOfWongames;
				t2 = team2.numberOfWongames;
				if (team2.numberOfWonSets == numberOfSets/2+1)
					break;
				team1.point = 0;
				team2.point = 0;
				team1.numberOfWongames = 0;
				team2.numberOfWongames = 0;
				team2.pointStr = "0";
				team1.pointStr = "0";
			}

			//dispScoreBoard();
		}
		//System.out.printf("%d, %d\n", t1, t2);
		 fileWrite(team1, team2, numberOfSets, flag,i);
		 System.out.println("\t---최종 스코어---");
		dispScoreBoard();
	}

	public void fileWrite(Team team1, Team team2, int numberOfSets, boolean flag, int i) {
		String pathname = ".\\src\\javaProject01\\gameInfo.txt";
		File file = new File(pathname);
		try (FileWriter fw = new FileWriter(file, true)) {
			int n = numberOfSets / 2 + 1;
			if (flag) {
				if (team1.name.contains("/"))
					fw.append("복식: ");
				else
					fw.append("단식: ");
			
			fw.append(numberOfSets + "판" + n + "선승\n");
			}
			fw.append("\t"+i+" Round\n").append(team1.toString()).append("\n").append(team2.toString()).append("\n");

			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 위치: javaProject01");
		}
	}

//	public void score(Team team1, Team team2, int numberOfSets) {
//		int p = 0;
//		while ( team1.numberOfWonSets != (numberOfSets/2)+1 && team2.numberOfWonSets != (numberOfSets/2)+1) {
//			p = rnd.nextInt(2)+1;
//			pointWinner(p);
//	
//			if (team1.point == 4) {
//				team1.numberOfWongames++;
//				team1.point=0;
//				team2.point=0;
//				team2.pointStr = "0";
//				team1.pointStr = "0";
//			} else if (team2.point == 4){
//				team2.numberOfWongames++;
//				team1.point=0;
//				team2.point=0;
//				team2.pointStr = "0";
//				team1.pointStr = "0";
//			}
//			
//			if (team1.numberOfWongames == 6) {
//				team1.numberOfWonSets++;
//				team1.point=0;
//				team2.point=0;
//				team1.numberOfWongames = 0;
//				team2.numberOfWongames = 0;
//				team2.pointStr = "0";
//				team1.pointStr = "0";
//			} else if(team2.numberOfWongames == 6){
//				team2.numberOfWonSets++;	
//				team1.point=0;
//				team2.point=0;
//				team1.numberOfWongames = 0;
//				team2.numberOfWongames = 0;
//				team2.pointStr = "0";
//				team1.pointStr = "0";
//			}
//			  
//			dispScoreBoard();
//		}
//	}

	public void dispScoreBoard() {
		String[][] test = new String[3][2 + numberOfSet];
		// 결과 템플릿 미리 만들고 값만 넣기 vs 호출할 때 만들기
		if (team1.name.contains("/")) {
			System.out.printf("%s\t\t%s\n",team1.name,team2.name);
		} else System.out.printf("\t%s\t\t%s\n",team1.name,team2.name);
		
		//System.out.printf("point :\t%d\tpoint :\t%d\n",team1.point, team2.point);
		System.out.printf("pointStr :\t%s\tpointStr :\t%s\n",team1.pointStr, team2.pointStr);
		System.out.printf("Game :\t%d\tGame :\t%d\n",team1.numberOfWongames, team2.numberOfWongames);
		System.out.printf("Set :\t\t%d\tSet :\t\t%d\n",team1.numberOfWonSets, team2.numberOfWonSets);
		System.out.println();
		// 현재의 스코어보드를 화면에 출력한다.
		// 객체가 있어야 스코어보드를 출력할 수 있으니, static으로 선언하지 않는다.
		//System.out.println("\n" + team1.toString() + "\n" + team2.toString());

	}
}

class Team {

	String name;
	int point = 0;
	String pointStr = "0";
	int numberOfWongames = 0;
	int numberOfWonSets = 0;

	public Team(String name, int point, int numberOfWongames, int numberOfWonSets) {
		this.name = name;
		this.point = point;
		this.pointStr = TennisCounter.pointFormat[point];
		this.numberOfWongames = numberOfWongames;
		this.numberOfWonSets = numberOfWonSets;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", point=" + point + ", pointStr=" + pointStr + ", numberOfWongames="
				+ numberOfWongames + ", numberOfWonSets=" + numberOfWonSets + "]";
	}

}