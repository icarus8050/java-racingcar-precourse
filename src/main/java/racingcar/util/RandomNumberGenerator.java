package racingcar.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {

    public static int generate() {
        return ThreadLocalRandom.current().nextInt(9) + 1;
    }
}
