package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultsTest {

    @Test
    @DisplayName("우승 결과는 가장 마지막 결과를 가지고 선출한다")
    void electWinningCarsTest() {
        //given
        List<String> expected = Arrays.asList("a", "c");
        List<RacingCarInfo> firstRacingCarInfos = Arrays.asList(
                new RacingCarInfo("a", 1),
                new RacingCarInfo("b", 1),
                new RacingCarInfo("c", 1),
                new RacingCarInfo("d", 1)
        );
        List<RacingCarInfo> secondRacingCarInfos = Arrays.asList(
                new RacingCarInfo("a", 5),
                new RacingCarInfo("b", 2),
                new RacingCarInfo("c", 5),
                new RacingCarInfo("d", 4)
        );
        RacingResult firstRacingResult = new RacingResult(firstRacingCarInfos);
        RacingResult secondRacingResult = new RacingResult(secondRacingCarInfos);

        RacingResults racingResults = new RacingResults(Arrays.asList(
                firstRacingResult,
                secondRacingResult)
        );

        //when
        WinningCars winningCars = racingResults.electWinningCars();

        //then
        List<RacingCarInfo> winningRacingCars = winningCars.getRacingCarInfos();
        for (RacingCarInfo winningRacingCar : winningRacingCars) {
            assertThat(winningRacingCar.getCarName()).isIn("a", "c");
        }
    }
}