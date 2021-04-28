import java.util.Scanner;

public class BT1_Vigenere {

    public static String TranferKeyLengthAsPlainText(String p, int m, String key) {
        String keyLengthAsPlaintText = new String();
        int j = 0;
        for (int i = 0; i < p.length(); i++) {
            if (((int) p.charAt(i) < 97) || ((int) p.charAt(i) > 122)) {
                keyLengthAsPlaintText += (char) p.charAt(i);
                continue;
            }
            keyLengthAsPlaintText += key.charAt(j++ % m);
        }
        return keyLengthAsPlaintText;
    }

    public static String encrypt(String p, int m, String key) {
        String result = new String();
        String keyLengthAsPlainText = TranferKeyLengthAsPlainText(p, m, key);
        for (int i = 0; i < p.length(); i++) {
            if (((int) p.charAt(i) < 97) || ((int) p.charAt(i) > 122)) {
                result += (char) p.charAt(i);
            } else {
                int indexAtCipherText = ((int) p.charAt(i) - 97) + ((int) keyLengthAsPlainText.charAt(i) - 97);
                result += (char) ('a' + (indexAtCipherText % 26));
            }
        }
        return result;
    }

    public static String decrypt(String c, int m, String key) {
        String result = new String();
        String keyLengthAsPlainText = TranferKeyLengthAsPlainText(c, m, key);
        for (int i = 0; i < c.length(); i++) {
            if (((int) c.charAt(i) < 97) || ((int) c.charAt(i) > 122)) {
                result += (char) c.charAt(i);
            } else {
                int charAtPlainText = ((int) c.charAt(i) - 97) - ((int) keyLengthAsPlainText.charAt(i) - 97);
                if (charAtPlainText < 0) {
                    charAtPlainText = 26 + ((int) c.charAt(i) - 97) - ((int) keyLengthAsPlainText.charAt(i) - 97);
                }
                result += (char) ('a' + (charAtPlainText % 26));
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập độ dài M:");
        int m = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập khóa K: ");
        String key = sc.nextLine();
        System.out.println("Nhập bản rõ cần mã hóa P: ");
        String plaintext = sc.nextLine();
        String encryptedtextAffine = encrypt(plaintext, m, key);
        System.out.println("Văn bản sau mã hóa: " + encryptedtextAffine);

        System.out.println("\nNhập bản mã: ");
        String ciphertext = sc.nextLine();

        String decryptedtext = decrypt(ciphertext, m, key);
        System.out.println("Văn bản sau giải mã: " + decryptedtext);

    }
}
