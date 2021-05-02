package racingcar.view;

import racingcar.car.RacingCarInfo;
import racingcar.car.WinningCars;

import java.util.ArrayList;
import java.util.List;

public class WinningCarsOutputView {

    public void printWinningCars(WinningCars winningCars) {
        System.out.printf("%s가 최종 우승했습니다.%n", parseWinningCarsName(winningCars));
    }

    private String parseWinningCarsName(WinningCars winningCars) {
        List<String> carNames = new ArrayList<>();
        List<RacingCarInfo> cars = winningCars.getRacingCarInfos();
        for (RacingCarInfo car : cars) {
            carNames.add(car.getCarName());
        }
        return String.join(", ", carNames);
    }
}
