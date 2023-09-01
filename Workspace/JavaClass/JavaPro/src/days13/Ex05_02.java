package days13;

/**
 * @author kenik
 * @date 2023. 7. 31. - 오후 12:18:45
 * @subject  
 * @content
 */
public class Ex05_02 {

   public static void main(String[] args) {
      /*
       * [배열 초기화]
       * int [] m = new int[3];
       * m[0]=1;
       * m[1]=2;
       * m[2]=3;
       * 
       * int [] m = new int[]{1,2,3};
       * int [] m = {1,2,3};
       * */
      
      // [클래스 배열 초기화]
      /*
      Tv [] tvArr = new Tv[3];
      tvArr[0] = new Tv();
      tvArr[1] = new Tv();
      tvArr[2] = new Tv();
      
      for (int i = 0; i < tvArr.length; i++) {
         tvArr[i] = new Tv();
      } // for
      */
      /*
      Tv [] tvArr = new Tv[] {
            new Tv(),
            new Tv(),
            new Tv()
      };
      */      
      Tv [] tvArr =  {
		                        new Tv(),
		                        new Tv(),
		                        new Tv()
		                  };
      
       
      tvArr[0].power();
      System.out.println("Tv : " + (tvArr[0].power ? "ON" : "OFF" ));
      tvArr[0].channelUp();
      System.out.println("현재 채널 : " + tvArr[0].channel);
      tvArr[0].power();
      System.out.println("Tv : " + (tvArr[0].power ? "ON" : "OFF"));
      System.out.println(" end ");

      

   } // main

} // class






