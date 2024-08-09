

//PARAMS = {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS){
        // Напишите свое решение ниже
        StringBuilder sb = new StringBuilder(QUERY);
        Pattern pattern = Pattern.compile("\".+?\":\".+?\"");
        Matcher matcher = pattern.matcher(PARAMS);

        String add = " ";
        while (matcher.find()) {
            //sb.append(" + " + PARAMS.substring(matcher.start(), matcher.end()).replace("\"", ""));
            String[] str = PARAMS.substring(matcher.start(), matcher.end()).replace("\"", "").split(":");
            if (!str[1].equals("null")) {
                sb.append(add + str[0] + "=\'" + str[1] + "\'");
                if (add.isBlank()) add = " and ";
            }
        }
        
        return sb;
    }
}
