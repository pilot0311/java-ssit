package days09;

public class Extest {

	public static void main(String[] args) {
		int[] lotto = new int[6];
		fillLotto(lotto);
		dispLotto(lotto);
	}//main
	
	private static void fillLotto(int[] lotto) {
		int lottoNumber;
		int index=0;
		while (index<6) {
			lottoNumber = (int)(Math.random()*6)+1;
			if(!isDuplicateLotto(lotto,lottoNumber,index))
				lotto[index++]=lottoNumber;
		}
	}//fillLotto

	private static boolean isDuplicateLotto(int[] lotto, int lottoNumber, int index) {
		for (int i = 0; i <=index; i++) {
			if(lotto[i]==lottoNumber)
				return true;
			
		} // for
		return false;
	}//isDuplicateLotto

	private static void dispLotto(int[] lotto) {
		for (int i = 0; i < lotto.length; i++) {
			System.out.printf("lotto[%d]=[%d]\n",i,lotto[i]);
		} // for
		
	}//dispLotto

}//class
