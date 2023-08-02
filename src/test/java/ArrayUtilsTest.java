import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTest {

    @Test
    public void testExtractElementsAfterLastFour() {
        int[] input1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] expected1 = {1, 7};
        Assertions.assertArrayEquals(expected1, ArrayUtils.extractElementsAfterLastFour(input1));

        int[] input2 = {4, 3, 2, 1};
        int[] expected2 = {3, 2, 1};
        Assertions.assertArrayEquals(expected2, ArrayUtils.extractElementsAfterLastFour(input2));

        int[] input3 = {4, 4, 4, 4};
        int[] expected3 = {};
        Assertions.assertArrayEquals(expected3, ArrayUtils.extractElementsAfterLastFour(input3));

        // Test case without any '4'
        int[] input4 = {1, 2, 3, 1, 2, 3};
        Assertions.assertThrows(RuntimeException.class, () -> ArrayUtils.extractElementsAfterLastFour(input4));
    }
    @Test
    public void testHasOneAndFour() {
        int[] input1 = {1, 1, 1, 4, 4, 1, 4, 4};
        Assertions.assertTrue(ArrayUtils.hasOneAndFour(input1));

        int[] input2 = {1, 1, 1, 1, 1, 1};
        Assertions.assertFalse(ArrayUtils.hasOneAndFour(input2));

        int[] input3 = {4, 4, 4, 4};
        Assertions.assertFalse(ArrayUtils.hasOneAndFour(input3));

        int[] input4 = {1, 4, 4, 1, 1, 4, 3};
        Assertions.assertFalse(ArrayUtils.hasOneAndFour(input4));
    }
}
