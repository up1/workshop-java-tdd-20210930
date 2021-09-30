import java.util.Random;

public class IdGenerateService {

    public String getData() {
        // Dependency
        Random random = new Random();
        int id = random.nextInt(10);
        // Result
        return "CODE" + id;
    }

}
