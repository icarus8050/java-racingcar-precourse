package racingcar.view;

import racingcar.car.RacingCarInfo;
import racingcar.car.RacingResult;
import racingcar.car.RacingResults;

public class RacingResultsOutputView {

    public void printRacingResults(RacingResults racingResults) {
        System.out.println();
        System.out.println("실행 결과");
        for (RacingResult racingResult : racingResults.getRacingResults()) {
            printRacingResult(racingResult);
        }
    }

    private void printRacingResult(RacingResult racingResult) {
        for (RacingCarInfo racingCarInfo : racingResult.getRacingCarInfos()) {
            System.out.printf("%s : %s%n", racingCarInfo.getCarName(), toDashForCount(racingCarInfo.getDistance()));
        }
        System.out.println();
    }

    private String toDashForCount(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
