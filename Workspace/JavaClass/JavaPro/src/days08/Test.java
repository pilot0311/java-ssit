package days08;

public class Test {

	public static void main(String[] args) {
		//switch 문
		int money = 125760;
		int count = 50000;
		boolean sw = true;

		String[] sdon = {"5만원", "1만원", "5천원", "1천원","5백원", "1백원","5십원", "1십원", "5원", "1원"};
		
		for(int i = 0; i<10; i++) {
			System.out.printf("%s: %d개\n",sdon[i],money/count);
			money%=count;
			if(sw) {
				count/=5;
				sw=false;
			}else if(!sw && count != 1){
				count/=2;	
				sw=true;
			}
		}
		
	} // main
}
