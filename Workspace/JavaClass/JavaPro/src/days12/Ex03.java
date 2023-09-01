package days12;

import java.util.Arrays;

public class Ex03 {

	public static void main(String[] args) {
		// 이진 검색(binarySearch) 필수조건: 정렬
		int[] m = { 0, 4, 5, 15, 20, 21, 22, 24, 25, 28, 29, 30, 32, 33, 40, 43, 46, 47, 48, 58, 62, 63, 71, 76, 86, 91,
				94, 99, 111, 116, 128, 135, 137, 139, 142, 145, 146, 150, 151, 160, 161, 166, 168, 169, 172, 181, 184,
				185, 191, 198 };
		System.out.println(Arrays.toString(m));
		//System.out.println(m.length); //50개
		int n = 86;
		
		int index = binarySearch(m,n);
		if (index == -1) {
			System.out.println("찾는 정수 없음");
		} else {
			System.out.println(index+"위치에 있다");
		} //else
	} // main

	private static int binarySearch(int[] m, int n) {
		int bottom = 0;
		int top = m.length-1;
		int mid;
		int count = 0;
		while (bottom<=top) {
			count ++;
			System.out.println("찾은 횟수:"+count);
			mid = (bottom+top)/2;
			if (n==m[mid]) {
				
				return mid;
			} else if(m[mid]<n){
				
				bottom = mid+1;
			} else if(m[mid]>n) {
				
				top = mid -1;
			}
		}
		
		return -1;
	}
}
