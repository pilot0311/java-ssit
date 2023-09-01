package days19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Ex01test {

   public static void main(String[] args) {
      // StringBuffer  : String buffers are safe for use by multiple threads.
      // StringBuilder : but with no guarantee of synchronization
      
      
      String key = "user.dir";
      String userDir = System.getProperty(key);
      // System.out.println( userDir );
      String fileName = "1. Java 팀 구성.txt";
      String path = String.format("%s\\src\\days19\\%s", userDir, fileName );
      // System.out.println( path );
      
      // "2조"
      String line = null;
      try (FileReader fr = new FileReader(path);BufferedReader br = new BufferedReader(fr)){
         while(  (line = br.readLine()) != null ) {
             if( line.equals("1조") ) {
                line = br.readLine();
                System.out.println( line );
                break;
             } // if
         } // while
      } catch (Exception e) {
         e.printStackTrace();
      } // catch
      
      // line =  "박민석(팀장), 유희진, 고경림, 임경재, 이지현 , 김정주, 김호영"
      String regex = "\\s*,\\s*";
      String [] teamMembers = line.split(regex);
      String teamLeader = null; 
      String [] teamMembers2 = new String[teamMembers.length -1];
      for (int i = 0, index = 0; i < teamMembers.length; i++) {
         if(  teamMembers[i].contains("(팀장)") ) {
            teamLeader = teamMembers[i].replace("(팀장)", ""); 
            // break;
            continue;
         }         
         // 팀원
         teamMembers2[index++] = teamMembers[i]; 
      } // for
      System.out.println("> teamLeader : " + teamLeader);
      System.out.println(Arrays.toString(teamMembers2));
      // Arrays.sort(teamMembers2, Collections.reverseOrder() );
      Arrays.sort(teamMembers2, (n1,n2)-> n2.compareTo(n1) );
      System.out.println(Arrays.toString(teamMembers2));
      
      /*
      <ul>
         <li class="leader">임경재</li>
         <li>이지현</li>
         <li>유희진</li>
         <li>박민석</li>
         <li>김호영</li>
         <li>김정주</li>
         <li>고경림</li>
      </ul>
      */
      
      /*
      String output = "<ul>";
      output += String.format("\r\n\t<li class=\"leader\">%s</li>", teamLeader ); 
      output +=  "\r\n\t<li>"+ String.join("</li>\r\n\t<li>", teamMembers2) + "</li>";
      output += "\r\n</ul>";
      */
      
      StringBuilder sb = new StringBuilder();
      sb.append("<ul>");
      sb.append(String.format("\r\n\t<li class=\"leader\">%s</li>", teamLeader ));
      sb.append("\r\n\t<li>"+ String.join("</li>\r\n\t<li>", teamMembers2) + "</li>");
      sb.append("\r\n</ul>");
      
      System.out.println( sb.toString() );
    
      /*
      StringJoiner sj = new StringJoiner("</li>\r\n\t<li>", "\t<li>", "</li>");
      sj.add()
      */

   } // main

} // class





