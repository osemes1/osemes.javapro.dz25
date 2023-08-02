import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleMathLibraryTest {

    @Test
    public void testAdd() {
        SimpleMathLibrary mathLibrary = new SimpleMathLibrary();
        double result = mathLibrary.add(2.0, 3.0);
        Assertions.assertEquals(5.0, result, "Addition failed");
    }

    @Test
    public void testMinus() {
        SimpleMathLibrary mathLibrary = new SimpleMathLibrary();
        double result = mathLibrary.minus(5.0, 3.0);
        Assertions.assertEquals(2.0, result, "Subtraction failed");
    }
}
