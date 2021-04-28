import java.util.Scanner;

public class BT1_MatMaCaesar {

    public static String encrypt(String text, int k) {
        String text1 = text.toLowerCase();
        String result = new String();

        for (int i = 0; i < text1.length(); i++) {

            if (((int) text1.charAt(i) < 97) || ((int) text1.charAt(i) > 122)) {
                result += (char) (int) text1.charAt(i);
            } else {

                char temp = (char) (((int) text1.charAt(i) + k - 97) % 26 + 97);
                if (temp > 'z')
                    result += (char) (((int) text1.charAt(i) + (26 - k) - 97) % 26 + 97);
                else
                    result += (char) (((int) text1.charAt(i) + k - 97) % 26 + 97);
            }
        }

        return result;
    }

    public static String decrypt(String text, int k) {
        String text1 = text.toLowerCase();
        String result = new String();

        for (int i = 0; i < text1.length(); i++) {

            if (((int) text1.charAt(i) < 97) || ((int) text1.charAt(i) > 122)) {
                result += (char) (int) text1.charAt(i);
            } else {

                char temp = (char) (((int) text1.charAt(i) - k - 97) % 26 + 97);
                if (temp < 'a')
                    result += (char) (((int) text1.charAt(i) + 26 - k - 97) % 26 + 97);
                else
                    result += (char) (((int) text1.charAt(i) - k - 97) % 26 + 97);
            }
        }

        return result;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("---------Thực hiện mã hóa---------");
        System.out.println("");
        System.out.println("Nhập chuỗi cần mã hóa: ");
        String plaintext = scan.nextLine();
        System.out.println("Vui lòng nhập giá trị khóa k: ");
        int k = scan.nextInt();
        System.out.println("Chuỗi đã được mã hóa: ");
        String encryptedtext = encrypt(plaintext, k);
        System.out.println(encryptedtext);
        System.out.println("");

        System.out.println("---------Thực hiện giải mã---------");
        System.out.println("");
        System.out.println("Chuỗi cần giải mã: " + encryptedtext);
        System.out.println("Với giá trị khóa k = " + k);
        String plaintextOutput = decrypt(encryptedtext, k);
        System.out.println("Chuỗi đã được giải mã: " + plaintextOutput);

    }
}
