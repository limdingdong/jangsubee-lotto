package stringcalculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int MIN_NUMBER = 0;
    private static final int SINGLE_INPUT_LENGTH = 1;
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("[+-]?\\d*(\\.\\d+)?");
    private static final String TOKEN_DELIMITER = "[,|:]";

    public int add(final String text) {
        if (isNullOrEmpty(text)) {
            return MIN_NUMBER;
        }
        if (isSingleInputInteger(text)) {
            return Integer.parseInt(text);
        }

        return sum(text.split(TOKEN_DELIMITER));
    }

    private boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private boolean isSingleInputInteger(String text) {
        if (text.length() != SINGLE_INPUT_LENGTH) {
            return false;
        }
        return isInteger(text);
    }
    private boolean isInteger(String text) {
        return NUMERIC_PATTERN.matcher(text).matches();
    }
    private int sum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
