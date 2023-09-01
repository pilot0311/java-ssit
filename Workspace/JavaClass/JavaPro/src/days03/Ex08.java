package days03;

public class Ex08 {

	public static void main(String[] args) {
		//Type mismatch: cannot convert from double to float
		//float pi = (float) 3.141592;
		float pi = 3.141592f;
		//소수점 4번째 자리에서 반올림한 실수 값을 얻어와서 출력
		//System.out.printf("%.3f\n",pi);
		//[2]
		System.out.println(pi * 1000 + 0.5); // 3142.092
		System.out.println((int)(pi * 1000 + 0.5)); // 3142
		System.out.println((int)(pi * 1000 + 0.5)/1000f); // 3.142
		
		
		
		//[1]
		//pi = Float.parseFloat(String.format("%.3f", pi)); //"3.142"
		//System.out.println(pi);

	}//main

}//class
