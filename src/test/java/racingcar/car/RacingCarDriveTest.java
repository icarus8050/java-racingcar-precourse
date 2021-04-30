package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarDriveTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("입력 값이 4 이상일 경우 전진")
    void driveTest(int value) {
        RacingCar racingCar = RacingCar.of("abc");
        racingCar.drive(value);
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("입력 값이 3 이하일 경우 멈춤")
    void stopTest(int value) {
        RacingCar racingCar = RacingCar.of("abc");
        racingCar.drive(value);
        assertThat(racingCar.getDistance()).isEqualTo(0);
    }
}
