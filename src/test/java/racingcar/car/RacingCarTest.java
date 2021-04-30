package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde"})
    @DisplayName("생성되는 자동차의 이름은 5자 이하")
    void createCarTest(String carName) {
        RacingCar.of(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("생성되는 자동차의 이름 길이가 0 또는 6 이상이면 예외")
    void failedCreationCarTest(String invalidCarName) {
        assertThrows(IllegalArgumentException.class, () -> RacingCar.of(invalidCarName));
    }
}
