package days12;
//학생 성적 2차원배열
public class Ex03Test {

	public static void main(String[] args) {
		final int STUDENT_COUNT = 30;
		String name;
		int kor;
		int eng;
		int mat;
		int tot;
		int rank;
		double avg;
		int count = 0;
		String[] names = new String[STUDENT_COUNT];
		int[][] infos = new int[STUDENT_COUNT][5];
		double[] avgs = new double[STUDENT_COUNT];
		
		do {
			rank=1;
			name = getName(count);
			kor = getScore(count);
			eng = getScore(count);
			mat = getScore(count);
			tot = kor+eng+mat;
			avg = (double)tot/3;
			names[count]= name;
			names[count] = name;
			infos[count][0] = kor;
			infos[count][1] = eng;
			infos[count][2] = mat;
			infos[count][3] = tot;
			infos[count][4] = rank;
			avgs[count] = avg;
			count++;
		} while (count != STUDENT_COUNT);
		totRank(infos,count);
		disp(names,infos,avgs,count);
	} // main

	private static void disp(String[] names, int[][] infos, double[] avgs, int count) {
		for (int i = 0; i < count; i++) {
			System.out.printf("%d번 %s \t%d \t%d \t%d \t%d \t%d \t%.2f\n",i+1,names[i],infos[i][0],infos[i][1],infos[i][2],infos[i][3],infos[i][4],avgs[i]);
		} // for
		
	}

	private static void totRank(int[][] infos, int count) {
		for (int i = 0; i < count; i++) {
			infos[i][4]=1;
			for (int j = 0; j < count; j++) {
				if(infos[i][3]<infos[j][3]) {
					infos[i][4]++;
				}
			} // for
		} // for
		
	}

	private static int getScore(int count) {
		
		return (int)(Math.random()*101);
	}

	private static String getName(int count) {
		char[] names = new char[3];
		for (int i = 0; i < names.length; i++) {
			names[i]= (char)(Math.random()*('힝'-'가'+1)+'가');
		} // for
		String name = String.valueOf(names);
		return name;
	}
}
