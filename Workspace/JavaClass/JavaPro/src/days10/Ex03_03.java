package days10;

import java.util.Arrays;

public class Ex03_03 {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		int[] arrCopy = Arrays.copyOfRange(arr, 2, 4);
		System.out.println(Arrays.toString(arrCopy));
		int[]m = new int [3];
		m[0]=1;
		m[1]=2;
		m[2]=3;
		
		int index = 3;
		
	
		if(index==m.length) {
			int []temp = new int [m.length+3];
			
			//System.arraycopy(m, 1, temp, 4, 2);
			System.arraycopy(m, 0, temp, 0, m.length);//		System.arraycopy(원본배열, 배열의 어디부터복사할껀지, 복사본, 복사본의 어디부터 쓸껀지, 원본에서 얼만큼 복사할지);
			m = temp;
			
			
		//	System.out.println(Arrays.toString(temp));
		}
		//m[3]=4;
		System.out.println(Arrays.toString(m));
		
	} // main
}
