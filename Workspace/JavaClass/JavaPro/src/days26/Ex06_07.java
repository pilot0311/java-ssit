package days26;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.util.FileUtil;

public class Ex06_07 {
	   static StringBuilder sb = new StringBuilder();

	   public static void main(String[] args) {
	      // javaPro 폴더 및 모든 하위 폴더 안에 있는 모든 파일을 찾아서
	      // keyword="fileName"
	      // 검색 후에 파일명 라인번호 출력
	      
	      String dir = System.getProperty("user.dir");
	      File f = new File(dir);
	      String keyword = "fileName";
	      searchKeyword(f, keyword);
	   }

	   private static void searchKeyword(File f, String keyword) {
	      File[] list = f.listFiles();
	      String fileName = "";
	      String line = null;
	      int lineNumber = 1;
	      File file = null;
	      
	      for (int i = 0; i < list.length; i++) {
	         lineNumber = 1;
	         file = list[i];
	         if(list[i].isDirectory()) {
	            searchKeyword(list[i], keyword);
	         }
	         fileName = file.getName();
	         if (file.isFile() && FileUtil.getExtension(fileName).equals(".java")) {
	            sb.setLength(0);
	            try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	               while ((line = br.readLine()) != null) {
	                  if(line.contains(keyword)) {
	                     sb.append(String.format("%d : %s\r\n", lineNumber, line));
	                  }
	                  lineNumber++;
	               }
	               if (sb.length() > 0) {
	                  System.out.printf("-----%s.%s-----\n", file.getParentFile().getName(), fileName);
	                  System.out.println(sb.toString());
	               }
	            } catch (FileNotFoundException e) {
	               e.printStackTrace();
	            } catch (IOException e) {
	               e.printStackTrace();
	            }
	         }
	      } // forr
	   }
	}