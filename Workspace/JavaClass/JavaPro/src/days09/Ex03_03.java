package days09;

public class Ex03_03 {

	public static void main(String[] args) {
		//주민등록 번호 (rrn)
		//	1.	생년월일
		//	2.	성별, 세기,	내국인/외국인
		//	3.	세는 나이, 만 나이
		//	4.	주민번호 검증		ㅍ = 11-{(2×ㄱ+3×ㄴ+4×ㄷ+5×ㄹ+6×ㅁ+7×ㅂ+8×ㅅ+9×ㅇ+2×ㅈ+3×ㅊ+4×ㅋ+5×ㅌ) mod 11}단, 10은 0, 11은 1로 표기한다
		String rrn = "980311-1075115";
		boolean checkSum = checkRRN(rrn);
		if (checkSum) {
			System.out.println("올바른 주민등록 번호");
		}else System.out.println("잘못된 주민등록 번호");
		
	}
	
	private static boolean checkRRN(String rrn) {
		int total=0;
		int ㄱ = rrn.charAt(0)-'0';
		//int ㄴ = Integer.parseInt(rrn.substring(1, 2));
		int ㄴ = rrn.charAt(1)-'0';
		int ㄷ = rrn.charAt(2)-'0';
		int ㄹ = rrn.charAt(3)-'0';
		int ㅁ = rrn.charAt(4)-'0';
		int ㅂ = rrn.charAt(5)-'0';
		
		int ㅅ = rrn.charAt(7)-'0';
		int ㅇ = rrn.charAt(8)-'0';
		int ㅈ = rrn.charAt(9)-'0';
		int ㅊ = rrn.charAt(10)-'0';
		int ㅋ = rrn.charAt(11)-'0';
		int ㅌ = rrn.charAt(12)-'0';
		total+=ㄱ*2+ㄴ*3+ㄷ*4+ㄹ*5+ㅁ*6+ㅂ*7+ㅅ*8+ㅇ*9+ㅈ*2+ㅊ*3+ㅋ*4+ㅌ*5;
		int check = 11- total%11;
		if(check==10)check=0;
		else if(check==11)check=1;
		int ㅍ = rrn.charAt(13)-'0';
		
		return ㅍ==check?true:false;
	}
	//[내가 한것]
//	private static boolean checkRRN(String rrn) {
//		String mod = rrn.replace("-", "");
//		
//		int[] rnnArr = new int[mod.length()];
//		int sum=0;
//		for (int i = 0; i < rnnArr.length; i++) {
//			int m = i+2;	
//			rnnArr[i]=mod.charAt(i)-'0';
//			if(i<=mod.length()-1)
//			sum=sum+rnnArr[i]*m>=10?m-8:m;
//		} // for
//		if(rnnArr[rnnArr.length-1] == 11-sum)
//		return true;
//		else return false;
//	} 
}
