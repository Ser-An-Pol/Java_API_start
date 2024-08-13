package homework3.task2;

import java.util.ArrayList;

public class task2 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        removeEvenNumbers(arr);
    }

    public static void removeEvenNumbers(Integer[] arr) {
        // Введите свое решение ниже
  
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            if (arr[i] % 2 != 0) list.add(arr[i]);

        System.out.println(list);
      }
}
