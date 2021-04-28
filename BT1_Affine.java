import java.util.Scanner;

public class BT1_Affine {
    public static String encrypt(String p, int a, int b) {
        String result = new String();
        for (int i = 0; i < p.length(); i++) {
            if (((int) p.charAt(i) < 97) || ((int) p.charAt(i) > 122)) {
                result += (char) p.charAt(i);
            } else {
                int temp = (((a * ((int) p.charAt(i) - 97)) + b) % 26);
                result += (char) (temp + 97);
            }
        }
        return result;
    }

    public static int EuclideanMoRong(int a, int b) {

        int x = 0, y = 0;
        int x2 = 1, x1 = 0, y2 = 0, y1 = 1;
        if (b == 0) {
            int d = a;
            x = 1;
            y = 0;
            return 0;
        }
        while (b > 0) {
            int q = a / b;
            int r = a - q * b;
            x = x2 - q * x1;
            y = y2 - q * y1;
            a = b;
            b = r;
            x2 = x1;
            x1 = x;
            y2 = y1;
            y1 = y;
        }
        int d = a;
        x = x2;
        y = y2;

        if (d > 1) // Phần tử nghịch đảo không tồn tại
            return 0;
        else
            return x; // Có phần tử nghịch đảo là x
    }

    public static String decrypt(String c, int a, int b) {
        String result = new String();
        int e = EuclideanMoRong(a, 26);
        while (e <= 0) {
            e += 26;
        }
        for (int i = 0; i < c.length(); i++) {
            if (((int) c.charAt(i) < 97) || ((int) c.charAt(i) > 122)) {
                result += (char) c.charAt(i);
            } else {
                int temp = (char) (e * ((c.charAt(i) - 97) - b + 208) % 26);
                result += (char) (temp + 97);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập a:");
        int a = sc.nextInt();
        System.out.println("Nhập b:");
        int b = sc.nextInt();
        System.out.println("Vậy khóa K (" + a + ", " + b + ")");

        System.out.println("Nhập bản rõ cần mã hóa P: ");
        sc.nextLine();
        String plaintextAffine = sc.nextLine();

        String encryptedtextAffine = encrypt(plaintextAffine, a, b);
        System.out.println("Văn bản sau mã hóa: " + encryptedtextAffine);

        System.out.println("\nNhập bản mã: ");
        String ciphertext = sc.nextLine();

        String decryptedtext = decrypt(ciphertext, a, b);
        System.out.println("Văn bản sau giải mã: " + decryptedtext);

    }
}
