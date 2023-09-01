package days18;

public class Ex07 {

	public static void main(String[] args) {
		
		//	[객체로 부터 Class 객체를 얻어오는 3가지 방법]
		//	1)	첫 번째 방법 :	getClass()메서드\
		/*
		Card card1 = new Card("HEART",3);
		Class cls = card1.getClass();
		System.out.println(cls.getName());
		System.out.println(cls.getName());
		*/
		
		//	2)두 번째 방법: 모든 클래스명.class 클래스변수가 제공된다
			/*
			Class cls = Card.class;	//Class 자료형 클래스 , .class 클래스 변수,  클래스 선언시 class 예약어
			System.out.println(cls);	//class days18.Card
			// => Class cls 얻어와서 객체 생성
			try {
				Card card2 = (Card) cls.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {		//멀티 캐치
				e.printStackTrace();
			}
		*/
		
		//	3) 세 반째 빙밥:	Class클래스의 static메서드 - forName()
		String className = "days18.Card";
		try {
			Class cls = Class.forName(className);
			System.out.println(cls);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	} // main
}

final class Card{
	String kind;	//카드 종료
	int num;			//카드 번호
	
	
	
	 Card() {
		this("SPADE",1);
	}



	Card(String kind, int num){
		this.kind=kind;
		this.num=num;
	}
}