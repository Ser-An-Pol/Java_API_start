package Homework;
// Задана натуральная степень k. Сформировать случайным
// образом список коэффициентов (значения от 0 до 100)
// многочлена многочлен степени k.
// *Пример: k=2 => 2*x² + 4*x + 5 = 0 или x² + 5 = 0 или 10*x² = 0

import java.util.Random;
import java.util.Scanner;

/**
 * homework
 */
public class task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter polynomial degree...");
        int k = sc.nextInt();

        int[] coefficients = new int[k+1];
        
        fillArray(coefficients);
        System.out.println(generatePolynom(coefficients));

    }
    public static void  fillArray(int[] coefficients) {
        Random rnd = new Random();
        while (coefficients[0] == 0) coefficients[0] = rnd.nextInt(201)-100;
        for (int i = 1; i < coefficients.length; i++) {
            coefficients[i] = rnd.nextInt(201)-100;
        }
    }

    public static String generatePolynom(int[] coefficients) {
        StringBuilder str = new StringBuilder();
        for (int i = 0, pow = coefficients.length-1; 
                        i < coefficients.length; i++, pow--) {
            if (coefficients[i] == 0) continue;
            
            if (i == 0 && coefficients[i] < 0) str.append(" - ");
            if (i > 0) 
            {
                if (coefficients[i] > 0) str.append(" + ");
                else str.append(" - ");
            }
            
            int coef = Math.abs(coefficients[i]);
            if (coef != 1){
                str.append(coef);
                if (pow !=  0) str.append("*");
            }
            if (pow > 1) str.append("X^"+pow);
            else if (pow == 1) str.append("X");

        }
        str.append(" = 0");
        return str.toString();
    }
}