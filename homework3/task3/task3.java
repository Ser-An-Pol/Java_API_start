package homework3.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class task3 {
    public static void main(String[] args) {
        Integer[] arr = {4, 2, 7, 5, 1, 3, 8, 6, 9};
        
        analyzeNumbers(arr);
    }

    public static void analyzeNumbers(Integer[] arr) {
        // Введите свое решение ниже
  
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

        Collections.sort(list);

        System.out.println(list);
        System.out.printf("Minimum is %s\n", list.getFirst());
        System.out.printf("Maximum is %s\n", list.getLast());

        int Average = 0;
        for (Integer arr1 : arr) {
            Average += arr1;
        }
        System.out.printf("Average is %s\n", Average*1d/list.size());

    }
}
