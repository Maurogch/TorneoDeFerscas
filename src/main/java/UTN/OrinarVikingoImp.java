package UTN;

import java.util.concurrent.ThreadLocalRandom;

public class OrinarVikingoImp implements Orinar {
    @Override
    public Integer Orinar() {
        return ThreadLocalRandom.current().nextInt(1, 100 + 1);
    }
}
