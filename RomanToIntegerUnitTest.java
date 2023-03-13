import org.junit.Test;
import static org.junit.Assert.*;

public class RomanToIntegerUnitTest {

    @Test
    public void testRomanToInt() {
        RomanToInteger romanToInteger = new RomanToInteger();

        // Test valid input
        assertEquals(2, romanToInteger.romanToInt("II"));
        assertEquals(4, romanToInteger.romanToInt("IV"));
        assertEquals(8, romanToInteger.romanToInt("VIII"));
        assertEquals(89, romanToInteger.romanToInt("LXXXIX"));
        assertEquals(92, romanToInteger.romanToInt("XCII"));
        assertEquals(3, romanToInteger.romanToInt("III"));
        assertEquals(4, romanToInteger.romanToInt("IV"));
        assertEquals(9, romanToInteger.romanToInt("IX"));
        assertEquals(58, romanToInteger.romanToInt("LVIII"));
        assertEquals(1994, romanToInteger.romanToInt("MCMXCIV"));

        // Test invalid input
        try {
            romanToInteger.romanToInt("XIU");
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Roman numeral symbol: U", e.getMessage());
        }

        try {
            romanToInteger.romanToInt("IVAI");
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Roman numeral symbol: A", e.getMessage());
        }

        try {
            romanToInteger.romanToInt("MMMCMXCIJ");
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Roman numeral symbol: J", e.getMessage());
        }
    }
}
