import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class Lab08_TrapdoorKnapsack {

    // luu mang String duoc cat thanh cac khoi
    // for chay

    public static String[] formatString(String plaintext, int lenVector) {

        int lenPlaintext = plaintext.length();
        int n = lenVector - (lenPlaintext % lenVector);
        String zero = new String();
        String plaintext2 = new String();
        if (n > 0) {
            for (int z = 0; z < n; z++) {
                zero += 0;
            }
        }
        plaintext2 = zero + plaintext;
        System.out.println("Add/don't add 0: " + plaintext2);

        int lenArrayString = plaintext2.length() / lenVector;
        //System.out.println(lenArrayString);
        // System.out.println("Length of formated plaintext: " + plaintext2.length());
        String[] arrayStringPlaintext = new String[lenArrayString];
        int j = 0;
        int z = 0;
        int indexArray = 0;
        
        while (lenArrayString > 0) {
            String partsOfArray = new String();
            for (int i = indexArray; i < plaintext2.length(); i++) {
                partsOfArray += plaintext2.charAt(i);
                z++;
                if (z == lenVector) {
                    break;
                }
            }
            arrayStringPlaintext[j] = partsOfArray;
            j++;
            lenArrayString--;
            indexArray += lenVector;

        }

        return arrayStringPlaintext;

    }

    public static String createVectorAPrivate(int n) {
        String aPrivate = new String();
        int sum = 0;
        int randomint = 0;
        Random r = new Random();
        for (int count = 0; count < n;) {
            int m = 10 * count + 10;
            randomint = r.nextInt(m) + sum;
            if (randomint > sum) {
                aPrivate += randomint + " ";
                sum += randomint;
                count++;
            }

        }
        return aPrivate;
    }

    public static boolean isPrimeNumber(int n) {

        if (n < 2) {
            return false;
        }

        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    public static int findM(int n, int[] vectoAPrivate) {

        int sum = 0;

        for (int i = 0; i < vectoAPrivate.length; i++) {
            sum += vectoAPrivate[i];
        }

        int m = 200 * n + 10; // giới hạn giá trị random
        Random generator = new Random();
        int valueRandom = generator.nextInt(m);
        int valueM = 0;
        for (int i = 0; i < 2;) {
            if (valueRandom > sum && (isPrimeNumber(valueRandom))) {
                valueM = valueRandom;
                i++;
            } else {
                valueRandom = generator.nextInt(m);
            }
        }
        return valueM;
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
        else {

            if (x < 0) {
                while (x < 0) {
                    x += 26;
                }
            }
            return x; // Có phần tử nghịch đảo là x
        }

    }

    public static int findOmega(int m) {
        int omega = 0;
        Random generator = new Random();
        int valueRandom = generator.nextInt(m);
        for (int i = 0; i < 2;) {
            if (isPrimeNumber(valueRandom)) {
                omega = valueRandom;
                i++;
            } else {
                valueRandom = generator.nextInt(m);
            }
        }
        return omega;
    }

    public static String createVectorAPublic(String[] vectorAPrivate, int omega, int m) {
        String aPublic = new String();
        int temp = 0;
        for (int i = 0; i < vectorAPrivate.length; i++) {
            int tempInt = Integer.parseInt(vectorAPrivate[i]);
            temp = (tempInt * omega) % m;
            aPublic += temp + " ";
        }

        return aPublic;
    }

    public static int findOmegaModularMultiplicativeInverse(int omega, int m) {
        int omegaInverse = EuclideanMoRong(omega, m);
        return omegaInverse;
    }

    public static void writeToFilePrivateKey(String fileName, String vectorAPr, int valueM, int valueOmega)
            throws IOException {

        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("Private key (a’, m, ⍵):");
        printWriter.println("a’: " + vectorAPr);
        printWriter.println("m: " + valueM);
        printWriter.println("⍵: " + valueOmega);
        printWriter.close();
    }

    public static void writeToFilePublicKey(String fileName, String vectorAPu) throws IOException {

        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("Public key a:");
        printWriter.println("a: " + vectorAPu);
        printWriter.close();
    }

    public static void writeToFileCipher(String fileName, String cipher) throws IOException {

        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("M = " + cipher);
        printWriter.close();
    }

    public static String readFilePlainText(String fileName) {
        String thisLine = null;
        String text = new String();
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream(fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            while ((thisLine = bufferedReader.readLine()) != null) {
                text += thisLine;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public static int encrypt(String plaintext, String[] vectorAPublic, int m) {
        int result = 0;

        for (int index = 0; index < plaintext.length(); index++) {
            String p = new String();
            int ai = 0;
            int xi = 0;
            int len = 0;
            p += plaintext.charAt(index);
            xi = Integer.parseInt(p);
            len = index % vectorAPublic.length;
            ai += Integer.parseInt(vectorAPublic[len]);
            result += (xi * ai);
        }
        return result;
    }

    public static String decrypt(int valueDecrypt, String[] vectorAPrivate, int omegaInverse, int valueM) {

        String result = new String();
        String strX = new String();
        String result2 = new String();
        int tDecrypt = (valueDecrypt * omegaInverse) % valueM;
        System.out.println("Value T' = " + tDecrypt);
        int sum = 0;
        int temp = tDecrypt;
        while (sum < tDecrypt) {

            for (int i = vectorAPrivate.length - 1; i > -1; i--) {
                int ai = Integer.parseInt(vectorAPrivate[i]);

                temp = temp - ai;
                if (temp >= 0) {
                    strX += 1;
                    sum += ai;
                    continue;
                }
                if (temp < 0) {
                    strX += 0;
                    temp = temp + ai;
                    continue;
                }

            }

        }
        String zero = new String();
        StringBuffer stringBuffer = new StringBuffer(strX);
        result = stringBuffer.reverse().toString();

        int len = vectorAPrivate.length - result.length();
        if (len > 0) {
            for (int z = 0; z < len; z++) {
                zero += 0;
            }
        }

        result2 = zero + result;
        if (result2.length() != 0) {
            result = result2;
        }

        return result;

    }

    public static void main(String args[]) throws IOException {

        String filePrivateKey = "D:\\Downloads\\TrapdoorKnapsack_PrivateKey.txt";
        String filePublicKey = "D:\\Downloads\\TrapdoorKnapsack_PublicKey.txt";
        String filePlaintext = "D:\\Downloads\\TrapdoorKnapsack_Plaintext.txt";
        String fileInputN = "D:\\Downloads\\TrapdoorKnapsack_InputN.txt";
        String fileCipher = "D:\\Downloads\\TrapdoorKnapsack_Cipher.txt";

        String number = readFilePlainText(fileInputN);
        int numberOfLenVector = Integer.parseInt(number);

        // String aPr = createVectorAPrivate(numberOfLenVector);
        // String[] vectorAPrivate = aPr.split("\\s+");
        // String vectorAPr = Arrays.toString(vectorAPrivate);
        // System.out.println("The private vector a’: " + vectorAPr);

        // int[] valueVectorAPrivate = StringArrToIntArr(vectorAPrivate);
        // int valueM = findM(numberOfLenVector, valueVectorAPrivate);
        // System.out.println("m: " + valueM);

        // int valueOmega = findOmega(valueM);
        // System.out.println("⍵: " + valueOmega);

        // writeToFilePrivateKey(filePrivateKey, vectorAPr, valueM, valueOmega);

        // String aPu = createVectorAPublic(vectorAPrivate, valueOmega, valueM);
        // String[] vectorAPublic = aPu.split("\\s+");
        // String vectorAPu = Arrays.toString(vectorAPublic);
        // System.out.println("The public vector a: " + vectorAPu);

        // writeToFilePublicKey(filePublicKey, vectorAPu);

        String plaintext = readFilePlainText(filePlaintext);
        System.out.println("The plaintext: " + plaintext);
        String[] formatVector = formatString(plaintext, numberOfLenVector);
        String str = Arrays.toString(formatVector);
        System.out.println(str);
        // int t = encrypt(plaintext, vectorAPublic, valueM);
        // System.out.println("T = " + t);

        // //int preDecodeT = t % valueM;
        // int omegaInverse = findOmegaModularMultiplicativeInverse(valueOmega, valueM);
        // System.out.println("⍵’ = " + omegaInverse);

        // String M = decrypt(t, vectorAPrivate, omegaInverse, valueM);
        // System.out.println("M = " + M);

        // writeToFileCipher(fileCipher, M);

    }
}
