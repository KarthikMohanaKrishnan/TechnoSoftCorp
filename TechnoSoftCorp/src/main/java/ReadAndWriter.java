import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Karthik
 *
 */
public class ReadAndWriter {

	@SuppressWarnings("resource")
	public boolean searchingForStringInFile(String name, boolean findEncryption) {
		File cacheFile = new File("Cache.txt");

		Scanner scanner;
		try {
			cacheFile.createNewFile();
			scanner = new Scanner(cacheFile);
			while (scanner.hasNextLine()) {
				final String lineFromFile = scanner.nextLine();
				if (lineFromFile.contains(name)) {
					String foundLine = lineFromFile;
					String[] parts = foundLine.split("-");
					if (findEncryption) {
						String foundString = parts[0];
						if (name.equalsIgnoreCase(foundString)) {
							System.out.println("Something wrong with selection and input");
							System.exit(0);
						}
					} else {
						String foundString = parts[1];
						if (name.equalsIgnoreCase(foundString)) {
							System.out.println("Something wrong with selection and input");
							System.exit(0);
						}
					}
					return true;
				}
			}
		} catch (FileNotFoundException e) {

			System.out.println("Unable to read the Cache File, Exception:\n" + e);
		} catch (IOException e) {

			System.out.println("Unable to read the Cache File, Exception:\n" + e);
		}

		return false;
	}

	public boolean writeToFile(String encryptedName, String decryptedName) {
		try {
			// PrintWriter out = new PrintWriter("Cache.TXT");
			// out.println(encryptedName + "|" + decryptedName);
			File file = new File("Cache.txt");
			FileWriter fileWriter = new FileWriter(file,true);
			fileWriter.write(System.getProperty("line.separator") +encryptedName + "-" + decryptedName);
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Unable to write to the Cache File, Exception:\n" + e);
			return false;
		}
		return true;

	}

	public String searchForOtherString(String name, boolean findEncryption) {
		String foundLine = null;
		String foundString = null;
		File cacheFile = new File("Cache.Txt");
		Scanner scanner;
		try {
			scanner = new Scanner(cacheFile);
			while (scanner.hasNextLine()) {
				final String lineFromFile = scanner.nextLine();
				if (lineFromFile.contains(name)) {
					foundLine = lineFromFile;
				}
			}
		} catch (FileNotFoundException e) {

			System.out.println("Unable to read the Cache File, Exception:\n" + e);
		}
		String[] parts = foundLine.split("-");
		if (findEncryption) {
			foundString = parts[0];
		} else {
			foundString = parts[1];
		}
		return foundString;

	}

}
