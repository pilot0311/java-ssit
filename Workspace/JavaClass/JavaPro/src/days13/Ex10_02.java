package days13;

public class Ex10_02 {

	public static void main(String[] args) {
		//메서드의 리턴 자료형이 참조형
		Ex10_02 ex = new Ex10_02();
		int x=1,y=2;
		ex.sum(x,y);
	} // main
	
	public int sum (int x, int y) {
		int result = x+y;
		return result;
	}
}
