import java.util.Scanner;
import java.awt.Point;

public class Lab7_Playfair {

    private int length = 0;

    private String[][] matrix;

    private Lab7_Playfair() {

        System.out.println("Please input keyword:");
        Scanner sc = new Scanner(System.in);
        String keyword = parseString(sc);
        while (keyword.equals(""))
            keyword = parseString(sc);
        System.out.println();
        matrix = this.cipherMatrix(keyword);

        System.out.println("Please input plaintext:");
        String input = parseString(sc);
        while (input.equals(""))
            input = parseString(sc);
        System.out.println();

        String output = cipher(input);
        String decodedOutput = decode(output);

        this.printMatrix(matrix);
        this.printResults(output, decodedOutput);
    }

    private String parseString(Scanner s) {
        String parse = s.nextLine();
        parse = parse.toUpperCase();
        parse = parse.replaceAll("[^A-Z]", "");
        parse = parse.replace("J", "I");
        return parse;
    }

    private String[][] cipherMatrix(String key) {
        String[][] playfairTable = new String[5][5];
        String keyString = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        // tạo ma trận rỗng 5x5
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                playfairTable[i][j] = "";

        for (int k = 0; k < keyString.length(); k++) {
            boolean repeat = false;
            boolean used = false;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (playfairTable[i][j].equals("" + keyString.charAt(k))) {
                        repeat = true;
                    } else if (playfairTable[i][j].equals("") && !repeat && !used) {
                        playfairTable[i][j] = "" + keyString.charAt(k);
                        used = true;
                    }
                }
            }
        }
        return playfairTable;
    }

    private String cipher(String in) {
        length = (int) in.length() / 2 + in.length() % 2;

        for (int i = 0; i < (length - 1); i++) {
            // nếu 2 ký tự liên tiếp trong plaintext giống nhau thì chèn phần tử X vào giữa
            if (in.charAt(2 * i) == in.charAt(2 * i + 1)) {
                in = new StringBuffer(in).insert(2 * i + 1, 'X').toString();
                length = (int) in.length() / 2 + in.length() % 2;
            }
        }

        // thêm phần tử x vào cuối
        String[] digraph = new String[length];
        for (int j = 0; j < length; j++) {
            if (j == (length - 1) && in.length() / 2 == (length - 1))
                in = in + "X";
            digraph[j] = in.charAt(2 * j) + "" + in.charAt(2 * j + 1);
        }

        String out = "";
        String[] encDigraphs = new String[length];
        encDigraphs = encodeDigraph(digraph);
        for (int k = 0; k < length; k++)
            out = out + encDigraphs[k];
        return out;
    }

    private String[] encodeDigraph(String digraph[]) {
        String[] enc = new String[length];
        for (int i = 0; i < length; i++) {
            char a = digraph[i].charAt(0);
            char b = digraph[i].charAt(1);
            int row1 = (int) getPoint(a).getX();
            int row2 = (int) getPoint(b).getX();
            int column1 = (int) getPoint(a).getY();
            int column2 = (int) getPoint(b).getY();

            // nếu vị trí 2 ký tự cùng hàng, di chuyển tới cột bên phải
            if (row1 == row2) {
                column1 = (column1 + 1) % 5;
                column2 = (column2 + 1) % 5;

                // nếu vị trí 2 ký tự cùng cột, di chuyển tới hàng bên dưới
            } else if (column1 == column2) {
                row1 = (row1 + 1) % 5;
                row2 = (row2 + 1) % 5;

                // nếu khác hàng khác cột, đổi chỗ vị trí cột cho nhau
            } else {
                int temp = column1;
                column1 = column2;
                column2 = temp;
            }

            enc[i] = matrix[row1][column1] + "" + matrix[row2][column2];
        }
        return enc;
    }

    private String decode(String out) {
        String decoded = "";
        for (int i = 0; i < out.length() / 2; i++) {
            char a = out.charAt(2 * i);
            char b = out.charAt(2 * i + 1);
            int row1 = (int) getPoint(a).getX();
            int row2 = (int) getPoint(b).getX();
            int column1 = (int) getPoint(a).getY();
            int column2 = (int) getPoint(b).getY();
            if (row1 == row2) {
                column1 = (column1 + 4) % 5;
                column2 = (column2 + 4) % 5;
            } else if (column1 == column2) {
                row1 = (row1 + 4) % 5;
                row2 = (row2 + 4) % 5;
            } else {
                int temp = column1;
                column1 = column2;
                column2 = temp;
            }
            decoded = decoded + matrix[row1][column1] + matrix[row2][column2];
        }
        return decoded;
    }

    // trả về vị trí hàng, cột của ký tự
    private Point getPoint(char c) {
        Point pt = new Point(0, 0);
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (c == matrix[i][j].charAt(0))
                    pt = new Point(i, j);
        return pt;
    }

    private void printMatrix(String[][] printedMatrix) {
        System.out.println("Matrix:");
        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(printedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printResults(String enc, String dec) {
        System.out.println("This is the encoded message:");
        System.out.println(enc);
        System.out.println();
        System.out.println("This is the decoded message:");
        System.out.println(dec);
    }

    public static void main(String[] args) {
        Lab7_Playfair playfair = new Lab7_Playfair();
    }
}
