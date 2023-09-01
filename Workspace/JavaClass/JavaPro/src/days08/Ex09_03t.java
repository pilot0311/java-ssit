package days08;

public class Ex09_03t {

	public static void main(String[] args) {
		int [] lotto = new int[6];
	      
	      fillLotto(lotto); 
	       
	      dispLotto(lotto);
	      
	   } // main
	 
	   public static void fillLotto(int[] lotto) {
	      int index = 0;
	      int lottoNumber = (int)(Math.random() * 45)+1;      
	      lotto[index++] = lottoNumber;
	      boolean flag = false; // 로또번호가 중복이 되면 true 할당.
	      
	      while (index <= 5) {
	         flag = false;
	         lottoNumber = (int)(Math.random() * 45)+1;   //  12         
	         
	         // isDuplicateLotto() 중복이되면 true, 중복이되지않으면 false
	         if( !isDuplicateLotto(lotto,lottoNumber, index )) 
	            lotto[index++] = lottoNumber;
	               
	      } // while
	      
	      
	      
	      
	      /*
	      for (int i = 0; i < lotto.length ; i++) {
	         int lottoNumber = (int)(Math.random() * 45)+1;
	         lotto[i] = lottoNumber;
	      } // for
	      */
	   }

	   private static boolean isDuplicateLotto(int[] lotto, int lottoNumber, int index) {
	      for (int i = 0; i < index; i++) {
	         if( lotto[i] == lottoNumber ) {
	            return true;
	         } // if
	      } // for
	      
	      return false;
	   }

	   public static void dispLotto(int[] lotto) {
	      for (int i = 0; i < lotto.length; i++) {
	         System.out.printf("lotto[%d]=[%d]\n", i, lotto[i]);
	      } // for      
	      System.out.println();
	   }

	} // class
