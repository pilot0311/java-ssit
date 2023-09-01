package days18;

public class Ex09_03 {

	public static void main(String[] args) {
		//testString();				//>String 처리 시간: 		3809385200ns
		// 									repeat 시간 					5345000ns
		// StringBuilder 			repeat 시간 					1426299ns
		//testStringBuffer();		//>StringBuffer 처리 시간:  9598800ns
		//testStringBuilder();	//>StringBuilder 처리 시간: 7955400ns
		
	} // main
	
	
	//String
	private static void testString() {
		long start = System.nanoTime();
		String s = "a".repeat(200000);
//		for (int i = 0; i < 200000; i++) {
//			s+="a";
//		} // for
		long end = System.nanoTime();
		System.out.printf(">String 처리 시간: %dns\n",(end-start));
	}

	//StringBuffer
	private static void testStringBuffer() {
		long start = System.nanoTime();
		StringBuffer sb = new StringBuffer("a");
		for (int i = 0; i < 200000; i++) {
			sb.append("a");
		} // for
		long end = System.nanoTime();
		System.out.printf(">StringBuffer 처리 시간: %dns\n",(end-start));
	}
	
	private static void testStringBuilder() {
		long start = System.nanoTime();
		StringBuilder sb = new StringBuilder("a");
//		for (int i = 0; i < 200000; i++) {
//			sb.append("a");
//		} // for
		sb= sb.append("a".repeat(200000));
		long end = System.nanoTime();
		System.out.printf(">StringBuilder 처리 시간: %dns\n",(end-start));
	}
	
}


