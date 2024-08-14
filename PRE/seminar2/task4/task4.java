package PRE.seminar2.task4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class task4 {
    public static void main(String[] args) {
        writeToFile(repeat100("TEST"), "test.log");
    }

    public static String repeat100(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 100; i++) 
            sb.append(str);

        return sb.toString();
    }

    public static void writeToFile(String str, String name) {
        File file = new File(name);

        try (FileWriter fw = new FileWriter(file)) {
            fw.append(str);
            fw.flush();
        }
        catch (IOException e) {
            System.out.println("Error of writing to file");
        }
    }
}
