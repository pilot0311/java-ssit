package days07;

public class Ex11_02 {

	public static void main(String[] args) {
		String code = "abc1abc1abc";
		int mode = 0;
		String ret = "";

		for (int i = 0; i < code.length(); i++) {
			if (code.charAt(i) != '1') {
				if (mode == 0 && i % 2 == 0) {
					ret += code.charAt(i);

				}

				if (mode != 0 && i % 2 != 0) {
					ret += code.charAt(i);
				}
			}
			if (code.charAt(i) == '1') {
				mode = mode == 0 ? 1 : 0;
			}
		}
		System.out.printf("%s", ret);
	} // main
}
