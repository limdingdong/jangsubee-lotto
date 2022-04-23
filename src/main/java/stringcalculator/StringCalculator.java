package stringcalculator;

import java.util.Arrays;

public class StringCalculator {



    public StringCalculator() {
    }

    public int calculate(String str){

        if(str == null || str.equals("")){
            return 0;
        }

        if(isDigit(str)){
            return Integer.valueOf(str);
        }


        String[] split = str.split(getDelimiter(str));

        if(!Arrays.stream(split).allMatch(this::isDigit)){
            throw new RuntimeException();
        }


        return Arrays.stream(split).mapToInt(Integer::valueOf).sum();

    }

    private String getDelimiter(String str) {

        if(!str.contains("//") && !str.contains("\\n")){
            return ":|,";
        }

        int start  = str.indexOf("//");
        int end    = str.indexOf("\\n")-start;

        String customDelimiter = str.substring(start, end);

        return customDelimiter;
    }

    private boolean isDigit(String str){
        return str.chars().allMatch(value -> Character.isDigit(value));
    }
}
