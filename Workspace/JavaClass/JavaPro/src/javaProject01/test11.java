package javaProject01;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.Doc;

public class test11 {

   public static void main(String[] args) {

      System.out.println(">");
      Scanner sc = new Scanner(System.in);
      System.out.print("> 세트 수 입력 ( 3 or 5 ) : ");
      int numberOfSets = Integer.parseInt(sc.nextLine());
      while ( !(numberOfSets == 3 || numberOfSets == 5) ) {
         System.out.print(" 입력 잘못 ! 다시 입력 : ( 3 or 5 )  ");
         numberOfSets = Integer.parseInt(sc.nextLine());
         try {
            System.in.skip(System.in.available() );
         } catch (IOException e) {
            e.printStackTrace();
         }

      } // while
      System.out.print("> 단식(1) / 복식(2) 입력 : ");
      int numberOfTeamMember = Integer.parseInt(sc.nextLine());
      while ( !(numberOfTeamMember == 1 || numberOfTeamMember == 2) ) {
         System.out.print(" 입력 잘못 ! 다시 입력 : 단식(1) or 복식(2)  ");
         numberOfSets = Integer.parseInt(sc.nextLine());
         try {
            System.in.skip(System.in.available() );
         } catch (IOException e) {
            e.printStackTrace();
         } // catch
      } // while

      Team p1 ;
      Team p2 ;
      String name = "";
      String regex = "^[가-힣]{2,5}$";
      
      TennisCounter tennis ;

      while ( true ) {
         if ( numberOfTeamMember == 1) {
            do {
               System.out.print("1번 선수 이름 : ");
               name = sc.nextLine();
            } while (!isValidName(name, regex));
            
            p1 = new Team(name, 0, 0, 0);
            System.out.println(p1);
            do {
               System.out.print("2번 선수 이름 : ");
               name = sc.nextLine();
            } while(!isValidName(name, regex));

            p2 = new Team(name, p1.point, p1.numberOfWongames, p1.numberOfWonSets);
            System.out.println(p2);
            tennis = new TennisCounter(numberOfSets, p1,p2);
            tennis.dispScoreBoard();

         } else {
            System.out.print("1팀 1번 선수 이름 : ");
            name = sc.nextLine();
            System.out.print("1팀 2번 선수 이름 :");
            name = name + "/" + sc.nextLine();
            p1 = new Team(name, 0, 0, 0);
            System.out.println(p1);

            System.out.print("2팀 1번 선수 이름 : ");
            name = sc.nextLine();
            System.out.print("2팀 2번 선수 이름 : ");
            name = name + "/" + sc.nextLine();
            p2 = new Team(name, p1.point, p1.numberOfWongames, p1.numberOfWonSets);
            System.out.println(p2);
            tennis = new TennisCounter(numberOfSets, p1,p2);
            tennis.dispScoreBoard();
         }
      } // while


      // 매치 승리 계산


   } // main
   public static boolean isValidName(String name, String regex) {
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(name);
      return matcher.matches();
   } // main
} // class