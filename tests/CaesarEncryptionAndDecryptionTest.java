import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CaesarEncryptionAndDecryptionTest {
    String[] alphabet;

    @BeforeEach
    public void setup() {
        alphabet = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    }
    @Test
    public void testThatFunctionShiftAccordingToTheKeyGivenToTheFunction(){
        String [] letters = alphabet;
        String [] newLetterWithKeyLettersOnly = CaesarEncryptionAndDecryption.shuffleFirstAlphabetsByKey(3);
        String [] answer = {"X","Y","Z",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
        assertArrayEquals(answer,newLetterWithKeyLettersOnly);
    }
    @Test
    public void testThatFunctionCanCanRearrangeAllAlphabetAccordingToKey(){
        String [] allAlphabetAreShiftedByKey = CaesarEncryptionAndDecryption.moveAllAlphabetByKey(3);
        String [] answer = {"X","Y","Z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W"};
        assertArrayEquals(answer,allAlphabetAreShiftedByKey);
    }
    @Test
    public void testThatFunctionCanEncryptWordAccordingToKey(){


    }


}