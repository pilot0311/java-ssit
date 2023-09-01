package days12;

/**
 * @author pilot
 * @date 2023. 7. 28. - 오후 2:45:25
 * @subject	가변배열
 * @content
 */
public class Ex05_02 {

	public static void main(String[] args) {
		// class5 =20	class4=30	class3=25
		String [][]names = new String[3][];
		names[0]=new String[25];
		names[1]=new String[20];
		names[2]=new String[30];
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < names[i].length; j++) {
				System.out.print("[]");
			} // for
			System.out.println();
		} // for
	} // main
}
