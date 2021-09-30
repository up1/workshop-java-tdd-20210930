import java.util.Random;

public class IdGenerateService {

    private Random random;

    public void setRandom(Random random) {
        this.random = random;
    }

    public String getData() {
        int id = random.nextInt(10);
        return "CODE" + id;
    }

}
