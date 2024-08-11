package PRE.seminar2.task1;
/*
 * Дано четное число N (>0) и строки c1 и c2, которые следует учитывать как 1 символ. 
Написать метод, который вернет строку длины N*2, к
оторая состоит из чередующихся последовательностей c1 и c2, начиная с c1.
 */
public class task1 {
    public static void main(String[] args) {
    
        System.out.println(concatC1C2N("c1", "c2", 15000));    
    }

    public static String concatC1C2N(String c1, String c2, int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(c1);
            sb.append(c2);
        }
        return sb.toString();
    }
}
