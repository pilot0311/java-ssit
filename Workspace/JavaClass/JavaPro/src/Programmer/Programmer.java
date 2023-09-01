package Programmer;

import java.util.Stack;

public class Programmer {

	public static void main(String[] args) {
		String s = "abc1Addfggg4556b";
		int start = 0;
		int n = 6;
		String[] ss = new String[s.length()%n==0?s.length()/n:(s.length()/n)+1];
		for (int i = 0; i < ss.length; i++) {
			ss[i] = (String) s.subSequence(start, n);
			start += n;
			n+=n;
		} // for
			
		}// main
	} 


