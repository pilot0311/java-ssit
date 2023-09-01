package days06;

public class Ex03 {

	public static void main(String[] args) {
		// [내가 한 방법]
//		for (int i = 'A'; i <= 'z'; i++) {
//			System.out.printf("%c(%1$03d)",i);
//			if(i<'Z' && i%10==4)
//				System.out.println();
//			if(i==90) 
//				i+=6;
//			if(i>96 && i%10==0)
//				System.out.println();

		// [1]
//		for (int i = 'A'; i <= 'Z'; i++) {
//			System.out.printf("%c(%1$03d)",i);
//			if(i%10==4)
//				System.out.println();
//		}
//		for (int i = 'a'; i <= 'z'; i++) {
//			System.out.printf("%c(%1$03d)",i);
//			if(i%10==0)
//				System.out.println();
//		}
// 2줄 나오고 입력
		for (int i = 'A', count = 1, number = 1; i <= 'z'; i++) {
			if (i > 'Z' && i < 'a')
				continue;
				
			if (count % 10 == 1)
				System.out.printf("%d:", number++);
			
			System.out.printf("%c(%1$03d)", i);
			
			if (count++ % 10 == 0)
				System.out.println();
			
			if(i=='Z') {
				System.out.println();
				count =1;
			}
		} // for

	} // main
}
