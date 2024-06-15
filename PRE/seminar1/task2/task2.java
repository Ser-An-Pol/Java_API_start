
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести
// максимальное количество подряд идущих 1.
public class task2 {

    public static void main(String[] args) {
        int size = getInt("Enter array's size...");
        
        int[] binArray = generateBinaryArray(size);

        System.out.println(Arrays.toString(binArray));
        System.out.printf("Maximum length of sequence of '1' is %d.\n", getNonZeroLength(binArray));
    }

    public static int getInt(String msg) {
        Scanner sc = new Scanner(System.in);

        System.out.println(msg);
        int number = 0;
        boolean flag = true;

        while (flag) {
            try {
                number = sc.nextInt();
                if (number < 1) {
                    throw new Exception(); 
                }else {
                    flag = false;
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Enter correct positive integer number...");
                sc.nextLine();
            }
        }
        return number;
    }

    public static int[] generateBinaryArray(int size)
    {
        int[] array = new int[size];
        Random rnd =  new Random();

        for (int i = 0; i < array.length; i++) array[i] = rnd.nextInt(2);

        return array;
    }

    public static int getNonZeroLength(int[] array)
    {
        int count = 0, max = 0;
        for (int i = 0; i < array.length; i++) 
            if (array[i] == 1) count++;
            else
            {
                if (count > max) max = count;
                count = 0;
            }
        return (max > count) ? max : count;
    }

}
