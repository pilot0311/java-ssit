package days22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
//[시험]
public class Ex15_02 {

	public static void main(String[] args) {
		
		 int gameNumber = 1;
	      Scanner scanner = new Scanner(System.in);
	      System.out.print("> 게임 횟수 입력 ? ");
	      gameNumber = scanner.nextInt();  // 3
	      
	      ArrayList lottos = new ArrayList();
	      
	      LinkedHashSet lotto = null;
	      for (int i = 0; i < gameNumber ; i++) {
	         lotto = new LinkedHashSet();      
	         fillLotto(lotto);
	         lottos.add(lotto);
	      } // for 
	      
	      dispLotto(lottos);

	} // main



	public static void dispLotto(ArrayList lottos) {
		Iterator ir = lottos.iterator();
		while (ir.hasNext()) {
			LinkedHashSet lotto = (LinkedHashSet) ir.next();
			System.out.println(lotto);
		}

	}

	public static void fillLotto(HashSet lotto) {
		Random rnd = new Random();
		while (lotto.size() < 6) {
			int n = rnd.nextInt(45)+1;
			lotto.add(n);
		}
	}
		
}

/*게임횟수를 입력받아 로또 번호를 출력하는 코딩을 하세요 . 
게임 횟수 입력 ? 3

1게임 : [17][9][4][15][16][38]   
2게임 : [17][9][4][15][16][38]   
3게임 : [17][9][4][15][16][38]
*/