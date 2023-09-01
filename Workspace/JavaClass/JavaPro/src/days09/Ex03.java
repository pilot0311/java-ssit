package days09;

public class Ex03 {

	public static void main(String[] args) {
		// 주민등록번호
		// 생년월일, 성별(내국인/외국인), 검증
		String rrn = "890123-1700001";

		String birthday = getBirth(rrn);
		System.out.println(birthday);
	} // main

// 성별
	public static int getGender(String rrn) {
		return Integer.parseInt(rrn.substring(7, 8));
	}

	public static String getBirth(String rrn) {
		int year = Integer.parseInt(rrn.substring(0, 2)); // int형
		int month = Integer.parseInt(rrn.substring(2, 4));
		int day = Integer.parseInt(rrn.substring(4, 6));
		// System.out.printf("%s년 %s월 %s일\n",year,month,day);
		int g = getGender(rrn);
		int centry = 1800;
		switch (g) {
		case 1:
		case 2:
		case 5:
		case 6:
			centry = 1900; // int형
			break;
		case 3:
		case 4:
		case 7:
		case 8:
			centry = 2000;
			break;
		case 9:
		case 0:
			centry = 1800;
			break;

		default:
			break;
		} // switch
		year = centry + year;
		String birthday = String.format("%d.%s.%s\n", year, month, day);
		return birthday;
	}// getBirth
}
