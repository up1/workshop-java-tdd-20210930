import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IdGenerateServiceTest {

    @Test
    public void getData() {
        IdGenerateService service = new IdGenerateService();
        String result = service.getData();
        assertEquals("CODE6", result);
    }
}