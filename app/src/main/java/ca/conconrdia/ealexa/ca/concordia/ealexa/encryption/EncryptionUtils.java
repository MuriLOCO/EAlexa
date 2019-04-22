package ca.conconrdia.ealexa.ca.concordia.ealexa.encryption;

public class EncryptionUtils {

    /**
     * Encrypts the plain text using the corresponding key
     *
     * @param plainText - Plain text to be ted
     * @param key       - Current key
     * @return Cipher Text in String format
     */
    public static String encrypt(final String plainText, final String key) {
        final char[] plainTextChar = plainText.toUpperCase().toCharArray();
        final char[] keyChar = key.toUpperCase().toCharArray();
        final StringBuffer cipherText = new StringBuffer();

        for (int i = 0; i < plainTextChar.length; i++) {
            int position = checkAlphabetPosition(plainTextChar[i]);
            cipherText.append(keyChar[position]);
        }
        return cipherText.toString();
    }

    /**
     * Checks the position of the current char based on the selected alphabe
     * @param  - Current char
     * @return Position of the char in a int format
     */
    private static int checkAlphabetPosition(final char c) {
        int currentCharPosition = 0;
        final char[] alphabetIntoArray = BaseVariables.NUMBER_ORDER.toCharArray();
        for (int i = 0; i < alphabetIntoArray.length; i++) {
            if (c == alphabetIntoArray[i]) {
                currentCharPosition = i;
                break;
            }
        }
        return currentCharPosition;
    }
}
