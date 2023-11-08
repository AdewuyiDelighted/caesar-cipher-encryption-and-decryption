import java.util.Arrays;

public class CaesarEncryption {
    static String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static void main(String[] args) {

        System.out.println(encrypted(3, "HELLO"));
        System.out.println(decrypted(3,"HELLO"));
        System.out.println(Arrays.toString(findIndexOfMessage("HELLO")));

    }


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

    public static String[] moveAllAlphabetByKey(int key){
        String[] arrangeAllAlphabetsByKey = shuffleFirstAlphabetsByKey(key);
        int count = key;
        int length = alphabet.length - key;
        for (int index = 0; index < length; index++){
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

    public static String encrypted(int key, String message) {
        int [] indexOfMessage = findIndexOfMessage(message);

        String [] alphabet = moveAllAlphabetByKey(key);
        StringBuilder words = new StringBuilder();

        for (int index = 0; index < indexOfMessage.length; index++) {
            int number = indexOfMessage[index];
           String word = alphabet[number];
           words.append(word);
        }
        return words.toString();
    }
    public static StringBuilder decrypted(int key, String message) {
        int [] indexOfMessage = findIndexOfMessage(message);

        String [] alphabets = alphabet;
        StringBuilder word = new StringBuilder();
        for(int index = 0; index < indexOfMessage.length;index++){
            int number = indexOfMessage[index];
            String words = alphabets[number];
            word.append(words);
        }

        return word;
    }


}
