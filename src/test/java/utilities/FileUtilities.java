package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtilities {

	public void getFileContent() {

		File myObj = new File("filename.txt");

		if (myObj.exists()) {
			System.out.println("File name: " + myObj.getName());
			System.out.println("Absolute path: " + myObj.getAbsolutePath());
			System.out.println("Writeable: " + myObj.canWrite());
			System.out.println("Readable " + myObj.canRead());
			System.out.println("File size in bytes " + myObj.length());
		} else {
			System.out.println("The file does not exist.");
		}
	}

	public static String readFile(String fileName) {
		String fileContent = "";

		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				fileContent += data;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return fileContent;
	}

}
