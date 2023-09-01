package days11;


public class Ex01_03 {

	public static void main(String[] args) {
		int[] m = { 3, 92, 3, 40, 71, 91, 61, 92, 76, 71, 59, 54, 64, 48, 66, 92, 25, 20, 73, 37 };

		int []mc = maxList(m);

		System.out.printf("> max:%d, maxCount:%d\n", mc[0],mc[1]);

	} // main

	private static int[] maxList(int[] m) {
		 int max = m[0] , maxCount = 1;
	      for (int i = 1; i < m.length; i++) {
	         if( max == m[i]) maxCount++;
	         else if( max < m[i]) {
	            max = m[i];
	            maxCount = 1;
	         }
	      } // for

		//return new int[] {max,maxCount};
	      int[] mc ={max,maxCount};
	      return mc;
	}

} // class
