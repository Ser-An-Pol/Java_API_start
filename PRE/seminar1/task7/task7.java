// На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть
// две команды
// - команда 1 (к1): увеличить в с раза, а умножается на c
// - команда 2 (к2): увеличить на d ( +2 ), к a прибавляется d
// Написать программу, которая выдаёт набор команд, позволяющий число a
// превратить в число b или сообщить, что это невозможно
// Пример 1: а = 1, b = 7, c = 1, d = 3
// ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1.
// Пример 2: а = 11, b = 7, c = 2, d = 1
// ответ: “”. 
package PRE.seminar1.task7;

import java.util.Scanner;

public class task7 {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        //int a = 2, b = 44, c = 2, d = 7;
        System.out.println("There are two positive integer numbers: a and b.\nAnd there are two operators: K1 and K2\n" +
                            "Operator K1: a -> a*c, where c is integer number more than 1.\n" + 
                            "Operator K2: a -> a + d, where d is positive integer number.\n" +
                            "We try to find the sequence of operators (K1 and K2), which transform a to b.");
        int a = inputPositiveInt("Enter value of a...");
        int b = inputPositiveInt("Enter value of b...");
        int c = inputMore1Int("Enter value of c (>1)...");
        int d = inputPositiveInt("Enter value of d...");

        if (findDecision(a, b, c, d)) {
            System.out.println(sb.toString()); 
        }else {
            System.out.println("No way");
        }

    }

    public static int inputPositiveInt(String msg) {
        System.out.println(msg);
        boolean flag = true;
        int num = 0;
        Scanner sc = new Scanner(System.in);

        while (flag) {
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                flag = false;
            } else {
                System.out.println("Enter correct integer number...");
                sc.nextLine();
            }
        }
        return num;
    }

    public static int inputMore1Int(String msg) {
        System.out.println(msg);
        boolean flag = true;
        int num = 0;
        Scanner sc = new Scanner(System.in);

        while (flag) {
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                if (num > 1) flag = false;
                else System.out.println("Number can't be equaled to 1");
            } else {
                System.out.println("Enter correct integer number...");
                sc.nextLine();
            }
        }
        return num;
    }

    public static int K1(int a, int c) {
        return a * c;
    }

    public static int K2(int a, int d) {
        return a + d;
    }

    public static boolean findDecision(int a, int b, int c, int d) {
        if (a == b) return true;
        else if (a > b) return false;
        else if (findDecision(K1(a, c), b, c, d)) {
            sb.insert(0, "K1 ");
            return true;
        } 
        else if (findDecision(K2(a, d), b, c, d)) {
            sb.insert(0, "K2 ");
            return true;
        } 
        else return false;
    }

}
