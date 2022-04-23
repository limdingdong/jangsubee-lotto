package study;

import org.junit.platform.commons.util.StringUtils;

public class StringCalculator {

    public int add(String text) {
        if(StringUtils.isBlank(text)){
            return 0;
        }

        if(text.length() == 1){
            return Integer.parseInt(text);
        }
        return 0;
    }
}
