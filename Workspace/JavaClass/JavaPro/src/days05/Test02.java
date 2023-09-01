package days05;

public class Test02 {
    public static void main(String[] args) {
        

        for (int i = 'A'; i <= 'Z'; i++) {
            System.out.printf("%c(%d)", (char) i,i);

          

            if (i % 10 == 4) { 
                System.out.println();
            }
        }
        
        for (int i = 'a'; i <= 'z'; i++) {
        	System.out.printf("%c(%d)", (char) i,i);

           
            if (i % 10 == 0) { 
                System.out.println();
            }
        }
    } // main
}
