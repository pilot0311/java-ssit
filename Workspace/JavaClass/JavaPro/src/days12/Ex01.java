package days12;

public class Ex01 {
//순차검색
//버블정렬
//선택정렬
//학생 성적 2차원배열
//로또
	public static void main(String[] args) {
		int[] m = { 3, 92, 3, 40, 71, 91, 61, 92, 76, 71, 59, 54, 64, 48, 66, 92, 25, 20, 73, 37 };
		int max = 92;
		int beginIndex=0;
		int index = -1;
		boolean flag = false;
		while ((index=sequentialSearch(m,max,beginIndex)) != -1) {
			flag = true;
			System.out.printf("%d\n",index);
			beginIndex = index+1;
		}
		if(!flag) System.out.printf("없음");
	} // main
	

	private static int sequentialSearch(int[] m, int max, int beginIndex) {
		int index = -1;
		for (int i = beginIndex; i < m.length; i++) {
			if(max==m[i]) {
				 index = i;
				return index;
			}
		} // for
		return index;
	}
}
