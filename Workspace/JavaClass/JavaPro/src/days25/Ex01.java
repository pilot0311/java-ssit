package days25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Ex01 {

	public static void main(String[] args) {
		
		HashMap<TeamVo, ArrayList<MemberVO>> teamGroup = new LinkedHashMap<>();
		ArrayList<MemberVO> teamList = null;
		String fileName = ".\\src\\days19\\1. Java 팀 구성.txt";
		String line = null; 
		String teamName = null; 
		TeamVo teamVo = null;
		MemberVO memberVO = null;
		
		 try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((line=br.readLine()) !=null && !line.equals("")) {
				teamList = new ArrayList<MemberVO>();
				teamName = line;
				line = br.readLine();
				String[] teams = line.split("\\s*,\\s*");
				for (int i = 0; i < teams.length; i++) {
					if (teams[i].contains("(팀장)")) {
						teams[i] = teams[i].replace("(팀장)", "");
						teamVo = new TeamVo(teamName, teams[i], teams.length);
						//memberVO = new MemberVO(teams[i], "팀장");
					} else {
							memberVO = new MemberVO(teams[i], "팀원");
					} //else
					
					teamList.add(memberVO);
					
				} // for
				
				teamGroup.put(teamVo, teamList);
				//TeamVO (name, totalNumber , leader ) 
				
			}//while
			 
			//만약 key가 중복이 된다면	중복 처리
			teamVo = new TeamVo("1조","홍길동",1);
			if (!teamGroup.containsKey(teamVo)) {
				teamList = null;
				teamGroup.put(teamVo, teamList);
			} else {
					System.out.println("1조는 이미 존재하는 팀입니다");
			} //else
			
			
			
				 disp(teamGroup);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	} // main

	private static void disp(HashMap<TeamVo, ArrayList<MemberVO>> teamGroup) {
		
		Iterator<Entry<TeamVo, ArrayList<MemberVO>>> ir = teamGroup.entrySet().iterator();
		MemberVO teamL = null;
		
		TeamVo teamVo = null;
		String teamName = null;
		String teamLeader = null;
		//String name = null;
		ArrayList<MemberVO> teamList = null;
		int teamCount = 0;
		
		while (ir.hasNext()) {
			Entry<TeamVo, ArrayList<MemberVO>> entry =  ir.next();
			
			teamVo = entry.getKey();
			teamList = entry.getValue();
			teamName = teamVo.getName();
			teamLeader = teamVo.getLeader();
			teamCount = teamVo.getTotalNumber();
			System.out.printf("[%s(%d명) - %s]\n",teamName,teamCount,teamLeader);
			try {
				Iterator<MemberVO> ir2 = teamList.iterator();
				int seq =1;
				if (ir2.hasNext()) ir2.next();
				while (ir2.hasNext()) {
					 teamL = ir2.next();
					String name = teamL.getName();
					System.out.printf("  [%d] %s\n",seq++,name);
				}
			} catch (NullPointerException e) {	//예외처리
				System.out.println("팀원이 존재하지 않습니다");
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
}
/*
key   - TeamVO (name, totalNumber , leader ) 
value - ArrayList<MemberVO>
로 저장해서 출력하는 코딩을 하세요. 
( 조건 1: key 값으로 TeamVO 클래스 선언 )
( 조건 2: value 값으로 어제 선언한 MemberVO 클래스 사용 )
*/