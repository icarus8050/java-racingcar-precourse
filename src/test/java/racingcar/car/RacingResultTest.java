package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {

    @Test
    @DisplayName("단독 우승한 차량 선출 테스트")
    void electWinningCarTest() {
        List<RacingCarInfo> participants = Arrays.asList(
                new RacingCarInfo("a", 5),
                new RacingCarInfo("b", 1),
                new RacingCarInfo("c", 6),
                new RacingCarInfo("d", 5)
        );
        RacingResult racingResult = new RacingResult(participants);
        WinningCars winningCars = racingResult.electWinningCars();

        List<RacingCarInfo> racingCarInfos = winningCars.getRacingCarInfos();
        for (RacingCarInfo racingCarInfo : racingCarInfos) {
            assertThat(racingCarInfo.getCarName()).isEqualTo("c");
            assertThat(racingCarInfo.getDistance()).isEqualTo(6);
        }
    }

    @Test
    @DisplayName("공동 우승한 차량 선출 테스트")
    void electWinningCarsTest() {
        List<RacingCarInfo> participants = Arrays.asList(
                new RacingCarInfo("a", 6),
                new RacingCarInfo("b", 1),
                new RacingCarInfo("c", 6),
                new RacingCarInfo("d", 5)
        );
        RacingResult racingResult = new RacingResult(participants);
        WinningCars winningCars = racingResult.electWinningCars();

        List<RacingCarInfo> racingCarInfos = winningCars.getRacingCarInfos();
        for (RacingCarInfo racingCarInfo : racingCarInfos) {
            assertThat(racingCarInfo.getCarName()).isIn("a", "c");
            assertThat(racingCarInfo.getDistance()).isEqualTo(6);
        }
    }
}