package days26;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test3 {

	public static void main(String[] args) {
		String dir = System.getProperty("user.dir");

		String pathname = ".\\src";
		// String pathname = dir;
		String keyword = "fileName";
		File file = new File(pathname);
		findKeyword(file, keyword);
	} // main

	private static void findKeyword(File file, String keyword) {
		File[] list = file.listFiles();
		File f = null;
		String line = null;
		int lineNumber = 1;
		boolean foundInFile = false;

		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				findKeyword(list[i], keyword);
			} else {
				lineNumber = 1;
				f = list[i];
				String fileName = f.getName();
				String filepath = f.getPath();
				foundInFile = true;

				try (FileReader in = new FileReader(f); BufferedReader br = new BufferedReader(in)) {
					while ((line = br.readLine()) != null) {
						if (line.contains(keyword)) {
							if (foundInFile) {
								// System.out.println();
								System.out.printf("--------%s----------\n", filepath);
								foundInFile = false;
							}
							line = line.replaceAll(keyword, "[" + keyword + "]");
							System.out.printf("%d : %s\n", lineNumber, line);

						} // if

						lineNumber++;
					}
					if (!foundInFile) {
						System.out.println();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // for
	}
}
