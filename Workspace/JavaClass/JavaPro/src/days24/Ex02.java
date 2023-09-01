package days24;

import java.util.Enumeration;
import java.util.Properties;

public class Ex02 {

	public static void main(String[] args) {
		//	Properties 컬렉션 클래스
		//	setProperty(),	getProperty()
		//	key "user.dir"
		
		//												. 현재 디렉토리
		//												.. 상위 디렉토리
		//	자바프로젝트명 == 기본 폴더
		//E:\Class\Workspace\JavaClass\JavaPro
		//String userDir = System.getProperty("user.dir");	
		//System.out.println(userDir);
		
		Properties sysProps = System.getProperties();
		Enumeration<Object> en = sysProps.keys();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String value = System.getProperty(key);
			System.out.printf("%s  :  %s\n",key,value);
		}
		
	} // main
	
}
