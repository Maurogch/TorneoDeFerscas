package UTN;

import java.util.concurrent.ThreadLocalRandom;

public class BeberVikingoImp implements Beber {

    @Override
    public Integer Beber() {
        return ThreadLocalRandom.current().nextInt(1, 80 + 1); //advantage
    }
}
