package sqlCopy;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Copy {
	   static String dirPath = "E:\\Class\\Workspace\\OracleClass";
	   


	   public static void main(String[] args) {
	      File f = new File(dirPath);
	      
	      File[] list = f.listFiles();
	      File lastFile = list[list.length-1];
	      String todayDirName = getTodayDirName(lastFile.getName());
	      File today = new File(dirPath + "\\" + todayDirName);
	      if(!today.exists()) today.mkdir();
	      mkFile(today);
	   }
	   
	   private static void mkFile(File today) {
	      int n = Integer.parseInt(today.getName().substring(4));
	      String fileName = n+"일차 수업정리.txt";
	      String pattern = "yyMMdd";
	      SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	      String date = sdf.format(new Date());
	      String fileName2 = "SCOTT_"+date + ".sql";
	      String fileName3 = "SYS_"+date + ".sql";
	      String fileName4 = "HR_"+date + ".sql";
	      
	      try {
	         File file = new File(today, fileName);
	         file.createNewFile();
	         file = new File(today, fileName2);
	         file.createNewFile();
	         file = new File(today, fileName3);
	         file.createNewFile();
	         file = new File(today, fileName4);
	         file.createNewFile();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }

	   public static String getTodayDirName(String lastDirName) {
	      int a = Integer.parseInt(lastDirName.substring(4))+1;
	      if(a<10) {
	      String todayDirName = "days" + ("00"+a).substring(1);
	      return todayDirName;
	      } else {
	    	  String todayDirName = "days" + a;
		      return todayDirName;
	      }
	   }

	}
