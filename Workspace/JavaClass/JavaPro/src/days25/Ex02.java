package days25;

public class Ex02 {

	enum Direction {
		EAST, SOUTH, WEST, NORTH
	}

	public static void main(String[] args) {

		Direction d1 = Direction.EAST;

		System.out.println(d1);
		System.out.println(d1.name()); // 문자열 "EAST"
		System.out.println(d1.ordinal()); // 0 열거된 상수의 순서

		Direction d2 = Direction.valueOf(d1.name());
		System.out.println(d2);

		switch (d2) {
		case EAST:	//0	//	Direction 생략되고 상수만 적으면 된다
			break;
		case NORTH:		//3
			break;
		case SOUTH:		//1
			break;
		case WEST:		//2
			break;
		default:
			break;
		} // switch

	} // main

}
