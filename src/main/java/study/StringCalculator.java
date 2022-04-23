package study;

import org.junit.platform.commons.util.StringUtils;

import java.util.StringTokenizer;

public class StringCalculator {

    public int add(String text) {
        int sum = 0;
        if (StringUtils.isBlank(text)) {
            return 0;
        }

        if (text.length() == 1) {
            return Integer.parseInt(text);
        }

        StringTokenizer st = new StringTokenizer(text, ",|:");
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }

        return sum;
    }
}
