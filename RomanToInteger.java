import java.util.HashMap;

/**
 * Convert Roman to Integer using left-to-right pass method
 */
public class RomanToInteger {

    static HashMap<String, Integer> romanIntegerMap = new HashMap<>();

    static {
        romanIntegerMap.put("M", 1000);
        romanIntegerMap.put("D", 500);
        romanIntegerMap.put("C", 100);
        romanIntegerMap.put("L", 50);
        romanIntegerMap.put("X", 10);
        romanIntegerMap.put("V", 5);
        romanIntegerMap.put("I", 1);
    }

    /**
     * Converts a given Roman numeral string to an integer value.
     * @param stringInput the Roman numeral string to be converted
     * @return the integer value representing the given Roman numeral string
     * @throws IllegalArgumentException if the given string contains invalid    Roman numeral symbols
     */
    public int romanToInt(String stringInput) throws IllegalArgumentException {
        int integerSum = 0;
        int i = 0;
        while (i < stringInput.length()) {
            String currentSymbol = stringInput.substring(i, i + 1);
            if (!romanIntegerMap.containsKey(currentSymbol)) {
                throw new IllegalArgumentException("Invalid Roman numeral symbol: " + currentSymbol);
            }
            int currentValue = romanIntegerMap.get(currentSymbol);

            int nextValue = 0;
            if (i + 1 < stringInput.length()) {
                String nextSymbol = stringInput.substring(i + 1, i + 2);
                if (!romanIntegerMap.containsKey(nextSymbol)) {
                    throw new IllegalArgumentException("Invalid Roman numeral symbol: " + nextSymbol);
                }
                nextValue = romanIntegerMap.get(nextSymbol);
            }

            if (currentValue < nextValue) {
                integerSum += (nextValue - currentValue);
                i += 2;
            } else {
                integerSum += currentValue;
                i += 1;
            }

        }

        return integerSum;
    }
}
