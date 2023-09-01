package days15;

import days13.Tv;

public class Ex03 {

	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 11;
		ctv.channelDown();
		System.out.println(ctv.channel);
		ctv.dispCaption("Hellow");
		ctv.caption=true;
		ctv.dispCaption("Hellow World");
	} // main
}

//기존 TV클래스 + 자막TV
class CaptionTv extends Tv {
	boolean caption; //자막 기능 on/off  true/false
	
	void dispCaption(String text) {
		if(this.caption)System.out.println(text);
	}
	
}