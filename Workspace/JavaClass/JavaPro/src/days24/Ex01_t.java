package days24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author kenik
 * @date 2023. 8. 16. - 오전 7:05:09
 * @subject
 * @content
 */
public class Ex01_t {
   
   public static void main(String[] args) {
      
      String fileName = ".\\src\\days19\\1. Java 팀 구성.txt";
      
      // [ 자바 IO(Input Output) ]
      // FileReader, BufferedReader(보조스트림)
      // FileWriter, BufferedWriter
      ArrayList<MemberVO> teamList = null;
      HashMap<String, ArrayList<MemberVO>> teamMap = new HashMap<>();
      String content = "";
      StringBuilder sb  = new StringBuilder();
      String line = null;
       try (FileReader reader = new FileReader(fileName);BufferedReader br = new BufferedReader(reader)){
         // 10:02 수업 시작~ 
          while ( ( line = br.readLine() ) != null) {
            // System.out.println( line );
             //content += line;
             sb.append(line + "\r\n");
         } // while          
          content = sb.toString();          
          System.out.println( content );
          
          /*
          String pattern = 
                  "{0}\r\n{1}\r\n"
                + "{2}\r\n{3}\r\n"
                + "{4}\r\n{5}\r\n";
          */
          String pattern = 
                  "{0}\r\n{1}(팀장),{2}\r\n";
          MessageFormat mf = new MessageFormat(pattern);
          Object [] datas = mf.parse(content);
          
          System.out.println( datas[0]); // 1조
          System.out.println( datas[1]);  
          
      } catch (Exception e) { 
         e.printStackTrace();
      } // catch
      
      
   } // main

} // class