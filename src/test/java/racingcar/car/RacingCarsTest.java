package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.DriveValueGenerator;
import racingcar.util.SequentialDriveValueGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    @Test
    @DisplayName("문자열 리스트를 입력받고 RacingCars를 생성한다")
    void createTest() {
        List<String> carNames = Arrays.asList("a", "b", "c", "d");
        RacingCars.of(carNames);
    }

    @Test
    @DisplayName("자동차 경주 진행 테스트")
    void racingTest() {
        //given
        int testIdx = 0;
        int[] sequenceNumbers = {0, 3, 4, 9};
        int[] expectedDistance = {0, 0, 1, 1};
        DriveValueGenerator driveValueGenerator = new SequentialDriveValueGenerator(sequenceNumbers);
        List<String> carNames = Arrays.asList("a", "b", "c", "d");
        RacingCars racingCars = RacingCars.of(carNames);

        //when
        RacingResults racingResults = racingCars.race(driveValueGenerator);

        //then
        while (racingResults.hasNextResult()) {
            RacingCarInfo racingCarInfo = racingResults.nextResult();
            assertThat(racingCarInfo.getCarName()).isEqualTo(carNames.get(testIdx));
            assertThat(racingCarInfo.getDistance()).isEqualTo(expectedDistance[testIdx]);
            testIdx++;
        }
    }
}
