package Homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

;

public class task2 {

    public static void main(String[] args) throws Exception {

        StringBuilder polynom1 = readPolynom("polynom1.txt");
        StringBuilder polynom2 = readPolynom("polynom2.txt");

        int[] coefficients1 = getPolynom(polynom1);
        int[] coefficients2 = getPolynom(polynom2);

        //System.out.println(Pattern.matches("[+-] [^ ]+? ", "+ X^3 "));
        int[] sum = sumPolynoms(coefficients1, coefficients2);
        System.out.println(task1.generatePolynom(sum));
    }

    public static int[] sumPolynoms(int[] pol1, int[] pol2) {
        int lengthMAX, lengthMIN;
        boolean flag;
        if (pol1.length > pol2.length) {
            lengthMAX = pol1.length;
            lengthMIN = pol2.length;
            flag = true;
        } else {
            lengthMAX = pol2.length;
            lengthMIN = pol1.length;
            flag = false;
        }
        int[] result = new int[lengthMAX];

        for (int i = 1; i <= lengthMIN; i++) {
            result[result.length - i]
                    = pol1[pol1.length - i] + pol2[pol2.length - i];
        }
        for (int i = lengthMIN + 1; i <= lengthMAX; i++) {
            result[result.length - i] = (flag) ? pol1[pol1.length - i] : pol2[pol2.length - i];
        }

        return result;
    }

    public static StringBuilder readPolynom(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder polynom = new StringBuilder(br.readLine());
        br.close();

        return polynom;
    }

    public static int[] getPolynom(StringBuilder str) throws Exception {

        //StringBuilder str = 
        //    new StringBuilder("- 12*X^15 + 64*X^9 - 67*X^8 + 2*X^7 + 38*X^6 - 90*X^5 + 92*X^4 + X^3 - 3*X^2 + 71*X + 31");
        if (str.charAt(0) != '-') {
            str.insert(0, "+ ");
        }
        str.append(' ');
        Pattern pat = Pattern.compile("[+-] [^ ]+? ");
        Matcher matcher = pat.matcher(str);
        if (!matcher.find()) {
            throw new Exception("Error!");
        }
        String uni = str.substring(matcher.start(), matcher.end()).strip();
        int[] coef = new int[getDegree(uni) + 1];
        coef[0] = getCoefficient(uni);

        while (matcher.find()) {
            //System.out.println(str.substring(matcher.start(), matcher.end()));
            uni = str.substring(matcher.start(), matcher.end()).strip();
            if (uni.strip().equals("")) {
                continue;
            }
            coef[coef.length - getDegree(uni) - 1] = getCoefficient(uni);
        }

        System.out.println(Arrays.toString(coef));

        return coef;
    }

    public static int getDegree(String uninomial) {
        int ind1;
        int pow;

        ind1 = uninomial.indexOf("^");
        if (ind1 > 0) {
            pow = Integer.parseInt(uninomial.substring(ind1 + 1));
        } else if (uninomial.contains("X")) {
            pow = 1;
        } else {
            pow = 0;
        }

        return pow;
    }

    public static int getCoefficient(String uninomial) {
        int coefficient;

        int ind = uninomial.indexOf("*");
        if (ind > 0) {
            coefficient = Integer.parseInt(uninomial.substring(2, ind));
        } else if (uninomial.contains("X")) {
            coefficient = 1;
        } else {
            coefficient = Integer.parseInt(uninomial.substring(2));
        }

        if (uninomial.charAt(0) == '-') {
            coefficient *= (-1);
        }

        return coefficient;
    }

}
// "([+-] )?\\d*(\\*?X(\\^\\d*)?)?"
// 19*X^23
