package days26;

import java.io.File;

public class Ex06_06 {

	public static void main(String[] args) {
		// days26\\temp
		// ㄴ temp_a
		// ㄴ xxx
		// ㄴ yyy
		// ㄴ temp_b
		String pathname = ".\\src\\days26\\temp";
		File dir = new File(pathname);

//		if (dir.exists()) { // then the directory must be empty inorder to be deleted.
//			// System.out.println(dir.delete()); // false dir.delete() 는 빈 폴더여야지만 삭제 가능
//			
//			// deleteAll(dir);
//		} // if
		deleteFolders(dir);
	} // main

	// [1]
	private static void deleteFolders(File dir) {
		File[] childList = dir.listFiles();
		if (childList != null) {
			for (int i = 0; i < childList.length; i++) {
				File child = childList[i];
				deleteFolders(child);
				System.out.printf("> %s 를 삭제했습니다.\n", child);
			}
		}
		dir.delete();
		System.out.printf("> %s 를 삭제했습니다.\n", dir);
	}

	// [3]
//	private static void deleteFolders(File f) {
//		while(!f.delete()) {
//			File[] list = f.listFiles();
//			for (int i = 0; i < list.length; i++) {
//				if (list[i].delete()) {
//					System.out.printf("%s 삭제완료\n",list[i].getName());
//				} else {
//					deleteFolders(list[i]);
//				}
//			} // for
//		}
//	}

	// [2]
//	private static void deleteAll(File file) {
//	      File[] files = file.listFiles();
//	      for (int i = 0; i < files.length; i++) {
//	         if(files[i].isDirectory()) {
//	            deleteAll(files[i]);         
//	         }
//	         files[i].delete();
//	      } // for
//	   }

	// [test]
//	private static void deleteFolders(File dir) {
//		if (!dir.delete()) {
//			File[] list = dir.listFiles();
//			for (int i = 0; i < list.length; i++) {
//				File child = list[i];
//				deleteFolders(child);
//			} // for
//		} //if
//		
//	}

}
