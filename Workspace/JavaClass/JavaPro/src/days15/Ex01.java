package days15;

import java.util.Arrays;

public class Ex01 {

	public static void main(String[] args) {
		String n = "keNik";
		String m = "kKnie";
		char[] nArr = n.toUpperCase().toCharArray();
		char[] mArr = m.toUpperCase().toCharArray();
		Arrays.sort(nArr);
		Arrays.sort(mArr);
		System.out.println(Arrays.equals(nArr, mArr));
		
//		int countn =0;
//		int countm =0;
//		for (int i = 0; i < n.length(); i++) {
//			if(Character.toString(n.charAt(i)).matches("^[a-zA-Z]$")) countn++;
//		} // for
//		for (int i = 0; i < m.length(); i++) {
//			if(Character.toString(m.charAt(i)).matches("^[a-zA-Z]$")) countm++;
//		} // for
//		
//		System.out.println(n.equalsIgnoreCase(m)&&countn==countm?"true":"false");
		
	} // main
}
