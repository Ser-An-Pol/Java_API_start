import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * task1
 */
public class task1 {

    public static void main(String[] args) throws Exception {
        float e = 12.32f;
        double pi = 3.1415;
        System.out.println(e);
        System.out.println(pi);

        char ch = '1';
        System.out.println(Character.isDigit(ch)); //true
        ch = 'a';
        System.out.println(Character.isDigit(ch)); //false

        ch = '{';
        System.out.println(ch); // {
        ch = 123;
        System.out.println(ch); // {

        boolean flag1 = 123 <= 234;
        System.out.println(flag1); // true
        boolean flag2 = 123 >= 234;
        System.out.println(flag2); // false
        boolean flag3 = flag1 ^ flag2; // исключающее или
        System.out.println(flag3); // true

        String msg = "Hello, World!";
        System.out.println(msg);

        var i = 123; // неявная типизация. i - на этапе компиляции будет определен как int
        System.out.println(i);
        System.out.println(getType(i)); // Integer
        var d = 123.456;
        System.out.println(d);
        System.out.println(getType(d)); // Double

        int ii = 23_324_543;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        int a = 5;
        int b = 2;
        System.out.println(a | b); // 101 | 010 = 111 = 7
        System.out.println(a & b); // 101 & 010 = 000 = 0
        System.out.println(a ^ b); // 101 ^ 010 = 111 = 7

        int[] arr = new int[10];
        System.out.println(arr[3]); // 0 - значение по умолчанию
        System.out.println(arr.length); // 10

        arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(arr.length); // 5

        int brr[]; // так тоже можно 

        int[] arr1[] = new int[3][5];
        for (int[] line : arr1) {
            for (int item : line) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }

        int[][] arr2 = new int[3][5];
        for (int j = 0; j < arr2.length; j++) {
            for (int j2 = 0; j2 < arr2[j].length; j2++) {
                System.out.printf("%d ", arr2[j][j2]);
            }
            System.out.println();
        }

        //int[] ar = new int[10];
        //double[] dr = ar; // Нельзя - ИЗУЧАЕМ ковариантность и контрвариантность
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("name: ");
        String name = iScanner.nextLine();
        System.out.printf("Hello, %s\n", name);
        iScanner.close();

        int aa = 1, bb = 2;
        int cc = aa + bb;
        String res = String.format("%d + %d = %d \n", aa, bb, cc);
        System.out.printf("%d + %d = %d \n", aa, bb, cc);
        System.out.println(res);

        float Pi = 3.1415f;
        System.out.printf("%f\n", Pi);
        System.out.printf("%.2f\n", Pi);
        System.out.printf("%.3f\n", Pi);
        System.out.printf("%e\n", Pi);
        System.out.printf("%.2e\n", Pi);
        System.out.printf("%.3e\n", Pi);

        int aaa = 123;
        switch (aaa) {
            case 1:
            case 2:
                System.out.println("a");
                break;
            case 3:
                System.out.println("b");
                break;
            default:
                System.out.println("End switch");
        }

        while (true) {
            break;
        }

        do {
            break;
        } while (true);

        for (int j = 0; j < arr2.length; j++) {
            break;
        }

        for (int[] js : arr2) {
            break;
        }

        try (FileWriter fw = new FileWriter("file.txt", false)) {
            fw.write("line 1");
            fw.append('\n');
            fw.append('2');
            fw.append('\n');
            fw.write("line 3");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        FileReader fr = new FileReader("file.txt");
        int c;
        while ((c = fr.read()) != -1) {
            char ch1 = (char)c;
            if (ch1 == '\n') System.out.print(ch1);
            else System.out.print(ch1);
        }
        System.out.println();

        
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        String str1;
        while ((str1 = br.readLine()) != null) {
            System.out.printf("==%s==\n", str1);
        }
        br.close();

    }

    static String getType(Object o) {
        return o.getClass().getSimpleName();
    }
}
