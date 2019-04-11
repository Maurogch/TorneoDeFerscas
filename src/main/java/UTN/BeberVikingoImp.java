package UTN;

import java.util.concurrent.ThreadLocalRandom;

public class BeberVikingoImp implements Beber {
    @Override
    public Integer Beber() {
        /*int r1 = ThreadLocalRandom.current().nextInt(1, 200 + 1);
        int r2 = ThreadLocalRandom.current().nextInt(1, 200 + 1);

        if(r1<r2){
            int aux = r1;
            r1 = r2;
            r2 = aux;
        }

        double d = (double)((r1-5)/r1)*r2;
        int res = (int)d;

        return res;*/

        return ThreadLocalRandom.current().nextInt(1, 100 + 1) - 10;
    }
}
