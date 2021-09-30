import java.util.Random;

public class IdGenerateService {

    private MyRandom random;

    public void setRandom(MyRandom random) {
        this.random = random;
    }

    public String getData() {
        int id = random.nextInt(10);
        return "CODE" + id;
    }

}
