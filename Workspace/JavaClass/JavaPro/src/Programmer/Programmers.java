package Programmer;

import java.util.Arrays;

public class Programmers {

	public static void main(String[] args) {
		int numer1 =  1;
		int denom1 = 2;
		int numer2 = 3; 
		int denom2 = 4;
		int[] answer = Solution3.solution(numer1, denom1, numer2, denom2);
		System.out.println(Arrays.toString(answer));
				
	} // main
	
	 

}
class Solution2 {
    public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
    	//int[] answer = {};
    	numer1=numer1*denom2+numer2*denom1;
		denom1=denom1*denom2;
		int gcd= getGcd(numer1, denom1);
        int answer[] = {numer1/gcd, denom1/gcd};
        return answer;
    }
    public static int getGcd(int numer1, int denom1) {
		 
			if(numer1%denom1==0) {
				
				return denom1;
			}
			return getGcd(denom1, numer1%denom1);
		}
   
}

class Solution3 {
    public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int mother = denom1 * denom2;
        int son1 = denom1 * numer2;
        int son2 = denom2 * numer1;
        int totalSon = son1 + son2;
        for(int i = mother; i >= 1; i--){
            if(totalSon % i == 0 && mother % i == 0){
                totalSon /= i;
                mother /= i;
            }
        }
        int[] answer = {totalSon, mother};
        return answer;
    }
}