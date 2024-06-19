package PRE.seminar1.task5;

public class task5 {

    public static void main(String[] args) {
        String str = "Добро пожаловать на курс по Java";

        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]+ " ");
        }

        return sb.toString();
    }
}
