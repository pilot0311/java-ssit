package days25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

import days24.MemberVO;

/**
 * @author kenik
 * @date 2023. 8. 17. - 오전 7:06:56
 * @subject
 * @content
 */
public class Ex01_t {

public static void main(String[] args) {
      
      String fileName = ".\\src\\days19\\1. Java 팀 구성.txt";
      
      ArrayList<MemberVO> teamList = null;
      HashMap<TeamVo, ArrayList<MemberVO>> teamMap = new LinkedHashMap<>(); 
      String line = null;
      
      String teamName = null; 
      int teamTotalNumber = 0;
      String teamLeaderName = null;
      
      TeamVo TeamVo = null;
      MemberVO memberVO =  null;
      
       try (FileReader reader = new FileReader(fileName);
           BufferedReader br = new BufferedReader(reader)){
          
          while ( ( line = br.readLine() ) != null &&  !line.equals("")  ) {              
             teamName = line;  
             line = br.readLine() ; 
             String [] tNames = line.split("\\s*,\\s*");
             teamList = new ArrayList<MemberVO>();
             for (String tName : tNames) { 
               if( tName.contains("(팀장)")) {
                  teamLeaderName = tName = tName.replace("(팀장)",""); 
                  memberVO = new MemberVO(tName, "팀장");   
               }else {
                  memberVO = new MemberVO(tName, "팀원");   
               }
               teamList.add(memberVO); // value
            } // foreach             
             teamTotalNumber = teamList.size();
             TeamVo = new TeamVo(teamName,teamLeaderName , teamTotalNumber);
             teamMap.put(TeamVo, teamList) ;
             
         } // while    
          
          // 만약에 key가 중복이 된다면 X   팀명이 같으면 
          // key가  중복이 된다고 처리해야 된다.
          
          TeamVo = new TeamVo("1조", "홍길동",1 );
          if (!teamMap.containsKey( TeamVo )) { 
             teamList = null;
             teamMap.put(TeamVo, teamList);
         } else {
            System.out.println(">> 1조는 teamMap에 사용 중이다.");
         } // if
          
          
          
          // 출력 
          dispTeamMember( teamMap );
      } catch (Exception e) { 
         e.printStackTrace();
      } // catch
      
      
   } // main

   private static void dispTeamMember(HashMap<TeamVo, ArrayList<MemberVO>> teamMap) {
      
      Set<Entry<TeamVo, ArrayList<MemberVO>>>  eset = teamMap.entrySet();
      Iterator<Entry<TeamVo, ArrayList<MemberVO>>> ir = eset.iterator();
      
      ArrayList<MemberVO>  teamList = null;
      TeamVo TeamVo = null;
       
      while (ir.hasNext()) {
         Entry<TeamVo, ArrayList<MemberVO>> entry = ir.next();
         
         TeamVo = entry.getKey();         
         teamList = entry.getValue(); 
         
         System.out.printf("%s\n", TeamVo); // toString() 재정의.
         
         /*
         if (teamList != null) {
            Iterator<MemberVO> ir2 = teamList.iterator();
            int seq = 1;
            
            if( ir2.hasNext() ) ir2.next();          
            while (ir2.hasNext()) {
               MemberVO memberVO = ir2.next();
               System.out.printf("  [%d] %s\n",seq++, memberVO.getName());
            } // while
         } else {
            System.out.println("  팀원이 존재하지 않습니다.");
         } // if
         */
         
         try {
            Iterator<MemberVO> ir2 = teamList.iterator();
            int seq = 1;
            
            if( ir2.hasNext() ) ir2.next();          
            while (ir2.hasNext()) {
               MemberVO memberVO = ir2.next();
               System.out.printf("  [%d] %s\n",seq++, memberVO.getName());
            } // while
         }catch (NullPointerException e) {
            System.out.println("  팀원이 존재하지 않습니다.");
         }catch (Exception e) {
            e.printStackTrace();
         } // catch
         
         
         
      } // while
      
   }

} // class


/*
[3조(6명):박정호]
  [1] 이상문
  [2] 이주영
  [3] 정하영
  [4] 이동현
  [5] 주강민
[2조(7명):박민석]
  [1] 유희진
  [2] 고경림
  [3] 임경재
  [4] 이지현
  [5] 김정주
  [6] 김호영
[1조(7명):이경서]
  [1] 신종혁
  [2] 이재영
  [3] 송해영
  [4] 신기범
  [5] 이준희
  [6] 김성준 

*/
