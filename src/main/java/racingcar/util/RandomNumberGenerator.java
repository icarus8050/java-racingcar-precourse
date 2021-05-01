package racingcar.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements DriveValueGenerator {

    public int generate() {
        return ThreadLocalRandom.current().nextInt(9) + 1;
    }
}
