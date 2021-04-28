import java.util.Scanner;

public class BT2_EuclideanMoRong
{
   public void Euclid(int a, int b)
   {
      int x=0,y=0;
      int x2=1, x1=0, y2=0, y1=1;
      if (b==0){
         int d=a;
         x=1;
         y=0;
         System.out.print("Result: d = " + d + ", x = "+ x +", y = "+ y);
      }
      while (b>0) {
         int q = a/b;
         int r = a-q*b;
         x = x2-q*x1;
         y = y2-q*y1;
         a = b;
         b = r;
         x2 = x1;
         x1 = x;
         y2 = y1;
         y1 = y;
        }
        int d=a;
        x=x2;
        y=y2;
        System.out.print("Result: d = " + d + ", x = "+ x +", y = "+ y);
   }
   public static void main (String args[])
   {
      //input two numbers is the non-negative integers
      Scanner scan = new Scanner(System.in);
      System.out.print("Please input number a: ");
		int numberA = scan.nextInt();
      System.out.print("Please input number b: ");
		int numberB = scan.nextInt();
      BT2_EuclideanMoRong euclid = new BT2_EuclideanMoRong();
      euclid.Euclid(numberA, numberB);
   }
}
