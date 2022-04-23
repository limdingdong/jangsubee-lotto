package study;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int ZERO = 0;
    private static final int ONE_LENGTH = 1;
    private static final int CUSTOMER_DELEMITER_INDEX = 1;
    private static final int NUMBER_INDEX = 2;

    public int add(String text) {
        int sum = 0;

        if (StringUtils.isBlank(text)) {
            return ZERO;
        }

        if (text.length() == ONE_LENGTH) {
            int inputNumber = Integer.parseInt(text);
            checkNegativeNumber(inputNumber);
            return inputNumber;
        }

        if (hasCustomDelimiterNumber(text)) {
            sum = calculateSumByCustomDelimiter(text);
        }

        if (!hasCustomDelimiterNumber(text)) {
            sum = calculateSumByCommaOrColon(text, sum);
        }

        return sum;
    }

    private void checkNegativeNumber(int number) {
        if (number < ZERO) {
            throw new RuntimeException();
        }
    }

    private int calculateSumByCommaOrColon(String text, int sum) {
        StringTokenizer st = new StringTokenizer(text, ",|:");
        while (st.hasMoreTokens()) {
            int inputNumber = Integer.parseInt(st.nextToken());
            checkNegativeNumber(inputNumber);
            sum += inputNumber;
        }
        return sum;
    }

    private Integer calculateSumByCustomDelimiter(String text) {
        int resultNumber = 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOMER_DELEMITER_INDEX);
            String[] tokens = m.group(NUMBER_INDEX).split(customDelimiter);
            resultNumber = Arrays.stream(tokens)
                    .mapToInt(it -> {
                        int inputNumber = Integer.parseInt(it);
                        checkNegativeNumber(inputNumber);
                        return inputNumber;
                    })
                    .sum();
        }
        return resultNumber;
    }

    private boolean hasCustomDelimiterNumber(String text) {
        return text.indexOf("/") != -1;
    }
}
