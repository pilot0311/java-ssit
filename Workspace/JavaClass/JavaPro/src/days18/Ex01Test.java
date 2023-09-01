package days18;import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex01Test {

	public static void main(String[] args) {	
		
		
		String fileName = "E:\\Class\\Workspace\\JavaClass\\JavaPro\\src\\days17\\Ex01.java";
		int lineNumber = 1;
		String line;
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((line=br.readLine()) != null) {
				System.out.printf("%d: %s\n",lineNumber++,line);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
					
	} // main
}