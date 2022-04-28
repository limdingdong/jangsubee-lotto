package stringcalculator;

public class StringCalculator {

    private static final int MIN_NUMBER = 0;
    public int add(String text) {
        if (isNullOrEmpty(text)) {
            return MIN_NUMBER;
        }
        return 0;
    }

    private boolean isNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }
}
