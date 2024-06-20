// Задан массив, например, nums = [1,7,3,6,5,6].
// Написать программу, которая найдет индекс i для этого массива
// такой, что сумма элементов с индексами < i равна сумме
// элементов с индексами > i. 
package PRE.seminar1.task8;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task8 {

    public static void main(String[] args) {
        int size = inputIntMore2("Enter array's size (more than 2)");
        int median;
        int[] array;

        do {
            array = generateAndFillArray(size);//{1, 2, 3, 7, 5, 6, 7};
            median = findMedian(array);
        } while (median < 0);
        System.out.println(Arrays.toString(array));
        System.out.printf("Median of this array index %d\n", median);
    }

    public static int inputIntMore2(String msg) {
        System.out.println(msg);
        boolean flag = true;
        int num = 0;
        Scanner sc = new Scanner(System.in);

        while (flag) {
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                if (num > 2) {
                    flag = false;
                } else {
                    System.out.println("Number must be more than 2!");
                }
            } else {
                System.out.println("Enter correct integer number...");
                sc.nextLine();
            }
        }
        return num;
    }

    public static int[] generateAndFillArray(int size) {
        int[] array = new int[size];
        Random rnd = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = rnd.nextInt(-99, 100);
        }
        return array;
    }

    public static int findMedian(int[] array) {
        int leftSum = array[0];
        int rigthSum = 0;
        int end = array.length - 1;
        for (int i = 2; i <= end; i++) {
            rigthSum += array[i];
        }

        for (int i = 1; i < end; i++) {
            if (leftSum == rigthSum) {
                return i;
            } else {
                rigthSum -= array[i + 1];
                leftSum += array[i];
            }
        }
        return -1;
    }
}
