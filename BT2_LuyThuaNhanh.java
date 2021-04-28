import java.util.Scanner;

public class BT2_LuyThuaNhanh {
    long modexp(long a, long x, long n) {
        long r = 1;
        while (x > 0) {
            if (x % 2 == 1)
                r = (r * a) % n;
            a = (a * a) % n;
            x /= 2;
        }
        return r;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input number a: ");
        int numberA = scan.nextInt();
        System.out.print("Please input number x: ");
        int numberX = scan.nextInt();
        System.out.print("Please input number N: ");
        int numberN = scan.nextInt();
        BT2_LuyThuaNhanh luythua = new BT2_LuyThuaNhanh();
        long result = luythua.modexp(numberA, numberX, numberN);
        System.out.println("Result is: " + result);
    }
}
