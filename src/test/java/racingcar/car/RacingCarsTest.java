package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RacingCarsTest {

    @Test
    @DisplayName("문자열 리스트를 입력받고 RacingCars를 생성한다")
    void createTest() {
        List<String> carNames = Arrays.asList("a", "b", "c", "d");
        RacingCars.of(carNames);
    }
}
