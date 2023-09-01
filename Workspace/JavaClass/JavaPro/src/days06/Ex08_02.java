package days06;

public class Ex08_02 {

	public static void main(String[] args) {
		//6
		for(int i=1;i<=5;i++){
			for(int j=1;j<=Math.abs(3-i);j++){
				System.out.print("_"); 
			}
			for(int j=1;j<=2*i-1&&(j<=Math.abs(2*i-11));j++){
				
				System.out.print("*"); 
			}
			System.out.println("");
		} 
	} // main
}

//i1			x			j<=1
//i2			xxx		j<=3
//i3			xxxxx		j<=5
//i4			xxx		j<=3
//i5			x