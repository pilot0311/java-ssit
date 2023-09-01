package days25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;
import java.util.stream.Stream;

import days25.Ex03.Direction;

public class Ex08_02 {

	public static void main(String[] args) throws IOException {
		
		String source = "package days25;\r\n"
				+ "\r\n"
				+ "public class Ex03 {\r\n"
				+ "\r\n"
				+ "//	enum Direction {\r\n"
				+ "//		//0		1			2			3			순서 \r\n"
				+ "//		EAST, SOUTH, WEST, NORTH\r\n"
				+ "//	}\r\n"
				+ "\r\n"
				+ "	// 문법 에러\r\n"
				+ "	// enum Direction {EAST=100, SOUTH=200, WEST=300, NORTH=400}\r\n"
				+ "\r\n"
				+ "	// The constructor Ex03.Direction(int) is undefined\r\n"
				+ "	// 생성자(1)X\r\n"
				+ "	// enum Direction {EAST(100), SOUTH(200), WEST(300), NORTH(400)}\r\n"
				+ "	enum Direction {\r\n"
				+ "		EAST(100, \"▶\"), SOUTH(200, \"▼\"), WEST(300, \"◀\"), NORTH(400, \"▲\")	;\r\n"
				+ "\r\n"
				+ "		private final int value;\r\n"
				+ "		private final String symbol;\r\n"
				+ "		\r\n"
				+ "		/*\r\n"
				+ "		Direction(int value) {\r\n"
				+ "			this.value = value;\r\n"
				+ "		}\r\n"
				+ "		*/\r\n"
				+ "		Direction(int value, String symbol) {\r\n"
				+ "			this.value = value;\r\n"
				+ "			this.symbol = symbol;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		public int getValue() {\r\n"
				+ "			return value;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		public String getSymbol() {\r\n"
				+ "			return symbol;\r\n"
				+ "		}\r\n"
				+ "		\r\n"
				+ "		//추상메서드 선언가능\r\n"
				+ "		//abstract int test(int i)\r\n"
				+ "		\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "	public static void main(String[] args) {\r\n"
				+ "		// [ 열거형에 멤버(필드 메서드) 추가하기 ]\r\n"
				+ "\r\n"
				+ "		// [열거형 구조 이해]\r\n"
				+ "		/*\r\n"
				+ "		 * 1. 열거형 enum Direction {EAST, SOUTH, WEST, NORTH} 2. 컴파릴러가 클래스 변환 class\r\n"
				+ "		 * Direction extends Enum{ static final Direction EAST = new Direction(\"EAST\");\r\n"
				+ "		 * static final Direction SOUTH = new Direction(\"SOUTH\"); static final Direction\r\n"
				+ "		 * WEST = new Direction(\"WEST\"); static final Direction NORTH = new\r\n"
				+ "		 * Direction(\"NORTH\");\r\n"
				+ "		 * \r\n"
				+ "		 * private String name;\r\n"
				+ "		 *\r\n"
				+ "		 * public int namel(){ return this.name; }\r\n"
				+ "		 *\r\n"
				+ "		 * private int ordinal;\r\n"
				+ "		 *\r\n"
				+ "		 * public int ordinal(){ return this.ordinal; }\r\n"
				+ "		 *\r\n"
				+ "		 * private Direction(String name){ this.name = name; } }\r\n"
				+ "		 */\r\n"
				+ "		\r\n"
				+ "		//	열겨형		oridnal()메서드에 의해서 열거형 상수를 사용하는데 상수값은 0,1,2,3, 순서를 반환\r\n"
				+ "		//	내가 원하는 정수값을 설정해서 사용할 수 있다\r\n"
				+ "		Direction[] dirrArr = Direction.values();\r\n"
				+ "		for (Direction dir : dirrArr) {\r\n"
				+ "			System.out.println(dir.name()+\"/\"+dir.ordinal()+\"/\"+dir.getSymbol()+\"/\"+dir.getValue());\r\n"
				+ "		} //foreach\r\n"
				+ "		/*\r\n"
				+ "		EAST/0/▶/100\r\n"
				+ "		SOUTH/1/▼/200\r\n"
				+ "		WEST/2/◀/300\r\n"
				+ "		NORTH/3/▲/400\r\n"
				+ "		*/\r\n"
				+ "	} // main\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "";
		
		//	[문제] source 문자열에서 [20번째 라인의 문자열을 line20라는 변수에 저장한후 출력하는 코딩] 
		//[1]
		/*
		String[] strArr = source.split("\r\n");
		String line20 = null;
		line20 = strArr[19];
		System.out.println(line20);	//private final String symbol;
	*/
		//라인단위 처리 할 수 있는 보조 스트림
		//[source] -> XXXReader문자 스트림 -> 보조스트림
		//	String		StringReader/StringWriter
		//[2]
		/*
		StringReader sr = new StringReader(source);
		BufferedReader br = new BufferedReader(sr);
		String line = null;
		//br.skip(0);	문자 스킵
		int i = 1;
		while (i++<20) {
		 br.readLine();	
		}
		line = br.readLine();
		*/
		
		//[3]
		//String[] strArr = source.split("\r\n");
		String line =  Stream.of(source.split("\r\n")).skip(19).findFirst().get();
		
		
		System.out.println(line);
	} // main
	
}
