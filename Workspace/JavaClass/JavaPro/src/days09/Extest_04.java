package days09;

public class Extest_04 {
	
	public static void main(String[] args) {
		//int year = 2030;
		
		for (int i = 2000; i <=2030; i++) {			
				System.out.printf("%d년은 %s 입니다",i,isLeapYear(i)?"윤년\n":"평년\n");
			

		} // for
	} // main
//	1.서력 기원 연수가 4로 나누어 떨어지는 해는 윤년으로 한다. (1988년, 1992년, 1996년, 2004년, 2008년, 2012년, 2016년, 2020년, 2024년, 2028년, 2032년, 2036년, 2040년, 2044년 ...)
//	2.서력 기원 연수가 4, 100으로 나누어 떨어지는 해는 평년으로 한다. (1700년, 1800년, 1900년, 2100년, 2200년, 2300년...)
//	3.서력 기원 연수가 4, 100, 400으로 나누어 떨어지는 해는 윤년으로 둔다. (1600년, 2000년, 2400년...)
//		400년마다 97번의 윤년
	// 4년마다 윤년 = 100번
	// 100년마다 평년 =4번 96번
	// 400년 평년 1번 97번

	public static boolean isLeapYear(int year) {
		if(year%4==0 && year%100 !=0 || year%400==0) return true;
		else return false;
		
	}

}// class
