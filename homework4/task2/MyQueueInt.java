package homework4.task2;

import java.util.LinkedList;

public class MyQueueInt {

    private LinkedList<Integer> queue;

    public MyQueueInt() {
        queue = new LinkedList<>();
    }
    

    public void enqueue(int element){
        // Напишите свое решение ниже
        queue.add(element);
    }

    public int dequeue(){
        // Напишите свое решение ниже
        int element = queue.getFirst();
        queue.removeFirst();
        return element;
    }

    public int first(){
        // Напишите свое решение ниже
        return queue.getFirst();
    }

    public LinkedList<Integer> getElements() {
        // Напишите свое решение ниже
        return queue;
    }
}
