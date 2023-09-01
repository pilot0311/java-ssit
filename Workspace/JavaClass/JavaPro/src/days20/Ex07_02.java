package days20;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Ex07_02 {

	public static void main(String[] args) {
		String strMoney = "1,234,567";
		int money = 0;
		//[1]
		//money = Integer.parseInt(strMoney.replace(",", ""));
		
		//[2]
		String pattern = "#,###";
		DecimalFormat df = new DecimalFormat(pattern);
		try {
			Number num = df.parse(strMoney);
			money = num.intValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(money);
		
		
	} // main
	
}
