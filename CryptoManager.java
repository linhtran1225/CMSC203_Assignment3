
/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This is a utility class that encrypts and decrypts a phrase using two
 different approaches. The first approach is called the Caesar Cipher and is a
 simple substitution cipher� where characters in a message are replaced by a
 substitute character. The second approach, due to Giovan Battista Bellaso,
 uses a key word, where each character in the word specifies the offset for
 the corresponding character in the message, with the key word wrapping around
 as needed.
 * Due: 03/19/2023
 * Platform/compiler: Window 10 Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Linh Tran
*/

public class CryptoManager {
	
	private static final int LOWER_RANGE = 32;
	private static final int UPPER_RANGE = 95;
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	public static int Wrap_arround (int key) {
		while (key > UPPER_RANGE) {
		 key = key - RANGE;
		}
		return key;
	}

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		for (int i = 0; i < plainText.length(); i++) {
			if (!(((int)(plainText.charAt(i)) >= LOWER_RANGE) && ((int)(plainText.charAt(i)) <= UPPER_RANGE))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		key = Wrap_arround(key);
		String result = "";
		char numText;
		int numRes;
		if (isStringInBounds(plainText) == false) {
			result = "The selected string is not in bounds, Try again.";
		}
		else {
			for (int i = 0; i < plainText.length(); i++) {
				numText = plainText.charAt(i);
				numRes = (int)(numText) + key;
				while (numRes > UPPER_RANGE) {
					numRes = numRes - RANGE;
				}
				result += Character.toString(numRes);
			}
		}
		return result;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		String result = "";
		char pChar;
		int belChar;
		for (int i = 0; i < plainText.length();i++) {
			pChar = plainText.charAt(i);
			belChar = (int)(pChar) + (int)(bellasoStr.charAt(i % bellasoStr.length()));
			while (belChar > UPPER_RANGE) {
				belChar = belChar - RANGE;
			}
			result += (char)(belChar);
		}
		return result;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		key = Wrap_arround(key);
		String original = "";
		char numText;
		int numRes;
		if (isStringInBounds(encryptedText) == false) {
			original = "The selected string is not in bounds, Try again.";
		}
		else {
			for (int i = 0; i < encryptedText.length(); i++) {
				numText = encryptedText.charAt(i);
				numRes = (int)(numText) - key;
				while (numRes < LOWER_RANGE) {
					numRes = numRes + RANGE;
				}
				original += Character.toString(numRes);
			}
		}
		return original;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String original = "";
		char enChar;
		int oChar;
		for (int i = 0; i < encryptedText.length(); i++) {
			enChar = encryptedText.charAt(i);
			oChar = (int)(enChar) - (int)(bellasoStr.charAt(i % bellasoStr.length()));
			while (oChar < LOWER_RANGE) {
				oChar = oChar + RANGE;
			}
			original += (char)(oChar);
		}
		return original;
	}
	
	
}
