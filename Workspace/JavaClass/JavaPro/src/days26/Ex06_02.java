package days26;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author pilot
 * @date 2023. 8. 18. - 오후 12:22:36
 * @subject		[ javaPro 모든 하위 폴더, 파일 목록 정보 조회 ]
 * @content
 */
public class Ex06_02 {

	public static void main(String[] args) {
		
		String currentDirectory = System.getProperty("user.dir");
		//E:\Class\Workspace\JavaClass\JavaPro
		//System.out.println(currentDirectory);
		
		File parent = new File(currentDirectory);
		//System.out.println(parent.isDirectory());
		
		/*
		String [] list = parent.list();
		//File [] list = parent.listFiles();
		for (int i = 0; i < list.length; i++) {
			//System.out.println(list[i]);
			File f = new File(parent, list[i]);
			System.out.printf("%s\t%s\t%d\n",f.isDirectory()?"[폴더]":"파일",f.getName(),f.length());
		} // for
		*/
		// long -> LocalDateTime -> DateFormat
		Date d = null;
		LocalDateTime ldt = LocalDateTime.of(1970, 1, 1, 0, 0);
		String pattern = "yyyy.MM.dd a h:mm";
		DateTimeFormatter dtf =  DateTimeFormatter.ofPattern(pattern);
		//System.out.println(ldt);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a h:mm ");
		File [] list = parent.listFiles();
		for (int i = 0; i < list.length; i++) {
			
			long mod = list[i].lastModified();
			 d = new Date(mod);
			 ldt = ldt.plus(mod,ChronoUnit.MILLIS);
			 String t = sdf.format(d);
			 String t1 = dtf.format(ldt);
			System.out.printf("%s\t%s\t%d\t\t%s ldt= %s\n",list[i].isDirectory()?"[폴더]":"파일",list[i].getName(),list[i].length(),t,t1);
		} // for
		
	} // main
	
}
