package days19;

import java.util.Arrays;

public class Ex02 {

	public static void main(String[] args) {

		String my_str = "abc1Addfggg4556b";
		int n = 6;
		String[] answer = Solution.solution(my_str, n);

		System.out.println(Arrays.toString(answer));
	} // main
}

//my_str.length()%n==0?my_str.length()/n:(my_str.length()/n)+1;
class Solution {
	public static String[] solution(String my_str, int n) {
		int length = (int) Math.ceil((double) my_str.length() / n);
		String[] answer = new String[length];
		int beginIndex = 0, endIndex;
		String str = null;
		int my_strLength = my_str.length();
		int index = 0;
		while (index != length) {

			endIndex = beginIndex + n;
			if (endIndex > my_strLength)
				endIndex = my_strLength;
			str = my_str.substring(beginIndex, endIndex);
			answer[index++] = str;
			beginIndex += n;
		}

		return answer;
	}
}

/*
 * int i = 0, idx = 0; try { for ( ; i < my_strLength ; i+=n, idx++) {
 * answer[idx] = my_str.substring(i, i+n ); } } catch (Exception e) {
 * answer[idx] = my_str.substring(i); }
 */