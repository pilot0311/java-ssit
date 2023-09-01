package days04;

import java.util.Scanner;

/**
 * @author kenik
 * @date 2023. 7. 18. - 오후 4:17:29
 * @subject  컴퓨터 - 사용자(user) 가위,바위,보 게임 ...
 * @content
 */
public class Ex10_03 {

   public static void main(String[] args) {
       
      int com , user;
      String coms = null, users = null; // 가위, 바위, 보
      
      try ( Scanner scanner = new Scanner(System.in) ) {
         System.out.print("> user 가위(1),바위(2),보(3) 선택 ? ");
          
         user = scanner.nextInt();
         com =  (int)(Math.random()*3)+1;
         
         switch (user) {
         case 1:
            users = "가위";
            break;
         case 2:
            users = "바위";
            break;
         case 3:
            users = "보";
            break;
         } // switch
         
         if ( com == 1 ) {
            coms = "가위";
         } else if( com == 2 ) {
            coms = "바위";
         } else if( com == 3) {
            coms = "보";
         }
          
         System.out.printf("> 컴퓨터:%d, 사용자:%d\n", com, user);
         System.out.printf("> 컴퓨터:%s, 사용자:%s\n", coms, users);
         
         switch (user - com) {
         case 1: case -2:
            System.out.println("사용자 승리");
            break;
         case 2: case -1:
            System.out.println("컴퓨터 승리");
            break; 
         default:   
            System.out.println("무승부");
            break;
         } // switch
         
         // scanner.close() 자동
      } catch (Exception e) {
         e.printStackTrace();
      } // catch


   } // main

} // class








