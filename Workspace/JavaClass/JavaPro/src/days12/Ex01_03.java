package days12;

public class Ex01_03 {

	public static void main(String[] args) {
		//[3][4]
		int[][]m= {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		int[][]n = new int[2][6];
		int[]k=new int[m.length*m[0].length];
		// 1차원  교환 int i =4*행+열;
		// [i/6][i%6]
		//00	01	02	03	10	11	12	13	20	21	22	23
		//00	01	02	03	04	05	10	11	12	13	14	15
		//1111
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				//n[][] = m[i][j];
			} // for
		} // for
	} // main
}
