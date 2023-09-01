package days07;

public class Ex05 {

	public static void main(String[] args) {
		// 정규표현식
		// 1. 주민등록번호 000000-0000000

		// 숫자 [0-9] \d
		// 반복 횟수 ?(0,1) +(1,여러번) *(0,여러번)
		// {n} n만큼 반복 {n,m}n번부터m번까지 반복 {n, } n번이상 반복
//		String regex="[0-9]{6}-\\d{7}";	//숫자 6자리 - 숫자 7자리
//		String rrn="123456-1234567";
//		if (rrn.matches(regex)) {
//			System.out.println("올바른 주빈등록번호 형식");
//		} else {
//			System.out.println("잘못된 주빈등록번호 형식");
//		}

		// 2. 우편 번호 000-000, 00000
//		String zipCode = "123-456";
//		String zipCode2 = "12345";
//		String zipCode3 = "123456";
//		String zipCode4 = "123-a45";
//		String zipCode5 = "123-3456";
		String[] zipCodes = { "123-456", "12345", "123456", "123-a45", "123-3456" };

		String regex = "\\d{3}-\\d{3}|\\d{5}";
		boolean flag;
		for (int i = 0; i < zipCodes.length; i++) {
			flag = zipCodes[i].matches(regex);
			
			System.out.printf("%s - %s우편번호\n", zipCodes[i],flag?"올바른":"잘못된");
		} // for
	} // main
}
