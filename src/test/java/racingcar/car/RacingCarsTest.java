package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.DriveValueGenerator;
import racingcar.util.SequentialDriveValueGenerator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

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
        int[] sequenceNumbers = {0, 3, 4, 9};
        List<Integer> expectedDistance = Arrays.asList(0, 0, 1, 1);
        DriveValueGenerator driveValueGenerator = new SequentialDriveValueGenerator(sequenceNumbers);
        List<String> carNames = Arrays.asList("a", "b", "c", "d");
        RacingCars racingCars = RacingCars.of(carNames);

        //when
        RacingResults racingResults = racingCars.race(driveValueGenerator);

        //then
        List<RacingCarInfo> racingCarInfos = racingResults.getRacingCarInfos();
        List<Integer> actual = racingCarInfos.stream()
                .map(RacingCarInfo::getDistance)
                .collect(toList());

        assertIterableEquals(expectedDistance, actual);
    }
}
