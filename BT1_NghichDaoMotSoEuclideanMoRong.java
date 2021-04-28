import java.util.Scanner;

public class BT1_NghichDaoMotSoEuclideanMoRong {

    public int EuclideanMoRong(int a, int b) {

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
        else {

            if (x < 0) {
                while (x < 0) {
                    x += 26;
                }
            }
            return x; // Có phần tử nghịch đảo là x
        }

    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Vui lòng nhập số a: ");
        int numberA = scan.nextInt();
        System.out.print("Vui lòng nhập số n: ");
        int numberN = scan.nextInt();
        BT1_NghichDaoMotSoEuclideanMoRong nghichdao = new BT1_NghichDaoMotSoEuclideanMoRong();
        int r = nghichdao.EuclideanMoRong(numberA, numberN);
        if (r == 0) {
            System.out.print("Không tồn tại phần tử nghịch đảo của a trên Zn");
        } else {
            if (r < 0) {
                while (r < 0) // Để ra kết quả phần tử nghịch đảo là số dương
                    r = r + numberN;
                System.out.print("Phần tử nghịch đảo của a trên Zn: " + r);
            } else
                System.out.print("Phần tử nghịch đảo của a trên Zn: " + r);
        }

    }
}
