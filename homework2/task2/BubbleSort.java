package homework2.task2;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class BubbleSort {

    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas) {

        boolean flag = true;
        int i = mas.length;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        log = new File("log.txt");
        try {
            fileWriter = new FileWriter(log);
            while (flag) {
                flag = false; i--;
                for (int j = 0; j < i; j++) {
                    if (mas[j] > mas[j + 1]) {
                        swap(mas, j, j + 1);
                        flag = true;
                    }
                }
                fileWriter.write(LocalDateTime.now().format(dtf) + " " + Arrays.toString(mas) + "\n");

            }
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void swap(int[] mas, int a, int b) {
        int tmp = mas[a];
        mas[a] = mas[b];
        mas[b] = tmp;
    }
}
