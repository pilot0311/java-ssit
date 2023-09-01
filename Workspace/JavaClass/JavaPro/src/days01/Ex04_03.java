package days01;

public class Ex04_03 {

	public static void main(String[] args) {
		String name = "신기범";
		int age = 25;
		age = age - 2;  // age 값에 2를 뺀 후 age에 저장 (우선순위: 산술 연산자 > 대입 연산자)
		System.out.println("이름은 \"" + name + "\" 이고,\n나이는 \'" + age + "\'입니다");
		
		System.out.printf("이름은 \"%s\" 이고, 나이는 \'%d\' 입니다", name, age);
		//System.out.printf("출력형식 문자열", 출력할 값...);
		//						format == 출력형식
		// name 문자열 출력 할때 출력서식: %s
		// age 정수형 출력할때 출력서식: %d
//		System.out.println(age);
//		System.out.println(age-2);
		
	}// main
}// class