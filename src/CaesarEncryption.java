import java.util.Scanner;


public class CaesarEncryptionAndDecryptionMain {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key of the caesar message you want to encrypt");
        int key = scanner.nextInt();
        System.out.println("Enter the message you want to encrypt");
        String message = scanner.next().toUpperCase();


        System.out.println(CaesarEncryptionAndDecryption.encrypted(key, message));
    }

}
