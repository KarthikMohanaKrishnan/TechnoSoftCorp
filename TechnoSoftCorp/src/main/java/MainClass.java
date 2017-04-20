import java.util.Scanner;

/**
 * 
 */

/**
 * @author Karthik
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReadAndWriter readAndWriter = new ReadAndWriter();
		MainController mainController = new MainController();
		System.out.println("Enter 1 for Encryption and 2 for Decryption");
		System.out.println("\n Enter your choice:");
		Scanner sc = new Scanner(System.in);
		int choiceForService = sc.nextInt();
		System.out.println("\n Enter your text/name:");
		String name = sc.next();
		boolean findFlag = false;
		if (choiceForService == 1) {
			findFlag = readAndWriter.searchingForStringInFile(name, true);
			// Encryption
			if (findFlag) {
				// Found name
				String encryptedString = readAndWriter.searchForOtherString(name, true);
				System.out.println("encrypting "+name);
				System.out.println(name+" found in cache");
				System.out.println("result = "+encryptedString);
//				System.out.println("Encrypted name: " + encryptedString);
//				System.out.println("Decrypted name: " + name);
			} else {
				// Writing decryption and encryption to file
				String encryptedName = mainController.encryption(name);
				boolean writeflag = readAndWriter.writeToFile(encryptedName, name);
				System.out.println("encrypting "+name);
				System.out.println("adding to cache");
				System.out.println("result = "+encryptedName);
//				if (writeflag) {
//					System.out.println("File is writed successfully!");
//				}
			}
		} else {
			findFlag = readAndWriter.searchingForStringInFile(name, false);

			// Decryption
			if (findFlag) {
				String decryptedString = readAndWriter.searchForOtherString(name, false);
				System.out.println("decrypting "+name);
				System.out.println(name+" found in cache");
				System.out.println("result = "+decryptedString);
//				System.out.println("Encrypted name: " + name);
//				System.out.println("Decrypted name: " + decryptedString);
			} else {
				// Writing encryption and decryption to file
				String decryptedName = mainController.encryption(name);
				boolean writeflag = readAndWriter.writeToFile(name,decryptedName);
				System.out.println("decrypting "+name);
				System.out.println("adding to cache");
				System.out.println("result = "+decryptedName);
//				if (writeflag) {
//					System.out.println("File is writed successfully!");
//				}
			}

		}

	}

}
