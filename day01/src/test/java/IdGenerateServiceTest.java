import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Random6 extends Random {
    @Override
    public int nextInt(int bound) {
        return 6;
    }
}

public class IdGenerateServiceTest {
    @Test
    public void getData() {
        Random stub = new Random6(); // Dependency
        IdGenerateService service
                = new IdGenerateService();
        // 2. Setter/field/property Injection
        service.setRandom(stub);
        String result = service.getData();
        assertEquals("CODE6", result);
    }
}