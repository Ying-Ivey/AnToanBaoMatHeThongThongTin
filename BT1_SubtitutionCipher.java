import java.util.Scanner;

public class BT1_SubtitutionCipher {

    public static String encrypt(String key, String p) {
        String result = new String();
        int position = 0;
        for (int i = 0; i < p.length(); i++) {
            if (((int) p.charAt(i) < 97) || ((int) p.charAt(i) > 122)) {
                result += (char) (int) p.charAt(i);
            } else {
                position = (int) (p.charAt(i) % 97);
                result += key.charAt(position);
            }
        }
        return result;
    }

    public static int findPositionDecrypt(char encryptedText, String key) {
        int position = 0;
        for (int posDe = 0; posDe < key.length(); posDe++) {
            if ((char) encryptedText == (char) key.charAt(posDe))
                position = posDe;
        }
        return position;
    }

    public static String decrypt(String e, String key) {
        String result = new String();
        int position = 0;
        for (int i = 0; i < e.length(); i++) {
            if (((int) e.charAt(i) < 97) || ((int) e.charAt(i) > 122)) {
                result += (char) e.charAt(i);
            } else {
                position = findPositionDecrypt(e.charAt(i), key);
                result += (char) ('a' + position);
            }
        }
        return result;
    }

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Nhập khóa K (bảng chữ cái thay thế 26 chữ cái): ");

        String key = scan.nextLine();
        // xnyahpogzqwbtsflrcvmuekjdi
        System.out.println("Bảng chữ cái là: ");
        for (int a = 0; a < 26; a++) {
            System.out.print((char) ('a' + a) + "\t");
        }
        System.out.println("");
        System.out.println("Bảng chữ cái thay thế là:");
        for (int i = 0; i < 26; i++) {
            System.out.print(key.charAt(i) + "\t");
        }

        System.out.println("\n");
        System.out.print("Nhập bản rõ cần mã hóa P: ");
        String plaintext = scan.nextLine();
        String encryptedtext = encrypt(key, plaintext);
        System.out.println("Văn bản đã được mã hóa: " + encryptedtext);
        
        System.out.println("");
        System.out.print("Nhập bản mã: ");
        String ciphertext = scan.nextLine();
        String decryptedtext = decrypt(ciphertext, key);
        System.out.println("Văn bản đã được giải mã: " + decryptedtext);
    }
}