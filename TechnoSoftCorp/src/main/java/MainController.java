/**
 * 
 */

/**
 * @author Karthik
 *
 */
public class MainController {

	private static final int DIVIDER = 2;
	private static final int INT_ZERO = 0;
	private static final String PADDER = "#";

	public static String encryption(String inputName) {
		if (inputName.length() % DIVIDER != INT_ZERO)
			inputName = inputName + PADDER;
		int nameLength = inputName.length() / DIVIDER;
		String encryptedString = rotateString(inputName, nameLength);
		return encryptedString;
	}

	public static String decryption(String inputName) {
		int nameLength = inputName.length() / DIVIDER;
		String decryptString = rotateString(inputName, nameLength);
		if (decryptString.contains(PADDER))
			decryptString = decryptString.replace(PADDER, "");
		return decryptString;
	}

	private static String rotateString(String inputString, int rotateByNbr) {
		// Count the length of String
		int i = INT_ZERO;
		if (inputString != null)
			i = inputString.length();
		return inputString.substring(i - rotateByNbr, i) + inputString.substring(INT_ZERO, i - rotateByNbr);
	}

}
