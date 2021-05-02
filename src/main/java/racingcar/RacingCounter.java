package racingcar;

import racingcar.car.RacingCars;
import racingcar.car.RacingResult;
import racingcar.car.RacingResults;
import racingcar.util.DriveValueGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingCounter {
    private static final int MIN_ATTEMPT_COUNT = 1;

    private int racingCount;
    private final RacingCars racingCars;
    private final DriveValueGenerator driveValueGenerator;

    public RacingCounter(int racingCount,
                         RacingCars racingCars,
                         DriveValueGenerator driveValueGenerator) {
        validateRacingCount(racingCount);
        this.racingCount = racingCount;
        this.racingCars = racingCars;
        this.driveValueGenerator = driveValueGenerator;
    }

    private void validateRacingCount(int racingCount) {
        if (racingCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
    }

    public RacingResults race() {
        List<RacingResult> racingResults = new ArrayList<>();
        while (racingCount >= MIN_ATTEMPT_COUNT) {
            racingResults.add(racingCars.race(driveValueGenerator));
            racingCount--;
        }
        return new RacingResults(racingResults);
    }
}
