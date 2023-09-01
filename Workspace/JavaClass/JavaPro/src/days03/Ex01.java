package days03;

public class Ex01 {

	public static void main(String[] args) {

		String name = "홍길동";
		System.out.printf("%s\n", name);
		System.out.printf("[%s]\n", name);
		System.out.printf("[%10s]\n", name);
		System.out.printf("[%-10s]\n", name);

		int n = 50;
		System.out.printf("%d\n", n);
		System.out.printf("%#o\n", n);
		System.out.printf("%#x\n", n);

		double pi = 3.141592;
		System.out.printf("%f\n", pi);
		System.out.printf("%.3f\n", pi);// 자동 반올림
		System.out.printf("[%10.3f]\n", pi);// 자동 반올림

		int no = 1;
		System.out.printf("%d\n", no);
		System.out.printf("%04d\n", no);//****중요
		
		System.out.printf("%d(%c)\n",65,65); 
		// java.util.MissingFormatArgumentException: Format specifier '%c' = 
		System.out.printf("%1$d(%1$c)\n",65); 
	}

}

//String name = "신기범";
//byte age = 20;
//char grade = 'A';
//boolean sex = true;
//System.out.printf(">이름: \"%s\", 나이: %d, 학점: '%c', 성별: %b", name, age, grade, sex);
//String name;
//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//System.out.print(">이름을 입력하세요: ");
//name = br.readLine();
//System.out.printf(">이름은 \"%s\"입니다",name);