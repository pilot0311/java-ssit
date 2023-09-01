package days09;

import java.util.Scanner;

public class Extest_05 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("돈 입력하세요: ");

			int money = sc.nextInt();
			int unit = 50000;
			boolean sw = false;
			int count = 0;

			while (unit >= 1) {
				count = money / unit;
				System.out.printf("%d원: %d개\n", unit, count);
				money %= unit;
				unit /= !sw ? 5 : 2;
				sw = !sw;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main
}// class
