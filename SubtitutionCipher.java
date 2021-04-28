import java.util.Scanner;

public class SubtitutionCipher {
    // char[] kyTu = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
    // 'k', 'l', 'm', 'n', 'o', 'p',
    // 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static int findPositionEncrypt(char charInPlainText, char[] kyTu) {

        int position = -1;
        for (int posEn = 0; posEn < kyTu.length; posEn++) {
            if (charInPlainText == kyTu[posEn])
                position = posEn;
        }
        return position;
    }

    public static int findPositionDecrypt(char encryptedText, char[] key) {

        int position = -1;
        for (int posDe = 0; posDe < key.length; posDe++) {
            if (encryptedText == key[posDe])
                position = posDe;
        }

        return position;
    }

    public static String encrypt(char[] key, char[] p) {
        String result = new String();
        int position = -1;
        for (int indexp = 0; indexp < p.length; indexp++) {
            position = findPositionEncrypt(p[indexp], key);
            result += key[position];
        }
        return result;
    }

    public static String decrypt(char[] e, char[] kyTu) {
        String result = new String();
        int position = -1;
        for (int indexe = 0; indexe < e.length; indexe++) {
            position = findPositionDecrypt(e[indexe], kyTu);
            result += kyTu[position];
        }
        return result;
    }

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        // String[] kyTu = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i",
        // "j", "k", "l", "m", "n", "o", "p",
        // "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        char[] kyTu = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        System.out.println("Nhập bảng chữ cái thay thế");

        char key[] = scan.next().toCharArray();

        System.out.println("Bảng chữ cái thay thế là: ");
        for (int a = 0; a < 5; a++) {
            System.out.print((char) ('a' + a) + "\t");
        }
        System.out.println("");
        for (int i = 0; i < 5; i++) {
            System.out.print(key[i] + "\t");
        }
        System.out.println("");
        System.out.println("Nhập bản rõ: ");
        // String plaintext = scan.next();
        char[] plaintext = scan.next().toCharArray();

        String encryptedtext = encrypt(key, plaintext);
        System.out.println("Văn bản đã được mã hóa: " + encryptedtext);

        System.out.println("Nhập bản mã: ");
        String ciphertext = scan.next();
        char[] c = ciphertext.toCharArray();

        String decryptedtext = decrypt(c, kyTu);
        System.out.println("Văn bản đã được mã hóa: " + decryptedtext);

    }

    // System.out.println("Nhập khóa k (bảng mã thay thế 26 chữ cái): ");
}
