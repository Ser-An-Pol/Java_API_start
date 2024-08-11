package PRE.seminar2.task2;

/*
 * Напишите метод, который сжимает строку. 
Пример: aaaabbbcdd → a4b3cd2
 */
public class task2 {
    public static void main(String[] args) {
        System.out.println(archive("aaaabbbcdd"));
    }

    public static String archive(String str) {
        char tec = str.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();

        sb.append(tec);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == tec) {
                count++;
            }
            else {
                if (count > 1) sb.append(count);
                tec = str.charAt(i);
                sb.append(tec);
                count = 1;
                
            }
        }
        if (count > 1) sb.append(count);
        return sb.toString();
    }
}
