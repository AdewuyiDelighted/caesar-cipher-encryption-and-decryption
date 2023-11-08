import java.util.Arrays;

public class CaesarEncryptionAndDecryption {

    static String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};


    public static String[] shuffleFirstAlphabetsByKey(int key) {
        String[] shiftLetterByKeyOnly = new String[alphabet.length];
        int beginningIndex = alphabet.length - key;
        int count = 0;
        for (int indexs = beginningIndex; indexs < alphabet.length; indexs++) {
            shiftLetterByKeyOnly[count] = alphabet[indexs];
            count++;
        }

        return shiftLetterByKeyOnly;
    }

    public static String[] moveAllAlphabetByKey(int key) {
        String[] arrangeAllAlphabetsByKey = shuffleFirstAlphabetsByKey(key);
        int count = key;
        int length = alphabet.length - key;
        for (int index = 0; index < length; index++) {
            arrangeAllAlphabetsByKey[count] = alphabet[index];
            count++;
        }
        return arrangeAllAlphabetsByKey;
    }

    public static int[] findIndexOfMessage(String messages) {
        int[] indexOfMessage = new int[messages.length()];

        for (int index = 0; index < messages.length(); index++) {
            String letter = String.valueOf(messages.charAt(index));
            for (int count = 0; count < alphabet.length; count++) {
                if (letter.equals(alphabet[count])) {
                    indexOfMessage[index] = count;
                }
            }
        }
        return indexOfMessage;
    }

    public static StringBuilder encrypted(int key, String message) {
        int[] indexOfMessage = findIndexOfMessage(message);

        String[] encryptedLetters = moveAllAlphabetByKey(key);
        StringBuilder encryptedMessage = new StringBuilder();

        for (int index = 0; index < indexOfMessage.length; index++) {
            int number = indexOfMessage[index];
            String encryptedSingleLetter = encryptedLetters[number];
            encryptedMessage.append(encryptedSingleLetter);
        }
        return encryptedMessage;
    }

    public static int[] findIndexOfEncryptedMessage(int key,String messages) {
        int[] indexOfEncryptedMessage = new int[messages.length()];

        for (int index = 0; index < messages.length(); index++) {
            String letter = String.valueOf(messages.charAt(index));
            for (int count = 0; count < moveAllAlphabetByKey(key).length; count++) {
                if (letter.equals(moveAllAlphabetByKey(key)[count])) {
                    indexOfEncryptedMessage[index] = count;
                }
            }
        }
        return indexOfEncryptedMessage;
    }

    public static StringBuilder decrypted(int key, String messages){
        int [] indexOfMessage = findIndexOfEncryptedMessage(key,messages);
        System.out.println(Arrays.toString(indexOfMessage));
        String[] normalAlphabet = alphabet;
        StringBuilder decryptedMessages = new StringBuilder();
        for(int count = 0; count < indexOfMessage.length; count++) {
            int index = indexOfMessage[count];
            String decryptedSingleLetter = normalAlphabet[index];
            decryptedMessages.append(decryptedSingleLetter);
        }

        return decryptedMessages;
    }


}
