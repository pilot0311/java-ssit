package days08;

public class Ex09_02 {

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
			 flag=false;
			 lottoNumber = (int)(Math.random()*45)+1;
			 //중복 확인
			 for (int i = 0; i < index; i++) {
				if (lotto[i]==lottoNumber) {
					flag = true;
					break;
				} //if
			} // for
			 if(!flag)lotto[index++]=lottoNumber;
		}//while

	}//fillLotto

	private static void dispLotto(int[] lotto) {
		for (int i = 0; i < lotto.length; i++) {
			System.out.printf("lotto[%d]= %d\n", i, lotto[i]);
		} // for
	}// dispLotto
}// class
