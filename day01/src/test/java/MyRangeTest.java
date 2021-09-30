import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyRangeTest {

    @Test
    @DisplayName("ตัวแรกต้องเป็น [ (include) โดยที่ input = [1,5], result = true")
    public void case01() {
        // Arrange
        String input = "[1,5]";
        MyRange range = new MyRange(input);
        boolean result = range.startWithInclude();
        assertTrue(result);
    }

}
