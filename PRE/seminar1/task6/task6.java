package PRE.seminar1.task6;

import java.util.Scanner;

public class task6 {

    public static void main(String[] args) {
        int a = inputInt("Введите основание степени...");
        int b = inputInt("Введите показатель степени...");

        System.out.printf("%d в степени %d равно %f\n", a, b, pow(a, b));
    }

    public static int inputInt(String msg) {
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

    public static double pow(int a, int b) {
        if (b < 0) {
            return 1 / pow(a, -b); 
        }else if (b == 0) {
            return 1; 
        }else {
            double res = pow(a, b/2);
            return (b%2 == 0) ? res*res : res*res*a;
        }
    }
}
