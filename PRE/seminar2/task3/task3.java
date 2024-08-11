package PRE.seminar2.task3;

/*
 * 
 * Напишите метод, который принимает на вход строку (String) и определяет 
 * является ли строка палиндромом (возвращает boolean значение).
 */

public class task3 {
    public static void main(String[] args) {
        String str = "Коту тащат уток";
        if (isPolyndrom(str))
            System.out.println("\'" + str + "\' - полиндром");
        else
            System.out.println("\'" + str + "\' - не полиндром");
    }

    public static boolean isPolyndrom(String str) {
        boolean res = true;
        String str1 = str.toLowerCase();
        int i = 0, j = str1.length() - 1; 

        while (i < j && res) {
            if (str1.charAt(i++) != str1.charAt(j--)) res = false;
        }
        return res;
    }
}
