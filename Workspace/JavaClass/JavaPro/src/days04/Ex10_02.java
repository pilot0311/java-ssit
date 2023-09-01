package days04;

import java.util.Iterator;

public class Ex10_02 {
	
	public static void main(String[] args) {
		//임의의 수 발생 시키는 클래스.메서드
		//double
		//임의의 수 발생 시키는 클래스.메서드 = Math.randon()
		// 0.0*3<=(int) Math.randon() <1.0*3
		// 1<= (int)(Math.randon()*3)+1 <4
		for (int i = 0; i < 5000; i++) {
			int v= (int)(Math.random()*3)+1;
			if(v<1||v>3)
//			System.out.println((int)(Math.random()*3)+1);
				System.out.println(v);
		} // for
		
		
	} // main
}// class
