package stringCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String string){

        if(string == null || string.isEmpty()){
            return 0;
        }

        String[] arrayOfNumbers = separateString(string);

        checkForNegativeNumbers(arrayOfNumbers);

        return sumArray(arrayOfNumbers);
    }

    private void checkForNegativeNumbers(String[] numbersList) {
        String negatives = Arrays.stream(numbersList)
                .filter(s -> s.contains("-"))
                .collect(Collectors.joining(","));

        if(!negatives.isEmpty()){
            throw new IllegalArgumentException("Negative not allowed: " + negatives);
        }
    }

    private String[] separateString(String string){
        String[] out;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(string);
        if(m.find()){
            String customDelimiter = m.group(1);
            out = m.group(2).split(customDelimiter);
        }else{
            out = string.split(",|:");
        }
        return out;
    }

    private int sumArray(String[] arrayOfNumbers){
        return Arrays.stream(arrayOfNumbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
