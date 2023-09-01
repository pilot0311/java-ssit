package days03;

/**
 * @author pilot
 * @date 2023. 7. 17. - 오후 2:27:19
 * @subject	단항연산자	연산우선순위 가장 높음
 * 						++	--	+	-	~(비트 부정 연산자)	!	(cast)등등
 * @content
 */
public class Ex05_05 {
	public static void main(String[] args) {
		//System.out.println(+3);	//양수
		//System.out.println(-3);	//음수
	//비트부정(틸드) 연산자	0 -> 1,	1 -> 0
		System.out.println(~5);	//-6
		//					0000	0101 = 5 	0000 0110	-> 1111	1001	-> 1111	1010
		//					1111	1010 = -6
	}
}
