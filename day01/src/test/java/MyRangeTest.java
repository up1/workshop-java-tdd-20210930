import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("ตัวแรกต้องเป็น [ (include) โดยที่ input = (1,5], result = false")
    public void case02() {
        // Arrange
        String input = "(1,5]";
        MyRange range = new MyRange(input);
        boolean result = range.startWithInclude();
        assertFalse(result);
    }

    @Test
    @DisplayName("ตัวเลขเริ่มต้น เป็น 1 input = [1,5], result = 1")
    public void case03() {
        String input = "[1,5]";
        MyRange range = new MyRange(input);
        int result = range.getStart();
        assertEquals(1, result);
    }

}
