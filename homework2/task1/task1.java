package homework2.task1;

public class task1 {
    public static void main(String[] args) {
        StringBuilder sb = Answer.answer("select * from students where", "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ");
        System.out.println(sb.toString());
    }
}
