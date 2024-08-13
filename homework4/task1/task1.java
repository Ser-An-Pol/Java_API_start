package homework4.task1;

import java.util.LinkedList;

public class task1 {

    public static void main(String[] args) {
        LinkedList<Object> ll = new LinkedList<>();

        ll.add(1);
        ll.add("One");
        ll.add(2);
        ll.add("Two");

        System.out.println(ll);
        revertLL(ll);
        System.out.println(ll);
    }

    public static void revertLL(LinkedList<Object> ll) {
        // Напишите свое решение ниже
        for (int i = ll.size() - 1; i >=0; i--) {
            ll.add(ll.get(i));
            ll.remove(i);
        }
    }
}
