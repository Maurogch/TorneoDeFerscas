package UTN.Behaviours;

import UTN.Interfaces.Beber;

import java.util.concurrent.ThreadLocalRandom;

public class BeberEspartanoImp implements Beber {

    @Override
    public Integer Beber() {
        return ThreadLocalRandom.current().nextInt(1, 100 + 1);
    }
}
