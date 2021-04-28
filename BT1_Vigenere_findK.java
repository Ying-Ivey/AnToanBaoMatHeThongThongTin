import java.util.ArrayList;

public class BT1_Vigenere_findK {

    public static String findStringKeyInCipherText(String p, String c, int m) {
        String key = new String();
        String resultKey = new String();
        for (int i = 0; i < p.length(); i++) {
            if (((int) c.charAt(i) < 97) || ((int) c.charAt(i) > 122)) {
                continue;
            } else {
                int charAtPlainText = ((int) c.charAt(i) - 97) - ((int) p.charAt(i) - 97);
                if (charAtPlainText < 0) {
                    charAtPlainText = 26 + ((int) c.charAt(i) - 97) - ((int) p.charAt(i) - 97);
                }
                key += (char) ('a' + (charAtPlainText % 26));
            }
        }
        for (int j = 0; j < m; j++) {
            resultKey += key.charAt(j);
        }
        return resultKey;
    }

    public static void main(String[] args) {
        String fileUrl = "D:\\Downloads\\Vigenere.txt";
        ArrayList<String> stringsArray = new ArrayList<String>();
        String m = new String();
        String plaintext = new String();
        String ciphertext = new String();
        // doc file
        BT1_Vigenere_findK_input_output_file file = new BT1_Vigenere_findK_input_output_file();
        stringsArray = file.readfile(fileUrl);
        m = stringsArray.get(0);
        int lengthM = Integer.parseInt(m);
        plaintext = stringsArray.get(1);
        ciphertext = stringsArray.get(2);
        System.out.println("Length M: " + lengthM);
        System.out.println("Plain text: " + plaintext);
        System.out.println("Cipher text: " + ciphertext);

        String key = findStringKeyInCipherText(plaintext, ciphertext, lengthM);
        System.out.println("Key: " + key);
    }
}