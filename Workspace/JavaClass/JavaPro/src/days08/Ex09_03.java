package days08;

public class Ex09_03 {

	public static void main(String[] args) {
		// 배열 초기화 안하면 기본형의 초기값으로 설정 int의 기본값: 0
		int[] lotto = new int[6];
		fillLotto(lotto);
		dispLotto(lotto);

	} // main
	//int lottoNumber = (int) (Math.random() * 45) + 1;
	//lotto[i] = lottoNumber;

	private static void fillLotto(int[] lotto) {
		int index=0;
		int lottoNumber = (int)(Math.random()*45)+1;
		lotto[index++] = lottoNumber;
		boolean flag = false; //로또 번호 중복시 true
		 while (index <=5) {
			 lottoNumber = (int)(Math.random()*45)+1;
			 //isDuplicateLotto()중복이면 true, 중복이아니면 false
			if(!isDuplicateLotto(lotto,lottoNumber,index))
				lotto[index++]=lottoNumber;
			
		}//while

	}//fillLotto

	private static boolean isDuplicateLotto(int[] lotto, int lottoNumber, int index) {
		 for (int i = 0; i < index; i++) {
				if (lotto[i]==lottoNumber) {
					return true;
				} //if
			} // for
		return false;
	}

	private static void dispLotto(int[] lotto) {
		for (int i = 0; i < lotto.length; i++) {
			System.out.printf("lotto[%d]= %d\n", i, lotto[i]);
		} // for
	}// dispLotto
}// class
