package stringcalculator;

public class UnsignedInteger {

    private static final int MIN_NUMBER = 0;

    private UnsignedInteger() {}

    public static int parseInt(String s) throws NumberFormatException {
        int intValue = Integer.parseInt(s);
        if (intValue < MIN_NUMBER) {
            throw new NumberFormatException();
        }
        return intValue;
    }
}
