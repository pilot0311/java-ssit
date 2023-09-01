package days11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex02_03 {

	public static void main(String[] args) {
		// 배열
		int[]m = {3,5,2,4,1};
		List<Integer> list = new ArrayList();
		//int[] -> ArrayList변환
		//[1]
//		for (int i = 0; i < m.length; i++) {
//			list.add(m[i]);
//		} // for
		//[2]
		list = IntStream.of(m).boxed().collect(Collectors.toList());
		int index = list.indexOf(4);
		list.add(index, 100);
		System.out.println(list);
	} // main
}
