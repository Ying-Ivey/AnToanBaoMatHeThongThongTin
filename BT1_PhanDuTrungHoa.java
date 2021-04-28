import java.util.Scanner;

public class BT1_PhanDuTrungHoa {

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
            return x; // Có phần tử nghịch đảo là x
        }

    }

    public void phanDuTrungHoa(int a1, int a2, int a3, int m1, int m2, int m3) {
        int M = m1 * m2 * m3;
        int M1 = M / m1;
        int M2 = M / m2;
        int M3 = M / m3;
        int y1 = EuclideanMoRong(M1, m1);
        int y2 = EuclideanMoRong(M2, m2);
        int y3 = EuclideanMoRong(M3, m3);
        int x1 = a1 * M1 * y1 + a2 * M2 * y2 + a3 * M3 * y3;
        int x = x1 % M;
        System.out.println("Vậy x = " + x);

    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Vui lòng nhập số a1: ");
        int numbera1 = scan.nextInt();
        System.out.print("Vui lòng nhập số a2: ");
        int numbera2 = scan.nextInt();
        System.out.print("Vui lòng nhập số a3: ");
        int numbera3 = scan.nextInt();
        System.out.print("Vui lòng nhập số nguyên tố m1: ");
        int numberm1 = scan.nextInt();
        System.out.print("Vui lòng nhập số nguyên tố m2: ");
        int numberm2 = scan.nextInt();
        System.out.print("Vui lòng nhập số nguyên tố m3: ");
        int numberm3 = scan.nextInt();
        BT1_PhanDuTrungHoa phanDuTrungHoa = new BT1_PhanDuTrungHoa();
        phanDuTrungHoa.phanDuTrungHoa(numbera1, numbera2, numbera3, numberm1, numberm2, numberm3);

    }

}
