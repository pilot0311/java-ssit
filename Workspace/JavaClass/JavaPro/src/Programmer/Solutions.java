package Programmer;

import java.util.Scanner;

public class Solutions {

	public static void main(String[] args) {
		//[1]
//		Scanner sc = new Scanner(System.in);
//        String a = sc.next();
//		if(!a.matches("^[a-zA-z]{1,20}$")) {
//			System.out.printf("영어가 아니거나 20글자를 넘어 갑니다.");
//			return;
//		}
//        char ch[] = new char[a.length()];
//       for(int i=0;i<a.length();i++) {
//    	   ch[i]=a.charAt(i);
//
//    	  if(ch[i]>='a') {
//    		  ch[i]= (char) ((int)ch[i]-32);
//    	  }else 
//    		  ch[i]= (char) ((int)ch[i]+32);    	  
//       }//for
//       a = String.valueOf(ch);
//       
//        System.out.printf("%s",a);
		//[2]
	        Scanner sc = new Scanner(System.in);
	        String a = sc.next();
	        String answer = "";

	        //Stack <Character> stack = new Stack <> ();

	        for(Character c : a.toCharArray()){
	            if(Character.isUpperCase(c)){
	                //stack.push(Character.toLowerCase(c));
	                answer += Character.toLowerCase(c);
	            }
	            else if(Character.isLowerCase(c)){
	                //stack.push(Character.toUpperCase(c));
	                answer += Character.toUpperCase(c);
	            }
	        } 
	        System.out.println(answer);
	}

}
