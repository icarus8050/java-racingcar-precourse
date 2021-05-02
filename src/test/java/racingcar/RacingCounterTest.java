package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.RacingCars;
import racingcar.car.RacingResults;
import racingcar.util.DriveValueGenerator;
import racingcar.util.SequentialDriveValueGenerator;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCounterTest {

    @Test
    @DisplayName("racingCount 만큼 경주 결과가 생성된다.")
    void racingCounter() {
        //given
        final int racingCount = 5;
        DriveValueGenerator driveValueGenerator = new SequentialDriveValueGenerator(new int[]{0, 1, 4, 9});
        RacingCars racingCars = RacingCars.of(asList("a", "b"));
        RacingCounter racingCounter = new RacingCounter(racingCount, racingCars, driveValueGenerator);

        //when
        RacingResults racingResults = racingCounter.race();

        //then
        assertThat(racingResults.getRacingResults().size()).isEqualTo(racingCount);
    }
}