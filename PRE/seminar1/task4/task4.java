// Напишите метод, который находит самую длинную строку общего
// префикса среди массива строк.
// Если общего префикса нет, вернуть пустую строку "".
package PRE.seminar1.task4;

import java.util.Scanner;

public class task4 {

    public static void main(String[] args) {
        int size = intputPositiveInteger("Enter array's size...");

        String[] strarr = fillStringArray(size);
        printArray(strarr);

        System.out.println(getCommonPrefix(strarr));
    }

    public static int intputPositiveInteger(String msg) {
        System.out.println(msg);

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int number = 0;

        while (flag) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number > 0) {
                    flag = false;
                }
            } else {
                sc.nextLine();
            }
            if (flag) {
                System.out.println("Enter correct positive integer number...");
            }
        }

        return number;
    }

    public static String[] fillStringArray(int size) {
        String[] starr = new String[size];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < starr.length; i++) {
            System.out.printf("Enter %d string of array...\n", i);
            starr[i] = sc.nextLine();
        }

        return starr;
    }

    public static  void printArray(String[] arr) {
        System.out.println("*******Output of String[]...*******");
        for (String str : arr) System.out.println(str);
        System.out.println("*******END OF OUTPUT*******");
    }

    public static String getCommonPrefix(String[] arr) {
        int min = arr[0].length();
        for (int i = 1; i < arr.length; i++) 
            if (arr[i].length() < min) min = arr[i].length();
        
        boolean flag = true;
        int i_end = 0;
        while(flag) {
            String str = arr[0].substring(0, ++i_end);
            for (int i = 1; i < arr.length; i++)
                if (!arr[i].startsWith(str)) flag = false;
        }
        
        return arr[0].substring(0, --i_end);
    }
}
