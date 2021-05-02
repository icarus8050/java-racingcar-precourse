package racingcar;

import racingcar.car.RacingCars;
import racingcar.car.RacingResults;
import racingcar.car.WinningCars;
import racingcar.util.DriveValueGenerator;
import racingcar.view.AttemptCountUserInputView;
import racingcar.view.CarNameUserInputView;
import racingcar.view.RacingResultsOutputView;
import racingcar.view.WinningCarsOutputView;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class RacingGame {
    private final Scanner scanner;
    private final CarNameUserInputView carNameUserInputView;
    private final AttemptCountUserInputView attemptCountUserInputView;
    private final DriveValueGenerator driveValueGenerator;
    private final RacingResultsOutputView racingResultsOutputView;
    private final WinningCarsOutputView winningCarsOutputView;

    public RacingGame(Scanner scanner,
                      CarNameUserInputView carNameUserInputView,
                      AttemptCountUserInputView attemptCountUserInputView,
                      DriveValueGenerator driveValueGenerator,
                      RacingResultsOutputView racingResultsOutputView,
                      WinningCarsOutputView winningCarsOutputView) {
        this.scanner = scanner;
        this.attemptCountUserInputView = attemptCountUserInputView;
        this.carNameUserInputView = carNameUserInputView;
        this.driveValueGenerator = driveValueGenerator;
        this.racingResultsOutputView = racingResultsOutputView;
        this.winningCarsOutputView = winningCarsOutputView;
    }

    public void start() {
        RacingCars racingCars = inputCarNamesAndCreateRacingCars();
        RacingCounter racingCounter = inputRacingCountAndCreateRacingCounter(racingCars);
        RacingResults racingResults = racingCounter.race();
        printRacingResults(racingResults);
        WinningCars winningCars = racingResults.electWinningCars();
        winningCarsOutputView.printWinningCars(winningCars);
    }

    private RacingCars inputCarNamesAndCreateRacingCars() {
        Optional<RacingCars> racingCars = Optional.empty();
        while (!racingCars.isPresent()) {
            List<String> carNames = carNameUserInputView.inputCarNames(scanner);
            racingCars = createRacingCars(carNames);
        }
        return racingCars.get();
    }

    private Optional<RacingCars> createRacingCars(List<String> carNames) {
        try {
            return Optional.of(RacingCars.of(carNames));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private RacingCounter inputRacingCountAndCreateRacingCounter(RacingCars racingCars) {
        Optional<RacingCounter> racingCounter = Optional.empty();
        while (!racingCounter.isPresent()) {
            racingCounter = createRacingCounter(racingCars);
        }
        return racingCounter.get();
    }

    private Optional<RacingCounter> createRacingCounter(RacingCars racingCars) {
        try {
            int racingCount = attemptCountUserInputView.inputAttemptCount(scanner);
            RacingCounter racingCounter = new RacingCounter(racingCount, racingCars, driveValueGenerator);
            return Optional.of(racingCounter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private void printRacingResults(RacingResults racingResults) {
        racingResultsOutputView.printRacingResults(racingResults);
    }


}
