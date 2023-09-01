package days13;

public class Student {
	// 멤버 = 멤버변수(필드) + 멤버함수(메서드)
	// 필드
	public int no;
	public String name;
	public int kor;
	public int eng;
	public int mat;
	public int tot;
	public double avg;
	public int rank;
	public int wrank;

	// 메서드
	public void printStudedntInfor() {

		System.out.printf("%d번 \t%s \t%d \t%d \t%d \t%d \t%.2f \t%d등 \t%d등\n", no, name, kor, eng, mat, tot, avg, rank,
				wrank);

	}
}
