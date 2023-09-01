package days08;

public class Ex10 {

	public static void main(String[] args) {
		//신용카드
		String card = "7665-8988-9234-5677";
		String[] cardArr = card.split("-");
		
		cardArr[(int)(Math.random()*4)] = "****";
		//[1]
		for (int i = 0; i < cardArr.length; i++) {
			System.out.printf(i==cardArr.length-1?"%s\n":"%s-",cardArr[i]);
		} // for
		//[2]
//		String printCard = String.format("%s-%s-%s-%s",cardArr[0],cardArr[1],cardArr[2],cardArr[3] );
		//[3]
		String printCard =	String.join("-", cardArr);
		
		System.out.println(printCard);
		
	} // main
}
