package homework4.task3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    public Deque<Double> resultsStack = new ArrayDeque<>();
    public double prevResult;

    public double calculate(char op, int a, int b) {
        // Напишите свое решение ниже
        double result = 0;
        switch (op) {
            case '+':
                result = a*1d + b;
                resultsStack.add(result);
                break;
            case '-':
                result = a*1d - b;
                resultsStack.add(result);
                break;
            case '*':
                result = a*1d * b;
                resultsStack.add(result);
                break;
            case '/':
                result = a*1d / b;
                resultsStack.add(result);
                break;
            case '<':
                resultsStack.removeLast();
                result = resultsStack.getLast();
                break;
        }
        return result;
    }
}
