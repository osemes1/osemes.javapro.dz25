public class ArrayUtils {

    public static int[] extractElementsAfterLastFour(int[] array) {
        int lastIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                lastIndex = i;
            }
        }

        if (lastIndex == -1) {
            throw new RuntimeException("Array must contain at least one '4'");
        }

        int[] result = new int[array.length - lastIndex - 1];
        System.arraycopy(array, lastIndex + 1, result, 0, array.length - lastIndex - 1);
        return result;
    }

    public static boolean hasOneAndFour(int[] array) {
        boolean hasOne = false;
        boolean hasFour = false;

        for (int num : array) {
            if (num == 1) {
                hasOne = true;
            }
            if (num == 4) {
                hasFour = true;
            }
        }

        return hasOne && hasFour && containsOnlyOneAndFourTogether(array);
    }

    private static boolean containsOnlyOneAndFourTogether(int[] array) {
        boolean containsOnlyOneAndFourTogether = true;
        for (int num : array) {
            if (num != 1 && num != 4) {
                containsOnlyOneAndFourTogether = false;
                break;
            }
        }
        return containsOnlyOneAndFourTogether;
    }
}
