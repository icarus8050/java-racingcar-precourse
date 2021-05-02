package racingcar.car;

import java.util.List;

public class RacingResults {

    private final List<RacingResult> racingResults;
    private final int LAST_RESULT_INDEX;

    public RacingResults(List<RacingResult> racingResults) {
        this.racingResults = racingResults;
        LAST_RESULT_INDEX = racingResults.size() - 1;
    }

    public List<RacingResult> getRacingResults() {
        return racingResults;
    }

    public WinningCars electWinningCars() {
        RacingResult lastRacingResult = racingResults.get(LAST_RESULT_INDEX);
        return lastRacingResult.electWinningCars();
    }
}
