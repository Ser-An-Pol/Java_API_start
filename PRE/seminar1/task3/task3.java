// Дан массив nums = [3,2,2,3] и число val = 3.
// Если в массиве есть числа, равные заданному, нужно перенести
// эти элементы в конец массива.
// Таким образом, первые несколько (или все) элементов массива
// должны быть отличны от заданного, а остальные - равны ему.
package PRE.seminar1.task3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task3 {

    public static void main(String[] args) {
        int size = getPositiveInteger("Enter array's size...");
        int minRange = 0, maxRange = 5;
        int[] array = generateArray(size, minRange, maxRange);
        //int[] array = {2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,1};

        System.out.println(Arrays.toString(array));

        String str = String.format("Enter integer number from range [%d, %d]", minRange, maxRange);

        int value = getIntegerFromRange(str, minRange, maxRange);

        reoderArray(array, value);
        System.out.println(Arrays.toString(array));
    }

    public static int getPositiveInteger(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        int number = 0;
        boolean flag = true;

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

    public static int getIntegerFromRange(String msg, int minRange, int maxRange) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        int number = 0;
        boolean flag = true;

        while (flag) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number >= minRange && number <= maxRange) {
                    flag = false;
                }
            } else {
                sc.nextLine();
            }
            if (flag) {
                System.out.println("Not correct input - try again: \n" + msg);
            }
        }
        return number;
    }

    public static int[] generateArray(int size, int minRange, int maxRange) {
        int[] array = new int[size];
        Random rnd = new Random();
        maxRange++;

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(minRange, maxRange);
        }

        return array;
    }

    public static void reoderArray(int[] array, int value) {
        int activeEnd = array.length - 1;
    
        int tmp;

        for (int i = 0; i < activeEnd; i++) 
            if (array[i] == value)
            {
                while (activeEnd > i && array[activeEnd] == value) activeEnd--;
                if (activeEnd > i)
                {
                    tmp = array[activeEnd];
                    array[activeEnd] = array[i];
                    array[i] = tmp;
                    activeEnd--;
                }
            }
    }
}
