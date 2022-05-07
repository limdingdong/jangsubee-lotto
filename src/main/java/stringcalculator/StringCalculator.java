package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int MIN_NUMBER = 0;
    private static final int SINGLE_INPUT_LENGTH = 1;
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("[+-]?\\d*(\\.\\d+)?");
    private static final String TOKEN_DELIMITER = "[,|:]";

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_DELIMITER_INPUT_INDEX = 2;

    private StringCalculator() {}

    public static int add(final String text) {
        if (isNullOrEmpty(text)) {
            return MIN_NUMBER;
        }
        if (isSingleInputInteger(text)) {
            return Integer.parseInt(text);
        }
        return sum(split(text));
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static boolean isSingleInputInteger(String text) {
        if (text.length() != SINGLE_INPUT_LENGTH) {
            return false;
        }
        return isInteger(text);
    }

    private static boolean isInteger(String text) {
        return NUMERIC_PATTERN.matcher(text).matches();
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            return splitByCustomDelimiter(matcher);
        }
        return text.split(TOKEN_DELIMITER);
    }

    private static String[] splitByCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
        return matcher.group(CUSTOM_DELIMITER_INPUT_INDEX).split(customDelimiter);
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(UnsignedInteger::parseInt)
                .sum();
    }
}
