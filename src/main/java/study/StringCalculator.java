package study;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int ZERO = Integer.MIN_VALUE;
    private static final int ONE_LENGTH = 1;
    private static final int CUSTOMER_DELIMITER_INDEX = 1;
    private static final int NUMBER_INDEX = 2;
    private static final String CUSTOM_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String SLASH = "/";
    private static final int NOT_FOUND_TEXT = -1;

    public int add(String text) {
        int sum = ZERO;

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
        StringTokenizer st = new StringTokenizer(text, CUSTOM_DELIMITER);
        while (st.hasMoreTokens()) {
            int inputNumber = Integer.parseInt(st.nextToken());
            checkNegativeNumber(inputNumber);
            sum += inputNumber;
        }
        return sum;
    }

    private Integer calculateSumByCustomDelimiter(String text) {
        int resultNumber = 0;
        Matcher m = CUSTOM_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOMER_DELIMITER_INDEX);
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
        return text.indexOf(SLASH) != NOT_FOUND_TEXT;
    }
}
