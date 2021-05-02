package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
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

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("입력 값이 4 미만인 경우 멈춤")
    void stopCarTest(int driveValue) {
        RacingCar racingCar = RacingCar.of("abc");
        racingCar.drive(driveValue);

        assertThat(racingCar.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("입력 값이 4 이상인 경우 전진")
    void driveCarTest(int driveValue) {
        RacingCar racingCar = RacingCar.of("abc");
        racingCar.drive(driveValue);

        assertThat(racingCar.getDistance()).isEqualTo(1);
    }
}
