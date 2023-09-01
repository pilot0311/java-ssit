package Programmer;

import java.time.LocalDate;

class Solution {
	public static void main(String[] args) {
		int[][] lines = { { 0, 1 }, { 2, 5 }, { 3, 9 } };
		int answer = solution(lines);
	} // main

	private static int solution(int[][] lines) {
		int answer = 0;
		return answer;
	}

	public static int solution(String[] babbling) {
		int answer = 0;
		String[] s = { "aya", "ye", "woo", "ma" };
		String regex = "^!+$";
		for (int i = 0; i < babbling.length; i++) {
			for (int j = 0; j < s.length; j++) {
				babbling[i] = babbling[i].replace(s[j], "!");
			} // for
			if (babbling[i].matches(regex))
				answer++;
		} // for
		return answer;
	}

	public static int solution(int age) {
		LocalDate ldt = LocalDate.of(2022, 1, 1);
		int answer = 0;
		ldt = ldt.minusYears(age);
		answer = ldt.getYear() + 1;
		return answer;
	}

}
