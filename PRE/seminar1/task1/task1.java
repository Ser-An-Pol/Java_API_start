// В консоли запросить имя пользователя. В зависимости от
// текущего времени, вывести приветствие вида
// "Доброе утро, <Имя>!", если время от 05:00 до 11:59
// "Добрый день, <Имя>!", если время от 12:00 до 17:59;
// "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
// "Доброй ночи, <Имя>!", если время от 23:00 до 4:59

package PRE.seminar1.task1;

import java.time.LocalTime;
import java.util.Scanner;


/**
 * task1
 */
public class task1 {

    public static void main(String[] args) {
        

        printGreetings(getName("Enter your name, please..."));

    }

    public static String getName(String msg)
    {
        Scanner cs = new Scanner(System.in);
        System.out.println(msg);

        return cs.nextLine();
    }

    public static void printGreetings(String name) 
    {
       int currentHour = LocalTime.now().getHour();

       if (currentHour < 5 || currentHour >= 23)
            System.out.printf("Доброй ночи, %s!\n", name);
        else if (currentHour < 12)
            System.out.printf("Доброе утро, %s!\n", name);
        else if (currentHour < 18)
            System.out.printf("Добрый день, %s!\n", name);
        else
            System.out.printf("Добрый вечер, %s!\n", name);
    }
}